package com.david.ProyectoSioca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Rol;

@Service
public interface RolService {
	public List<Rol> encontrarTodosLosRoles();
	public Rol insertarRol(Rol r);
	public Rol editarRol(Rol r);
	public Rol eliminarRolPorId(int id);
	public Rol buscarRolPorId(int id);
}
