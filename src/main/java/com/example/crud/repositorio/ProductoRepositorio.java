package com.example.crud.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.modelo.Producto;

@Repository
@Transactional
public interface ProductoRepositorio  extends JpaRepository <Producto, Integer>{
	public Optional<Producto> findByNombre(String nombre);
	public Optional<Producto> findByNombreCategoria(String nombreCategoria);
	public Producto findById(int id);
	
	 
    @Modifying
    @Query(value = "UPDATE Producto p SET p.nombre = :nombre WHERE p.id = :id")
    public void updateNombreById(@Param("id") int i, @Param("nombre") String name);
}
