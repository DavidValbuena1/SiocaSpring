package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.OrdenCompra;

public interface OrdenCompraRepository extends Repository<OrdenCompra, Integer> {
	public List<OrdenCompra> findAll();
	public OrdenCompra save(OrdenCompra oc);
	public OrdenCompra findById(int id);
	public OrdenCompra deleteById(int id);
	
	@Query("SELECT MAX(o.Idorden) FROM OrdenCompra o")
	public int obtenerIdMaximo();
}
