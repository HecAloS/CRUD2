package com.example.crud.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Producto {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public int id;
	public String nombre;
	public String nombreCategoria;
	public float precio;
	public int cantidad;
	
	public Producto(int id, String nombre, String nombreCategoria, float precio, int cantidad) {

		this.id = id;
		this.nombre = nombre;
		this.nombreCategoria = nombreCategoria;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public Producto() {

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
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
