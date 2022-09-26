package com.david.ProyectoSioca.controller;

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

import com.david.ProyectoSioca.model.Reportes;
import com.david.ProyectoSioca.model.Venta;
import com.david.ProyectoSioca.service.VentaService;

import net.sf.jasperreports.engine.JRException;

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
		v.setFecha(new Date());
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
	
	@GetMapping(path= {"/descargarReporte"})
	public ResponseEntity<Resource> descargar(@RequestParam Map<String, Object> params) throws IOException, JRException{
		Reportes dto= service.obtenerReporteProveedores(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediatype = MediaType.APPLICATION_PDF;
		
		
		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\""+dto.getFileName()+"\"").contentLength(dto.getLength()).contentType(mediatype).body(streamResource);
	}

}
