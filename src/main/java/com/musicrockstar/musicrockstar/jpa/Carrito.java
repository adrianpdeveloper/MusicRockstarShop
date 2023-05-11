package com.musicrockstar.musicrockstar.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name="Carrito.findAll", query="SELECT c FROM Carrito c")
public class Carrito {

    @Id
    private int id;

    private String email;

    @ManyToMany
    @JoinTable(name = "carrito_productos",
            joinColumns = @JoinColumn(name = "id_carrito"),
            inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private List<Producto> productos;

    public Carrito() {
    }

    public Carrito(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
