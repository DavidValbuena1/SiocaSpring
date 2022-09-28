package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.Proveedor;

public interface ProveedorRepository extends Repository<Proveedor, Integer> {
	public List<Proveedor> findAll();
	public List<Proveedor> saveAll(Iterable<Proveedor> p);
	public Proveedor save(Proveedor p);
	public Proveedor findById(int id);
	public Proveedor deleteById(int id);
	
	@Query("SELECT p FROM Proveedor p WHERE p.Nombre = ?1")
	public Proveedor buscarPorNombre(String nombre);
}
