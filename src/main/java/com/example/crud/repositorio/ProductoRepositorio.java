package com.example.crud.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.modelo.Producto;

@Repository
public interface ProductoRepositorio  extends JpaRepository <Producto, Integer>{
	public Optional<Producto> findByNombre(String nombre);
	public Optional<Producto> findByNombreCategoria(String nombreCategoria);
	public Producto findById(int id);
}