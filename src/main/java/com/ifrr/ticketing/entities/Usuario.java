package com.ifrr.ticketing.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_login", unique = true, nullable = false)
    private String nombreLogin;

    @Column(nullable = false)
    private String contrasena;

    @Column(name = "nombre_apellidos", nullable = false)
    private String nombreApellidos;

    @Column(nullable = true, unique = true)
    private String correo;

    @Column(nullable = true, unique = true)
    private Integer telefono;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Usuario_perfil",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_perfil")
    )
    private Set<Perfil> perfiles;

    public Usuario() {
    }

    public Usuario(String nombreLogin, String contrasena, String nombreApellidos, String correo, Integer telefono) {
        this.nombreLogin = nombreLogin;
        this.contrasena = contrasena;
        this.nombreApellidos = nombreApellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreLogin=" + nombreLogin + ", contrasena=" + contrasena + ", nombreApellidos=" + nombreApellidos + ", correo=" + correo + ", telefono=" + telefono + ", perfiles=" + perfiles + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreLogin() {
        return nombreLogin;
    }

    public void setNombreLogin(String nombreLogin) {
        this.nombreLogin = nombreLogin;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Set<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Set<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id)
                && Objects.equals(nombreLogin, usuario.nombreLogin)
                && Objects.equals(contrasena, usuario.contrasena)
                && Objects.equals(nombreApellidos, usuario.nombreApellidos)
                && Objects.equals(correo, usuario.correo)
                && Objects.equals(telefono, usuario.telefono)
                && Objects.equals(perfiles, usuario.perfiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreLogin, contrasena, nombreApellidos, correo, telefono, perfiles);
    }

}
