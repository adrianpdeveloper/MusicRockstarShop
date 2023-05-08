package com.musicrockstar.musicrockstar.jpa;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.io.Serializable;

@Entity
@NamedQuery(name="Prueba.findAll", query="SELECT p FROM Prueba p")
public class Prueba {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private String nombre;

    public Prueba() {
    }

    public Prueba(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
