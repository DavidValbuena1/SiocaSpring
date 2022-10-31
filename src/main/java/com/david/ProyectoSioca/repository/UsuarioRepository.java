package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Integer> {
	public List<Usuario> findAll();
	public Usuario save(Usuario u);
	public Usuario findById(int id);
	public Usuario deleteById(int id);
	
	@Query("SELECT u FROM Usuario u WHERE u.Correo = ?1 AND u.contrasena= ?2")
	public Usuario verificar(String correo, String contraseña);
	
	@Query("SELECT u FROM Usuario u WHERE u.Correo = ?1")
	public Usuario recuperar(String correo);
	
	
}
