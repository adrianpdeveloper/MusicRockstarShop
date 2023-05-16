package com.musicrockstar.musicrockstar.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido {

    @Id
    private int id;

    private String email;

    private String direccion;

    private String numeroTarjeta;

    private String fechaPedido;


    private Float precioTotal;

    private String productos;

    public Pedido() {
    }


    public Pedido(int id, String email, String direccion, String fechaPedido, Float precioTotal, String productos) {
        this.id = id;
        this.email = email;
        this.direccion = direccion;
        this.fechaPedido = fechaPedido;

        this.precioTotal = precioTotal;
        this.productos = productos;
    }

    public Pedido(String email, String direccion, String numeroTarjeta) {
        this.email = email;
        this.direccion = direccion;
        this.numeroTarjeta = numeroTarjeta;
    }


    public Pedido(String email, String direccion, String numeroTarjeta, String productos) {
        this.email = email;
        this.direccion = direccion;
        this.numeroTarjeta = numeroTarjeta;
        this.productos = productos;
    }


    public Pedido(String email, String direccion, String numeroTarjeta, String fechaPedido, Float precioTotal, String productos) {
        this.email = email;
        this.direccion = direccion;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaPedido = fechaPedido;
        this.precioTotal = precioTotal;
        this.productos = productos;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String tarjeta) {
        this.numeroTarjeta = tarjeta;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }
}
