package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.Usuario;
import com.david.ProyectoSioca.repository.UsuarioRepository;
import com.david.ProyectoSioca.service.UsuarioService;

@Component
public class UsuarioImp implements UsuarioService{
	
	@Autowired(required=true)
	private UsuarioRepository repositorio;

	@Override
	public List<Usuario> encontrarTodosLosUsuarios() {
		return repositorio.findAll();
	}

	@Override
	public Usuario insertarUsuario(Usuario u) {
		return repositorio.save(u);
	}

	@Override
	public Usuario editarUsuario(Usuario u) {
		return repositorio.save(u);
	}

	@Override
	public Usuario encontrarUsuarioPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Usuario borrarUsuarioPorId(int id) {
		return repositorio.deleteById(id);
	}
	
	
}
