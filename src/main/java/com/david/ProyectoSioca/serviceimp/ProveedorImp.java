package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.Proveedor;
import com.david.ProyectoSioca.repository.ProveedorRepository;
import com.david.ProyectoSioca.service.ProveedorService;

@Component
public class ProveedorImp implements ProveedorService{

	@Autowired(required=true)
	private ProveedorRepository repositorio;
	
	@Override
	public List<Proveedor> encontrarTodosLosProveedores() {
		return repositorio.findAll();
	}

	@Override
	public List<Proveedor> insertarProveedores(List<Proveedor> lista) {
		return repositorio.saveAll(lista);
	}

	@Override
	public Proveedor editarProveedor(Proveedor p) {
		return repositorio.save(p);
	}

	@Override
	public Proveedor encontrarProveedorPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Proveedor eliminarProveedorPorId(int id) {
		return repositorio.deleteById(id);
	}
	
}
