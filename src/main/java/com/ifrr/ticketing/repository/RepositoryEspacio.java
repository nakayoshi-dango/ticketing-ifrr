package com.ifrr.ticketing.repository;

import com.ifrr.ticketing.entities.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEspacio extends JpaRepository<Espacio, Integer> {
    
}
