package com.example.crud.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.modelo.Producto;
import com.example.crud.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {
	@Autowired
	ProductoRepositorio productoRepositorio;
	
	//Metodos del CRUD
	//Crear Producto
	public Producto creaProducto(Producto producto){
		return productoRepositorio.save(producto);		
	}
	//Ver listado de productos
	public List<Producto> listadoProductos(){
		return productoRepositorio.findAll();
	}
	//Eliminar un producto
	public void eliminarProducto(Producto producto){
		productoRepositorio.delete(producto);
	}
	//Modificar un producto
	public void modificarProducto(Producto producto) {
		productoRepositorio.updateNombreById(producto.getId(), producto.getNombre());
//		return null;
	}
	//Buscar un producto por nombre
	public Optional<Producto> buscaProducto(String nombre){
		return productoRepositorio.findByNombre(nombre);
	}
	//Buscar un producto por nombre de categoria
	public Optional<Producto> buscaCategoria(String nombre){
		return productoRepositorio.findByNombreCategoria(nombre);
	}
	//Buscar un producto por id
	public Producto buscaId(int id){
		return productoRepositorio.findById(id);
	}
}
