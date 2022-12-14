package com.david.ProyectoSioca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.ProyectoSioca.model.EstadoPedido;
import com.david.ProyectoSioca.service.EstadoPedidoService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping({"/Sioca/EstadoPedido"})
public class EstadoPedidoController {
	
	@Autowired(required=true)
	private EstadoPedidoService service;
	
	@GetMapping(path= {"/listar"})
	public List<EstadoPedido> encontrarTodos(){
		return service.findAll();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Optional<EstadoPedido> encontrarPorId(@PathVariable("id") int id){
		return service.findById(id);
	}
}
