/*package com.ifrr.ticketing;

import com.ifrr.ticketing.entities.Dispositivo;
import com.ifrr.ticketing.entities.Espacio;
import com.ifrr.ticketing.entities.Incidencia;
import com.ifrr.ticketing.entities.Perfil;
import com.ifrr.ticketing.entities.Usuario;
import com.ifrr.ticketing.service.ServiceDispositivo;
import com.ifrr.ticketing.service.ServiceEspacio;
import com.ifrr.ticketing.service.ServiceIncidencia;
import com.ifrr.ticketing.service.ServicePerfil;
import com.ifrr.ticketing.service.ServiceUsuario;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback(value = true)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TicketingApplicationTests {

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

    Incidencia incidencia;

    void deleteExistingUsuarios() {
        // Logic to delete users from the database based on 'nombre_login'
        su.deleteUsuarioByLogin("izanga11");
        su.deleteUsuarioByLogin("fran");
        su.deleteUsuarioByLogin("rodri");
        su.deleteUsuarioByLogin("rober");
    }

    @BeforeAll
    void setup() {
        Perfil tecnicoP = sp.getPerfilByTipo("Técnico");
        if (tecnicoP == null) {
            tecnicoP = sp.createPerfil(new Perfil("Técnico"));
        }
        Perfil gestorP = sp.getPerfilByTipo("Gestor");
        if (gestorP == null) {
            gestorP = sp.createPerfil(new Perfil("Gestor"));
        }
        Perfil usuarioP = sp.getPerfilByTipo("Usuario");
        if (usuarioP == null) {
            usuarioP = sp.createPerfil(new Perfil("Usuario"));
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
        Dispositivo pc42 = new Dispositivo("PC", "HP", "ProDesk", "PC42");
        pc42 = sd.createDispositivo(pc42);

        Incidencia cambiafondos = new Incidencia(LocalDate.now().toString(), LocalDate.now().plusDays(4).toString(), "cerrada sin éxito", "Queja" , rodri, fran, izan, "Hay alguien que me cambia el fondo cuando no estoy mirando", "Lo intentamos matar pero se escapó");
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
        System.out.println(admin);
        System.out.println(clase);
        System.out.println(pc42);
        System.out.println(cambiafondos);
        System.out.println("=======================================================================");

    }

    @Test
    void testGetAllUsuarios() {
        List<Usuario> users_sqlite = su.getAllUsuarios();
        Assertions.assertTrue(!users_sqlite.isEmpty());
        for (Usuario usuario : users_sqlite) {
            System.out.println(usuario);
        }
    }

    @Test
    void testCountUsuarios() {
        List<Usuario> users_sqlite = su.getAllUsuarios();
        Assertions.assertEquals(4, users_sqlite.size());
    }

    @Test
    void testCountPerfiles() {
        List<Perfil> profiles_sqlite = sp.getAllPerfiles();
        Assertions.assertEquals(4, profiles_sqlite.size());
    }

    @Test
    void rodriExists() {
        List<Usuario> users_sqlite = su.getAllUsuarios();
        boolean rodriExists = false;
        for (Usuario usuario : users_sqlite) {
            if (usuario.getNombreLogin().equals("rodri") && usuario.getPerfiles().size() == 1) {
                rodriExists = true;
            }
        }
        Assertions.assertTrue(rodriExists);
    }

    @Test
    void isIncidenciaRight() {
        boolean integrity = false;
        List<Incidencia> incidencias_sqlite = si.getAllIncidencias();
        Incidencia incidencia_sqlite = incidencias_sqlite.get(1);
        System.out.println(incidencia_sqlite);
        System.out.println(incidencia);
        if (incidencia.equals(incidencia_sqlite)) {
            integrity = true;
        }
        Assertions.assertTrue(integrity);
    }
}
*/