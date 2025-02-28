package com.ifrr.ticketing.repository;

import com.ifrr.ticketing.entities.Perfil;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPerfil extends JpaRepository<Perfil, Integer> {
    Optional<Perfil> findByTipo(String tipo);
}
