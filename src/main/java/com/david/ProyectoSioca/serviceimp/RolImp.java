package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.Rol;
import com.david.ProyectoSioca.repository.RolRepository;
import com.david.ProyectoSioca.service.RolService;

@Component
public class RolImp implements RolService{

	@Autowired(required=true)
	private RolRepository repositorio;

	@Override
	public List<Rol> encontrarTodosLosRoles() {
		return repositorio.findAll();
	}

	@Override
	public Rol insertarRol(Rol r) {
		return repositorio.save(r);
	}

	@Override
	public Rol editarRol(Rol r) {
		return repositorio.save(r);
	}

	@Override
	public Rol eliminarRolPorId(int id) {
		return repositorio.deleteById(id);
	}

	@Override
	public Rol buscarRolPorId(int id) {
		return repositorio.findById(id);
	}
	
	
}
