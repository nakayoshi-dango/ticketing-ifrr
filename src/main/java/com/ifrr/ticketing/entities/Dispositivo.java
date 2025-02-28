package com.ifrr.ticketing.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Dispositivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;
    private String marca;
    private String modelo;
    private String descripcion;

    public Dispositivo(String tipo, String marca, String modelo, String descripcion) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
    }

    public Dispositivo() {
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "id=" + id + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", descripcion=" + descripcion + '}';
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dispositivo that = (Dispositivo) o;
        return Objects.equals(id, that.id)
                && Objects.equals(tipo, that.tipo)
                && Objects.equals(marca, that.marca)
                && Objects.equals(modelo, that.modelo)
                && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, marca, modelo, descripcion);
    }

}
