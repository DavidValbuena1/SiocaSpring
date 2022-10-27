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

import com.david.ProyectoSioca.model.TipoDocumento;
import com.david.ProyectoSioca.service.TipoDocumentoService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Sioca/TipoDocumento"})
public class TipoDocumentoController {
	
	@Autowired(required=true)
	private TipoDocumentoService service;
	
	@GetMapping(path= {"/listar"})
	public List<TipoDocumento> listar(){
		return service.encontrarTodosLosTipos();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public TipoDocumento buscarDocumento(@PathVariable("id") int id) {
		return service.encontrarTipoPorId(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public TipoDocumento insertarTipo(@RequestBody TipoDocumento td) {
		return service.insertarTipo(td);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public TipoDocumento editarTipo(@RequestBody TipoDocumento td, @PathVariable("id") int id) {
		td.setIdtipodocumento(id);
		return service.editarTipo(td);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public TipoDocumento eliminarTipo(@PathVariable("id") int id) {
		return service.eliminarTipoPorId(id);
	}
}
