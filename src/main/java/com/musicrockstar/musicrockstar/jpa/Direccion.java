package com.musicrockstar.musicrockstar.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.io.Serializable;

@Entity
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String nombre;
    private String telefono;
    private String calle;
    private int numero;
    private String puerta;
    private String codigo;
    private String ciudad;
    private String provincia;
    private String comentario;
    private String email;

    public Direccion() {
    }

    public Direccion(String nombre, String telefono, String calle, int numero, String puerta, String codigo, String ciudad, String provincia, String comentario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.calle = calle;
        this.numero = numero;
        this.puerta = puerta;
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.comentario = comentario;
    }

    public Direccion(String nombre, String telefono, String calle, int numero, String puerta, String codigo, String ciudad, String provincia, String comentario, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.calle = calle;
        this.numero = numero;
        this.puerta = puerta;
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.comentario = comentario;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
