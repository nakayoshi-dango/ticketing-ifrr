package com.ifrr.ticketing.service;

import com.ifrr.ticketing.entities.Perfil;
import com.ifrr.ticketing.repository.RepositoryPerfil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePerfil {

    @Autowired
    private RepositoryPerfil repositoryPerfil;

    public Perfil createPerfil(Perfil perfil) {
        return repositoryPerfil.save(perfil);
    }

    public List<Perfil> getAllPerfiles() {
        return repositoryPerfil.findAll();
    }

    public Perfil getPerfilById(Integer id) {
        return repositoryPerfil.findById(id).orElse(null);
    }

    public Perfil getPerfilByTipo(String tipo) {
        return repositoryPerfil.findByTipo(tipo).orElse(null);
    }

    public Perfil updatePerfil(Perfil updatedPerfil) {
        return repositoryPerfil.save(updatedPerfil);
    }

    public void deletePerfil(Integer id) {
        repositoryPerfil.deleteById(id);
    }

}
