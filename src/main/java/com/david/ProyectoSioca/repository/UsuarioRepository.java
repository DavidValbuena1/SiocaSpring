package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Integer> {
	public List<Usuario> findAll();
	public Usuario save(Usuario u);
	public Usuario findById(int id);
	public Usuario deleteById(int id);
}
