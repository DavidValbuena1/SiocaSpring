package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.DetalleOrdenCompra;

public interface DetalleOrdenCompraRepository extends Repository<DetalleOrdenCompra, Integer> {
	
	public List<DetalleOrdenCompra> findAll();
	public DetalleOrdenCompra findById(int id);
	public DetalleOrdenCompra save(DetalleOrdenCompra doc);
	public List<DetalleOrdenCompra> saveAll(Iterable<DetalleOrdenCompra> doc);
	public DetalleOrdenCompra deleteById(int id);
	
	
	@Query("SELECT doc FROM DetalleOrdenCompra doc WHERE doc.ordenCompra.Idorden = ?1")
	public List<DetalleOrdenCompra> findByIdOrden(int Idorden);
}
