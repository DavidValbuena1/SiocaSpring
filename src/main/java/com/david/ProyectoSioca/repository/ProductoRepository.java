package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.Producto;

public interface ProductoRepository extends Repository<Producto, Integer> {
	public List<Producto> findAll();
	public Producto save(Producto p);
	public List<Producto> saveAll(Iterable<Producto> p);
	public Producto findById(int id);
	public Producto deleteById(int id);
	
	@Query("SELECT p FROM Producto p WHERE p.Type.id=?1")
	public List<Producto> findByCategory(int id);
}
