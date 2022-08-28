package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.Venta;

public interface VentaRepository extends Repository<Venta, Integer> {
	public List<Venta> findAll();
	public Venta save(Venta v);
	public Venta findById(int id);
	public Venta deleteById(int id);
	
	@Query("SELECT Max(v.Id) FROM Venta v")
	public int MaxId();
}
