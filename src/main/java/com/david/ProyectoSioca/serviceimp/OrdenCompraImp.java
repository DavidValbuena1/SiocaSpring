package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.OrdenCompra;
import com.david.ProyectoSioca.repository.OrdenCompraRepository;
import com.david.ProyectoSioca.service.OrdenCompraService;

@Component
public class OrdenCompraImp implements OrdenCompraService {
	
	@Autowired(required=true)
	private OrdenCompraRepository repositorio;

	@Override
	public List<OrdenCompra> encontrarOrdenesDeCompra() {
		return repositorio.findAll();
	}

	@Override
	public List<OrdenCompra> insertarOrdenesDeCompra(List<OrdenCompra> lista) {
		return repositorio.saveAll(lista);
	}

	@Override
	public OrdenCompra editarOrdenDeCompra(OrdenCompra oc) {
		return repositorio.save(oc);
	}

	@Override
	public OrdenCompra buscarOrdenPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public OrdenCompra eliminarOrdenPorId(int id) {
		return repositorio.deleteById(id);
	}
}
