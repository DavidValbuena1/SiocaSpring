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

import com.david.ProyectoSioca.model.Venta;
import com.david.ProyectoSioca.service.VentaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/Sioca/Venta"})
public class VentaController {
	
	@Autowired(required=true)
	private VentaService service;
	
	@GetMapping(path= {"/MaxId"})
	public int encontrarIdVenta() {
		return service.MaxId();
	}
	
	@GetMapping(path= {"/listar"})
	public List<Venta> listar(){
		return service.encontrarTodas();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Venta encontrarVenta(@PathVariable("id") int id) {
		return service.encontrarVentaPorId(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public Venta insertarVenta(@RequestBody Venta v) {
		return service.insertarVenta(v);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public Venta editarVenta(@RequestBody Venta v, @PathVariable("id") int id) {
		v.setId(id);
		return service.editarVenta(v);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public Venta eliminarVenta(@PathVariable("id") int id) {
		return service.eliminarVenta(id);
	}
}
