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

import com.david.ProyectoSioca.model.Rol;
import com.david.ProyectoSioca.service.RolService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Sioca/Rol"})
public class RolController {
	
	@Autowired(required=true)
	private RolService service;
	
	@GetMapping(path= {"/listar"})
	public List<Rol> listar(){
		return service.encontrarTodosLosRoles();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Rol encontrarRol(@PathVariable("id") int id) {
		return service.buscarRolPorId(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public Rol insertarRol(@RequestBody Rol r) {
		return service.insertarRol(r);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public Rol editarRol(@PathVariable("id") int id, @RequestBody Rol r) {
		r.setId(id);
		return service.editarRol(r);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public Rol eliminarRol(@PathVariable("id") int id) {
		return service.eliminarRolPorId(id);
	}
}
