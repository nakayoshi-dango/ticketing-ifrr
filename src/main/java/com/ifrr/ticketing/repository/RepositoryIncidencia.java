package com.ifrr.ticketing.repository;

import com.ifrr.ticketing.entities.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryIncidencia extends JpaRepository<Incidencia, Integer> {
    
}
