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

import com.david.ProyectoSioca.model.DetalleVenta;
import com.david.ProyectoSioca.service.DetalleVentaService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Sioca/DetalleVenta"})
public class DetalleVentaController {
	
	@Autowired(required=true)
	private DetalleVentaService service;
	
	@GetMapping(path= {"/listar"})
	public List<DetalleVenta> listar(){
		return service.encontrarTodosLosDetalles();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public DetalleVenta encontrarDetalle(@PathVariable("id") int id) {
		return service.encontrarDetallePorId(id);
	}
	
	@GetMapping(path= {"/listarPorFactura/{id}"})
	public List<DetalleVenta> encontrarPorFactura(@PathVariable("id") int id){
		return service.encontrarDetallesPorFactura(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public List<DetalleVenta> insertarDetalles(@RequestBody List<DetalleVenta> dv){
		return service.insertarDetalles(dv);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public DetalleVenta editarDetalle(@RequestBody DetalleVenta dv,@PathVariable("id") int id) {
		dv.setIdDetalle(id);
		return service.editarDetalle(dv);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public DetalleVenta eliminarDetalle(@PathVariable("id") int id) {
		return service.eliminarPorId(id);
	}
	
}
