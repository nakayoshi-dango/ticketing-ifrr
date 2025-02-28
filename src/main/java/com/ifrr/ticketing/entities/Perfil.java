package com.ifrr.ticketing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String tipo;

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", tipo=" + tipo + '}';
    }

    public Perfil() {
    }

    public Perfil(String tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id)
                && Objects.equals(tipo, perfil.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo);
    }
}
