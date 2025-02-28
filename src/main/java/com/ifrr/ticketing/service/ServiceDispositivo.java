package com.ifrr.ticketing.service;

import com.ifrr.ticketing.entities.Dispositivo;
import com.ifrr.ticketing.repository.RepositoryDispositivo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDispositivo {

    @Autowired
    private RepositoryDispositivo repositoryDispositivo;

    public Dispositivo createDispositivo(Dispositivo dispositivo) {
        return repositoryDispositivo.save(dispositivo);
    }

    public List<Dispositivo> getAllDispositivos() {
        return repositoryDispositivo.findAll();
    }

    public Dispositivo getDispositivoById(Integer id) {
        return repositoryDispositivo.findById(id).orElse(null);
    }

    public Dispositivo updateDispositivo(Dispositivo updatedDispositivo) {
        return repositoryDispositivo.save(updatedDispositivo);
    }

    public void deleteDispositivo(Integer id) {
        repositoryDispositivo.deleteById(id);
    }

}
