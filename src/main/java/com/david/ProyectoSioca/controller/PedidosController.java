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

import com.david.ProyectoSioca.model.Pedidos;
import com.david.ProyectoSioca.service.PedidosService;

@RestController
@RequestMapping({"/Sioca/Pedidos"})
@CrossOrigin(origins="*")
public class PedidosController {
	
	@Autowired(required=true)
	private PedidosService service;
	
	@GetMapping(path= {"/listar"})
	public List<Pedidos> encontrarTodos(){
		return service.findAll();
	}
	
	@GetMapping(path = {"/listarId/{id}"})
	public Optional<Pedidos> encontrarPorId(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@GetMapping(path= {"/cliente/{id}"})
	public List<Pedidos> pedidosPorCliente(int id){
		return service.pedidosPorCliente(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public Pedidos agregar(@RequestBody Pedidos pedido) {
		return service.save(pedido);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public Pedidos editar(@RequestBody Pedidos pedido, @PathVariable("id") int id) {
		pedido.setId(id);
		return service.editar(pedido);
	}
	
}
