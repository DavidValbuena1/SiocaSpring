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

import com.david.ProyectoSioca.model.Categoria;
import com.david.ProyectoSioca.service.CategoriaService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping({"/Sioca/Categoria"})
public class CategoriaController {
	
	@Autowired(required=true)
	private CategoriaService service;
	
	@GetMapping(path= {"/listar"})
	public List<Categoria> listar(){
		return service.encontrarCategorias();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Categoria encontrarCategoria(@PathVariable("id") int id) {
		return service.encontrarCategoriaPorId(id);
	}
	
	@GetMapping(path= {"/listarPorNombre/{nombre}"})
	public Categoria buscarPorNombre(@PathVariable("nombre") String nombre) {
		return service.buscarPorNombre(nombre);
	}
	
	@PostMapping(path= {"/agregar"})
	public Categoria insertarCategoria(@RequestBody Categoria c) {
		return service.insertarCategoria(c);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public Categoria editarCategoria(@RequestBody Categoria c, @PathVariable("id") int id) {
		c.setId(id);
		return service.editarCategoria(c);
	}
	
	@DeleteMapping(path = {"/eliminar/{id}"})
	public Categoria eliminarCategoria(@PathVariable("id") int id) {
		return service.eliminarCategoriaPorId(id);
	}
}
