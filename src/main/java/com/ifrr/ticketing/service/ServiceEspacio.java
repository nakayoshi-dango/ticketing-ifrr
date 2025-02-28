package com.ifrr.ticketing.service;

import com.ifrr.ticketing.entities.Espacio;
import com.ifrr.ticketing.repository.RepositoryEspacio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEspacio {

    @Autowired
    private RepositoryEspacio repositoryEspacio;

    public Espacio createEspacio(Espacio espacio) {
        return repositoryEspacio.save(espacio);
    }

    public List<Espacio> getAllEspacios() {
        return repositoryEspacio.findAll();
    }

    public Espacio getEspacioById(Integer id) {
        return repositoryEspacio.findById(id).orElse(null);
    }

    public Espacio updateEspacio(Espacio updatedEspacio) {
        return repositoryEspacio.save(updatedEspacio);
    }

    public void deleteEspacio(Integer id) {
        repositoryEspacio.deleteById(id);
    }

}
