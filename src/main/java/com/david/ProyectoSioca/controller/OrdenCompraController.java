package com.david.ProyectoSioca.controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
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

import com.david.ProyectoSioca.model.DetalleOrdenCompra;
import com.david.ProyectoSioca.model.OrdenCompra;
import com.david.ProyectoSioca.model.Reportes;
import com.david.ProyectoSioca.service.OrdenCompraService;
import com.david.ProyectoSioca.serviceimp.OrdenCompraImp;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/Sioca/OrdenCompra"})
public class OrdenCompraController {
	
	@Autowired(required=true)
	private OrdenCompraService service;
	
	@Autowired(required=true)
	private OrdenCompraImp serviceImp;
	
	@GetMapping(path= {"/listar"})
	public List<OrdenCompra> listar(){
		return service.encontrarOrdenesDeCompra();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public OrdenCompra buscarOrdenes(@PathVariable("id") int id) {
		return service.buscarOrdenPorId(id);
	}
	
	@GetMapping(path= {"/idMaximo"})
	public int obtenerIdMaximo() {
		return service.obtenerIdMaximo();
	}
	
	@PostMapping(path= {"/agregar"})
	public OrdenCompra insertarOrden(@RequestBody OrdenCompra oc) {
		System.out.println(oc);
		oc.setFecha(new Date());
		return service.insertarOrdenesDeCompra(oc);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public OrdenCompra editarOrden(@PathVariable("id") int id,@RequestBody OrdenCompra oc) {
		oc.setIdorden(id);
		return service.editarOrdenDeCompra(oc);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public OrdenCompra eliminarOrden(@PathVariable("id") int id) {
		return service.eliminarOrdenPorId(id);
	}
	
	@PostMapping(path= {"/generarReporte"})
	public String generarReporte(@RequestBody List<DetalleOrdenCompra> doc) throws FileNotFoundException, JRException {
		String frase="";
		frase= serviceImp.exportarReporte(doc);
		return frase;
	}
	
	@GetMapping(path= {"/descargarReporte"})
	public ResponseEntity<Resource> descargar(@RequestParam Map<String, Object> params) throws IOException, JRException{
		Reportes dto= service.obtenerReporteProveedores(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediatype = MediaType.APPLICATION_PDF;
		
		
		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\""+dto.getFileName()+"\"").contentLength(dto.getLength()).contentType(mediatype).body(streamResource);
	}

}
