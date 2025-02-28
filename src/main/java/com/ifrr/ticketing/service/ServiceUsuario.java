package com.ifrr.ticketing.service;

import com.ifrr.ticketing.entities.Perfil;
import com.ifrr.ticketing.entities.Usuario;
import com.ifrr.ticketing.repository.RepositoryPerfil;
import com.ifrr.ticketing.repository.RepositoryUsuario;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceUsuario {

    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @Autowired
    private RepositoryPerfil repositoryPerfil;

    @Transactional
    public Usuario createUsuario(Usuario usuario, Integer[] perfilIds) {

        Set<Perfil> perfiles = new HashSet<>();
        for (Integer id : perfilIds) {
            Perfil perfil = repositoryPerfil.findById(id).orElseThrow(() -> new IllegalArgumentException("Perfil not found"));
            perfiles.add(perfil);
        }

        usuario.setPerfiles(perfiles);

        return repositoryUsuario.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return repositoryUsuario.findAll();
    }

    public Usuario getUsuarioById(Integer id) {
        return repositoryUsuario.findById(id).orElse(null);
    }
    
    public Usuario getByNombreLogin(String nombreLogin) {
        return repositoryUsuario.getByNombreLogin(nombreLogin);
    }

    public Usuario updateUsuario(Usuario updatedUsuario) {
        return repositoryUsuario.save(updatedUsuario);
    }

    public void deleteUsuario(Integer id) {
        repositoryUsuario.deleteById(id);
    }

    public void deleteUsuarioByLogin(String nombreLogin) {
        // Find the user by login (nombreLogin)
        Usuario usuario = repositoryUsuario.getByNombreLogin(nombreLogin);

        if (usuario != null) {
            // Delete the user from the repository
            repositoryUsuario.delete(usuario);
        } 
    }

}
