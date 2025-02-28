package com.ifrr.ticketing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Incidencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "f_entrada")
    private String fEntrada;

    @Column(name = "f_cierre")
    private String fCierre;

    private String estado;
    
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_gestor", referencedColumnName = "id")
    private Usuario gestor;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id")
    private Usuario tecnico;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo", referencedColumnName = "id")
    private Dispositivo dispositivo;

    @ManyToOne
    @JoinColumn(name = "id_espacio", referencedColumnName = "id")
    private Espacio espacio;

    @Column(name = "desc_incidencia")
    private String descIncidencia;

    @Column(name = "desc_solucion")
    private String descSolucion;

    @Override
    public String toString() {
        return "Incidencia{" + "id=" + id + ", fEntrada=" + fEntrada + ", fCierre=" + fCierre + ", estado=" + estado + ", gestor=" + gestor + ", usuario=" + usuario + ", tecnico=" + tecnico + ", dispositivo=" + dispositivo + ", espacio=" + espacio + ", descIncidencia=" + descIncidencia + ", descSolucion=" + descSolucion + '}';
    }

    public Incidencia() {
    }

    public Incidencia(String fEntrada, String fCierre, String estado, String tipo, Usuario gestor, Usuario usuario, Usuario tecnico, String descIncidencia, String descSolucion) {
        this.fEntrada = fEntrada;
        this.fCierre = fCierre;
        this.estado = estado;
        this.tipo = tipo;
        this.gestor = gestor;
        this.usuario = usuario;
        this.tecnico = tecnico;
        this.descIncidencia = descIncidencia;
        this.descSolucion = descSolucion;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfEntrada() {
        return fEntrada;
    }

    public void setfEntrada(String fEntrada) {
        this.fEntrada = fEntrada;
    }

    public String getfCierre() {
        return fCierre;
    }

    public void setfCierre(String fCierre) {
        this.fCierre = fCierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getGestor() {
        return gestor;
    }

    public void setGestor(Usuario gestor) {
        this.gestor = gestor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public String getDescIncidencia() {
        return descIncidencia;
    }

    public void setDescIncidencia(String descIncidencia) {
        this.descIncidencia = descIncidencia;
    }

    public String getDescSolucion() {
        return descSolucion;
    }

    public void setDescSolucion(String descSolucion) {
        this.descSolucion = descSolucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Incidencia that = (Incidencia) o;
        return Objects.equals(id, that.id)
                && Objects.equals(fEntrada, that.fEntrada)
                && Objects.equals(fCierre, that.fCierre)
                && Objects.equals(estado, that.estado)
                && Objects.equals(gestor, that.gestor)
                && Objects.equals(usuario, that.usuario)
                && Objects.equals(tecnico, that.tecnico)
                && Objects.equals(dispositivo, that.dispositivo)
                && Objects.equals(espacio, that.espacio)
                && Objects.equals(descIncidencia, that.descIncidencia)
                && Objects.equals(descSolucion, that.descSolucion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fEntrada, fCierre, estado, gestor, usuario, tecnico, dispositivo, espacio, descIncidencia, descSolucion);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
