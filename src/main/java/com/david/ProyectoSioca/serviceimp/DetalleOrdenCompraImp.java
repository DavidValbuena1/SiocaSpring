package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.DetalleOrdenCompra;
import com.david.ProyectoSioca.repository.DetalleOrdenCompraRepository;
import com.david.ProyectoSioca.service.DetalleOrdenCompraService;

@Component
public class DetalleOrdenCompraImp implements DetalleOrdenCompraService {
	
	@Autowired(required=true)
	private DetalleOrdenCompraRepository repositorio;

	@Override
	public List<DetalleOrdenCompra> findAll() {
		return repositorio.findAll();
	}

	@Override
	public DetalleOrdenCompra findById(int id) {
		return repositorio.findById(id);
	}

	@Override
	public DetalleOrdenCompra save(DetalleOrdenCompra doc) {
		return repositorio.save(doc);
	}

	@Override
	public List<DetalleOrdenCompra> saveAll(Iterable<DetalleOrdenCompra> doc) {
		return repositorio.saveAll(doc);
	}

	@Override
	public DetalleOrdenCompra deleteById(int id) {
		return repositorio.deleteById(id);
	}

	@Override
	public List<DetalleOrdenCompra> findByIdOrden(int Idorden) {
		return repositorio.findByIdOrden(Idorden);
	}
	
}
