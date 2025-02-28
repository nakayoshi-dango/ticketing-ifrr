package com.ifrr.ticketing.repository;

import com.ifrr.ticketing.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDispositivo extends JpaRepository<Dispositivo, Integer> {
    
}
