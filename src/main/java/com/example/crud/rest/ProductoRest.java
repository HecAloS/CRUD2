package com.example.crud.rest;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	static Logger log = LogManager.getLogger(ProductoRest.class);
	
	@PostMapping("/anadir")
	private ResponseEntity<Producto> anadirProducto(@RequestBody Producto producto) {
		log.trace("Añadir Producto -> POST.");
		productoServicio.creaProducto(producto);
		return ResponseEntity.ok(producto);	
	}
	@GetMapping("/listadoProductos")
	private ResponseEntity<List<Producto>> listarProductos() {
		log.info("Listar Productos -> GET.");
		return ResponseEntity.ok(productoServicio.listadoProductos());
	}
	@PutMapping("/actualizarProducto")
	private ResponseEntity<Optional<Producto>> actualizarProducto(@RequestBody Producto producto) {
		log.info("Actualizar producto -> PUT.");
		productoServicio.modificarProducto(producto);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/eliminar")
	private ResponseEntity<Void> eliminarProducto (@RequestBody Producto producto){
		log.info("Eliminar producto -> DELETE.");
		productoServicio.eliminarProducto(producto);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/listarProducto/{id}")
	private ResponseEntity<Producto> listarProducto(@PathVariable (value = "id") int id) {
		log.info("Listar UN solo producto -> GET.");
		return ResponseEntity.ok(productoServicio.buscaId(id));
	}
}
