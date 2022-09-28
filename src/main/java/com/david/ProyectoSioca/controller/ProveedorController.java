package com.david.ProyectoSioca.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.david.ProyectoSioca.model.Proveedor;
import com.david.ProyectoSioca.model.Reportes;
import com.david.ProyectoSioca.service.ProveedorService;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Sioca/Proveedor"})
public class ProveedorController {
	
	@Autowired(required=true)
	private ProveedorService service;
	
	@GetMapping(path= {"/listar"})
	public List<Proveedor> listar(){
		return service.encontrarTodosLosProveedores();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Proveedor encontrarProveedor(@PathVariable("id") int id) {
		return service.encontrarProveedorPorId(id);
	}
	
	@PostMapping(path= {"/agregar"})
	public List<Proveedor> insertarProveedor(@RequestBody List<Proveedor> p) {
		return service.insertarProveedores(p);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public Proveedor editarProveedor(@PathVariable("id") int id, @RequestBody Proveedor p) {
		p.setId_proveedor(id);
		return service.editarProveedor(p);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public Proveedor eliminarProveedor(@PathVariable("id") int id) {
		return service.eliminarProveedorPorId(id);
	}
	
	@GetMapping(path= {"/descargarReporte"})
	public ResponseEntity<Resource> descargar(@RequestParam Map<String, Object> params) throws IOException, JRException{
		Reportes dto= service.obtenerReporteProveedores(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediatype = MediaType.APPLICATION_PDF;
		
		
		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\""+dto.getFileName()+"\"").contentLength(dto.getLength()).contentType(mediatype).body(streamResource);
	}
	
	@PostMapping(path= {"/buscarPorNombre"})
	public Proveedor buscarPorNombre(@RequestBody String nombre) {
		return service.buscarPorNombre(nombre);
	}

}
