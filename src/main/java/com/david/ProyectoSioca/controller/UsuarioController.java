package com.david.ProyectoSioca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.ProyectoSioca.model.Usuario;
import com.david.ProyectoSioca.service.UsuarioService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Sioca/Usuario"})
public class UsuarioController {
	
	@Autowired(required=true)
	private UsuarioService service;
	
	@GetMapping(path= {"/listar"})
	public List<Usuario> listar(){
		return service.encontrarTodosLosUsuarios();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Usuario encontrarUsuario(@PathVariable("id") int id) {
		System.out.println(service.encontrarUsuarioPorId(id));
		return service.encontrarUsuarioPorId(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public Usuario insertarUsuario(@RequestBody Usuario u) {
		return service.insertarUsuario(u);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public Usuario editarUsuario(@RequestBody Usuario u, @PathVariable("id") int id) {
		u.setId_usuario(id);
		return service.editarUsuario(u);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public Usuario eliminarUsuario(@PathVariable("id") int id) {
		return service.borrarUsuarioPorId(id);
	}
	
	@PostMapping(path= {"/verificar"})
	public Usuario verificar(@RequestBody Usuario u) {
		System.out.println(u.getCorreo()+"---"+ u.getContrasena());
		return service.verificar(u.getCorreo(), u.getContrasena());
	}
	
	
	@PostMapping(path={"/recuperar"})
	public String recuperar(@RequestBody Usuario u) {
		if(service.recuperar(u.getCorreo())) {
			return "Ese correo no existe";
		}
		return "Correo enviado";
	}
}
