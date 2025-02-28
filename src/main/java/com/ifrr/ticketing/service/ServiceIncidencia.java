package com.ifrr.ticketing.service;

import com.ifrr.ticketing.entities.Incidencia;
import com.ifrr.ticketing.repository.RepositoryIncidencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceIncidencia {

    @Autowired
    private RepositoryIncidencia repositoryIncidencia;

    public Incidencia createIncidencia(Incidencia incidencia) {
        return repositoryIncidencia.save(incidencia);
    }

    public List<Incidencia> getAllIncidencias() {
        return repositoryIncidencia.findAll();
    }

    public Incidencia getIncidenciaById(Integer id) {
        return repositoryIncidencia.findById(id).orElse(null);
    }

    public Incidencia updateIncidencia(Incidencia updatedIncidencia) {
        return repositoryIncidencia.save(updatedIncidencia);
    }

    public void deleteIncidencia(Integer id) {
        repositoryIncidencia.deleteById(id);
    }

}
