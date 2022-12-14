package com.david.ProyectoSioca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.ProyectoSioca.model.MetodoPago;
import com.david.ProyectoSioca.service.MetodoPagoService;

@RestController
@RequestMapping({"/Sioca/MetodoPago"})
public class MetodoPagoController {

	@Autowired(required=true)
	private MetodoPagoService service;
	
	@GetMapping(path = {"/listar"})
	public List<MetodoPago> encontrarTodos(){
		return service.findAll();
	}
	
	@GetMapping(path = {"/listarId/{id}"})
	public Optional<MetodoPago> encontrarPorId(@PathVariable("id") int id){
		return service.findById(id);
	}
	
	@PostMapping(path = {"/agregar"})
	public MetodoPago agregar(@RequestBody MetodoPago mp) {
		return service.save(mp);
	}
}
