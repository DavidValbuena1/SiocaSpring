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

import com.david.ProyectoSioca.model.OrdenCompra;
import com.david.ProyectoSioca.service.OrdenCompraService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/Sioca/OrdenCompra"})
public class OrdenCompraController {
	
	@Autowired(required=true)
	private OrdenCompraService service;
	
	@GetMapping(path= {"/listar"})
	public List<OrdenCompra> listar(){
		return service.encontrarOrdenesDeCompra();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public OrdenCompra buscarOrdenes(@PathVariable("id") int id) {
		return service.buscarOrdenPorId(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public List<OrdenCompra> insertarOrden(@RequestBody List<OrdenCompra> oc) {
		return service.insertarOrdenesDeCompra(oc);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public OrdenCompra editarOrden(@PathVariable("id") int id,@RequestBody OrdenCompra oc) {
		oc.setIdOrden(id);
		return service.editarOrdenDeCompra(oc);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public OrdenCompra eliminarOrden(@PathVariable("id") int id) {
		return service.eliminarOrdenPorId(id);
	}
}
