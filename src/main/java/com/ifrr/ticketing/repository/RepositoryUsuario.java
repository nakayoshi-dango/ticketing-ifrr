package com.ifrr.ticketing.repository;

import com.ifrr.ticketing.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {
    Usuario getByNombreLogin(String nombreLogin);
}
