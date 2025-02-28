package com.ifrr.ticketing;

import com.ifrr.ticketing.service.ServiceEspacio;
import com.ifrr.ticketing.service.ServiceIncidencia;
import com.ifrr.ticketing.service.ServiceDispositivo;
import com.ifrr.ticketing.service.ServicePerfil;
import com.ifrr.ticketing.service.ServiceUsuario;
import com.ifrr.ticketing.swing.AdministradorForm;
import com.ifrr.ticketing.swing.GestorForm;
import com.ifrr.ticketing.swing.Login;
import com.ifrr.ticketing.swing.TecnicoForm;
import com.ifrr.ticketing.swing.UsuarioForm;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EntityScan(basePackages = "com.ifrr.ticketing.entities")
public class TicketingApplication {

    private static boolean isJFrameOpen = true;

    private final ServiceUsuario su;
    private final ServicePerfil sp;
    private final ServiceIncidencia si;
    private final ServiceEspacio se;
    private final ServiceDispositivo sd;

    @Autowired
    public TicketingApplication(ServiceUsuario su, ServicePerfil sp, ServiceIncidencia si, ServiceEspacio se, ServiceDispositivo sd) {
        this.su = su;
        this.sp = sp;
        this.sd = sd;
        this.se = se;
        this.si = si;
    }

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(TicketingApplication.class, args);
        while (isJFrameOpen) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("JFrame closed. Exiting application.");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void launchLoginDialog() {
        SwingUtilities.invokeLater(() -> {
            Login loginDialog = new Login(null,su,sp);
            loginDialog.setVisible(true);
            
            
            if (loginDialog.isLoginSuccessful()) {
                openMainForm(loginDialog.getPerfilUsuario(),loginDialog.getIdUsuario());
            } else {
                System.exit(0);
            }
        });
    }

    private void openMainForm(String perfil, Integer id) {
        JFrame mainFrame = switch (perfil) {
            case "Usuario" ->
                new UsuarioForm(sd, se, su, si, id);
            case "Técnico" ->
                new TecnicoForm(si, id);
            case "Gestor" ->
                new GestorForm(su, si, id);
            case "Administrador" ->
                new AdministradorForm(su, si,sd,se);
            default ->
                null;
        };

        if (mainFrame != null) {
            mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            mainFrame.setVisible(true);

            mainFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isJFrameOpen = false;
                    System.exit(0);
                }
            });
        } else {
            System.err.println("Error: Perfil not recognized!");
            System.exit(1);
        }
    }
}
