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

import com.david.ProyectoSioca.model.Proveedor;
import com.david.ProyectoSioca.service.ProveedorService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Sioca/Proveedor"})
public class ProveedorController {
	
	@Autowired(required=true)
	private ProveedorService service;
	
	@GetMapping(path= {"/listar"})
	public List<Proveedor> listar(){
		return service.encontrarTodosLosProveedores();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Proveedor encontrarProveedor(@PathVariable("id") int id) {
		return service.encontrarProveedorPorId(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public List<Proveedor> insertarProveedor(@RequestBody List<Proveedor> p) {
		return service.insertarProveedores(p);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public Proveedor editarProveedor(@PathVariable("id") int id, @RequestBody Proveedor p) {
		p.setId_proveedor(id);
		return service.editarProveedor(p);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public Proveedor eliminarProveedor(@PathVariable("id") int id) {
		return service.eliminarProveedorPorId(id);
	}

}
