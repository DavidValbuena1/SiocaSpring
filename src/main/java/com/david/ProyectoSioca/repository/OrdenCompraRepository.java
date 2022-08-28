package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.OrdenCompra;

public interface OrdenCompraRepository extends Repository<OrdenCompra, Integer> {
	public List<OrdenCompra> findAll();
	public OrdenCompra save(OrdenCompra oc);
	public List<OrdenCompra> saveAll(Iterable<OrdenCompra> oc);
	public OrdenCompra findById(int id);
	public OrdenCompra deleteById(int id);
}
