package com.example.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.modelo.Producto;
import com.example.crud.servicio.ProductoServicio;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class ProductoRest {
	@Autowired
	ProductoServicio productoServicio;
	
	@PostMapping("/anadir")
	private ResponseEntity<Producto> anadirProducto(@RequestBody Producto producto) {
		productoServicio.creaProducto(producto);
		return ResponseEntity.ok(producto);	
	}
	@GetMapping("/listadoProductos")
	private ResponseEntity<List<Producto>> listarProductos() {
		return ResponseEntity.ok(productoServicio.listadoProductos());
	}
	@PutMapping("/actualizarProducto/{id}")
	private ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {		
//		return ResponseEntity.ok(productoServicio.modificarProducto(producto));
		return null;
	}
	@DeleteMapping("/eliminar")
	private ResponseEntity<Void> eliminarProducto (@RequestBody Producto producto){
		productoServicio.eliminarProducto(producto);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/listarProducto/{id}")
	private ResponseEntity<Producto> listarProducto(@PathVariable (value = "id") int id) {
		return ResponseEntity.ok(productoServicio.buscaId(id));
	}
}
