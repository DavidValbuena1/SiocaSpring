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

import com.david.ProyectoSioca.model.DetalleOrdenCompra;
import com.david.ProyectoSioca.service.DetalleOrdenCompraService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping({"/Sioca/DetalleOrdenCompra"})
public class DetalleOrdenCompraController {
	
	@Autowired(required=true)
	private DetalleOrdenCompraService service;
	
	@GetMapping(path= {"/listar"})
	public List<DetalleOrdenCompra> encontrarTodos() {
		return service.findAll();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public DetalleOrdenCompra encontrarPorId(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@GetMapping(path= {"/listarPorOrden/{Idorden}"})
	public List<DetalleOrdenCompra> encontrarPorOrden(@PathVariable("Idorden") int id){
		return service.findByIdOrden(id);
	}
	
	@PostMapping(path= {"/agregarTodos"})
	public List<DetalleOrdenCompra> insertarTodosDetalles(@RequestBody List<DetalleOrdenCompra> doc){
		return service.saveAll(doc);
	}
	
	@PostMapping(path= {"/agregar"})
	public DetalleOrdenCompra insertarDetalle(@RequestBody DetalleOrdenCompra doc) {
		return service.save(doc);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public DetalleOrdenCompra editarDetalle(@PathVariable("id") int id, @RequestBody DetalleOrdenCompra doc) {
		doc.setId(id);
		return service.save(doc);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public DetalleOrdenCompra eliminarDetalle(@PathVariable("id") int id) {
		return service.deleteById(id);
	}
}
