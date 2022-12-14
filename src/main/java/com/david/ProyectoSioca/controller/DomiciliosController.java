package com.david.ProyectoSioca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.ProyectoSioca.model.Domicilios;
import com.david.ProyectoSioca.service.DomiciliosService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping({"/Sioca/Domicilios"})
public class DomiciliosController {

	@Autowired(required=true)
	private DomiciliosService service;

	@GetMapping(path= {"/listar"})
	public List<Domicilios> encontrarTodosDetalles(){
		return service.findAll();
	}
	
	@GetMapping(path = {"/listarId/{id}"})
	public Optional<Domicilios> encontrarPorId(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@GetMapping(path = {"/repartidor/{id}"})
	public List<Domicilios> encontrarDomiciliosRepartidor(@PathVariable("id") int id){
		return service.domiciliosPorRepartidor(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public Domicilios agregar(@RequestBody Domicilios domicilio) {
		return service.save(domicilio);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public Domicilios editar(@RequestBody Domicilios domicilio,@PathVariable("id") int id) {
		domicilio.setId(id);
		return service.save(domicilio);
	}
}
