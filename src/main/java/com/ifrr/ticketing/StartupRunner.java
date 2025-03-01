package com.ifrr.ticketing;

import com.ifrr.ticketing.entities.Perfil;
import com.ifrr.ticketing.entities.Usuario;
import com.ifrr.ticketing.service.ServiceDispositivo;
import com.ifrr.ticketing.service.ServiceEspacio;
import com.ifrr.ticketing.service.ServiceIncidencia;
import com.ifrr.ticketing.service.ServicePerfil;
import com.ifrr.ticketing.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

@Component
@EntityScan(basePackages = "com.ifrr.ticketing.entities")
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ServiceUsuario su;
    @Autowired
    private ServicePerfil sp;
    @Autowired
    private ServiceEspacio se;
    @Autowired
    private ServiceDispositivo sd;
    @Autowired
    private ServiceIncidencia si;

    @Override
    public void run(String... args) throws Exception {
        Perfil usuarioP = sp.getPerfilByTipo("Usuario");
        if (usuarioP == null) {
            usuarioP = sp.createPerfil(new Perfil("Usuario"));
        }
        Perfil tecnicoP = sp.getPerfilByTipo("Técnico");
        if (tecnicoP == null) {
            tecnicoP = sp.createPerfil(new Perfil("Técnico"));
        }
        Perfil gestorP = sp.getPerfilByTipo("Gestor");
        if (gestorP == null) {
            gestorP = sp.createPerfil(new Perfil("Gestor"));
        }
        Perfil administradorP = sp.getPerfilByTipo("Administrador");
        if (administradorP == null) {
            administradorP = sp.createPerfil(new Perfil("Administrador"));
        }

        Usuario tecnico = su.getByNombreLogin("tecnico");
        if (tecnico == null) {
            tecnico = new Usuario("tecnico", "tecnico", "Tecnico", "tecnico@tecnico.t", 777777777);
            tecnico = su.createUsuario(tecnico, new Integer[]{tecnicoP.getId()});
        }

        Usuario gestor = su.getByNombreLogin("gestor");
        if (gestor == null) {
            gestor = new Usuario("gestor", "gestor", "Gestor", "gestor@gestor.g", 666666666);
            gestor = su.createUsuario(gestor, new Integer[]{gestorP.getId()});
        }

        Usuario user = su.getByNombreLogin("user");
        if (user == null) {
            user = new Usuario("user", "user", "User", "user@user.u", 555555555);
            user = su.createUsuario(user, new Integer[]{usuarioP.getId()});
        }

        Usuario admin = su.getByNombreLogin("admin");
        if (admin == null) {
            admin = new Usuario("admin", "admin", "Admin", "admin@admin.a", 444444444);
            admin = su.createUsuario(admin, new Integer[]{administradorP.getId()});
        }
        /*
        Usuario izan = new Usuario("izanga11", "soy_tontopwd", "Izan Calvo", "izan@calvo.ca", 192168111);
        izan = su.createUsuario(izan, new Integer[]{tecnicoP.getId()});
        Usuario fran = new Usuario("fran", "franpw", "Fran Chino", "fran@chino.cn", 111111111);
        fran = su.createUsuario(fran, new Integer[]{usuarioP.getId()});
        Usuario rodri = new Usuario("rodri", "rodripw", "Rodrigo Andrés", "rodri@racco.on", 222222222);
        rodri = su.createUsuario(rodri, new Integer[]{gestorP.getId()});
        Usuario roberto = new Usuario("rober", "roberpw", "Roberto Javier Plasencia", "rober@to.reagge", 333333333);
        roberto = su.createUsuario(roberto, new Integer[]{administradorP.getId()});

        Espacio clase = new Espacio("DAM2");
        clase = se.createEspacio(clase);
        Espacio clase2 = new Espacio("DAM1");
        clase2 = se.createEspacio(clase2);
        Espacio clase3 = new Espacio("DAW1");
        clase3 = se.createEspacio(clase3);
        Espacio clase4 = new Espacio("DAW2");
        clase4 = se.createEspacio(clase4);
        Dispositivo pc41 = new Dispositivo("PC", "HP", "ProDesk", "PC41");
        pc41 = sd.createDispositivo(pc41);
        Dispositivo pc42 = new Dispositivo("PC", "HP", "ProDesk", "PC42");
        pc42 = sd.createDispositivo(pc42);
        Dispositivo pc43 = new Dispositivo("PC", "HP", "ProDesk", "PC43");
        pc43 = sd.createDispositivo(pc43);
        Dispositivo pc44 = new Dispositivo("PC", "HP", "ProDesk", "PC44");
        pc44 = sd.createDispositivo(pc44);

        Incidencia cambiafondos = new Incidencia(LocalDate.now().toString(), LocalDate.now().plusDays(4).toString(), "cerrada sin éxito", "Queja", rodri, fran, izan, "Hay alguien que me cambia el fondo cuando no estoy mirando", "Lo intentamos matar pero se escapó");
        cambiafondos.setEspacio(clase);
        cambiafondos.setDispositivo(pc42);
        cambiafondos = si.createIncidencia(cambiafondos);

        System.out.println("============================PREFABS LOADED============================");
        System.out.println(tecnicoP);
        System.out.println(gestorP);
        System.out.println(usuarioP);
        System.out.println(administradorP);
        System.out.println(izan);
        System.out.println(fran);
        System.out.println(rodri);
        System.out.println(roberto);
        System.out.println(clase);
        System.out.println(pc42);
        System.out.println(cambiafondos);
        System.out.println("=======================================================================");
        */
    }

}
