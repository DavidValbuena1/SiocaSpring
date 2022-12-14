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

import com.david.ProyectoSioca.model.DetallePedido;
import com.david.ProyectoSioca.service.DetallePedidoService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping({"/Sioca/DetallePedido"})
public class DetallePedidoController {

	@Autowired(required=true)
	private DetallePedidoService service;
	
	@GetMapping(path= {"/detallesPorPedido/{id}"})
	public List<DetallePedido> detallesPorPedido(@PathVariable("id") int id){
		return service.detallesPorPedido(id);
	}
	
	@GetMapping(path = {"/listarId/{id}"})
	public Optional<DetallePedido> encontrarPorId(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping(path = {"/agregar"})
	public List<DetallePedido> agregarDetalles(@RequestBody List<DetallePedido> detalles){
		return service.insertarTodosLosDetalles(detalles);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public DetallePedido editarDetalle(@PathVariable("id") int id, @RequestBody DetallePedido detalle) {
		detalle.setId(id);
		return service.editarDetalle(detalle);
	}
}
