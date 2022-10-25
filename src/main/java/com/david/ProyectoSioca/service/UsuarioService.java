package com.david.ProyectoSioca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Usuario;


@Service
public interface UsuarioService {
	public List<Usuario> encontrarTodosLosUsuarios();
	public Usuario insertarUsuario(Usuario u);
	public Usuario editarUsuario(Usuario u);
	public Usuario encontrarUsuarioPorId(int id);
	public Usuario borrarUsuarioPorId(int id);
	
	public Usuario verificar(String correo, String contraseña);
	public boolean recuperar(String correo);
}
