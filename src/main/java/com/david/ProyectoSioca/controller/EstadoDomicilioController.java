package com.david.ProyectoSioca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.ProyectoSioca.model.EstadoDomicilio;
import com.david.ProyectoSioca.service.EstadoDomiciliosService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping({"/Sioca/EstadoDomicilio"})
public class EstadoDomicilioController {
	
	@Autowired(required=true)
	private EstadoDomiciliosService service;
	
	@GetMapping(path= {"/listar"})
	public List<EstadoDomicilio> encontrarTodos(){
		return service.findAll();
	}
	
	@GetMapping(path = {"/listarId/{id}"})
	public Optional<EstadoDomicilio> encontrarPorId(@PathVariable("id") int id) {
		return service.findById(id);
	}
}
