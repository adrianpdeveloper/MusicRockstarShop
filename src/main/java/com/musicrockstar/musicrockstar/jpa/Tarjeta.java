package com.musicrockstar.musicrockstar.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta {
    @Id
    private int id;

    private String nombre;

    private String numero;
    private String cvc;
    private String email;
    private String fechaValidez;

    public Tarjeta() {
    }

    public Tarjeta(String nombre, String numero, String cvc, String email, String fechaValidez) {
        this.nombre = nombre;
        this.numero = numero;
        this.cvc = cvc;
        this.email = email;
        this.fechaValidez = fechaValidez;
    }

    public Tarjeta(String nombre, String numero, String cvc) {
        this.nombre = nombre;
        this.numero = numero;
        this.cvc = cvc;
    }

    public String getFechaValidez() {
        return fechaValidez;
    }

    public void setFechaValidez(String fecha) {
        this.fechaValidez = fecha;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvc() {
        return cvc;
    }


    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
