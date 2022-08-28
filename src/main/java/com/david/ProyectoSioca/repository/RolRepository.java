package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.Rol;

public interface RolRepository extends Repository<Rol, Integer> {
	public List<Rol> findAll();
	public Rol save(Rol r);
	public Rol findById(int id);
	public Rol deleteById(int id);
	
}
