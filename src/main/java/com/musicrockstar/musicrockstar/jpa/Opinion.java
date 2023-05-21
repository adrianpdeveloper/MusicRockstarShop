package com.musicrockstar.musicrockstar.jpa;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name="Opinion.findAll", query="SELECT o FROM Opinion o")
public class Opinion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String texto;
	private int valoracion;

	private String email;
	private String fecha;


	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;

	//bi-directional many-to-one association to Producto


	public Opinion(String texto, int valoracion, String email, String fecha) {
		this.texto = texto;
		this.valoracion = valoracion;
		this.email = email;
		this.fecha = fecha;
	}

	public Opinion(String texto, int valoracion, Producto producto) {
		this.texto = texto;
		this.valoracion = valoracion;
		this.producto = producto;
	}

	public Opinion(String texto, int valoracion, String email, String fecha, Producto producto) {
		this.texto = texto;
		this.valoracion = valoracion;
		this.email = email;
		this.fecha = fecha;
		this.producto = producto;
	}

	public Opinion(String texto, int valoracion) {
		this.texto = texto;
		this.valoracion = valoracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Opinion() {
	}
}