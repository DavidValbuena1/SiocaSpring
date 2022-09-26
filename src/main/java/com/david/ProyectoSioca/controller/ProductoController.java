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

import com.david.ProyectoSioca.model.Producto;
import com.david.ProyectoSioca.model.Reportes;
import com.david.ProyectoSioca.service.ProductoService;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/Sioca/Producto"})
public class ProductoController {
	
	@Autowired(required=true)
	private ProductoService service;
	
	@GetMapping(path= {"/listar"})
	public List<Producto> listar(){
		return service.encontrarTodosLosProductos();
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Producto encontrarProducto(@PathVariable("id") int id) {
		
		return service.buscarProductoPorId(id);
	}
	
	@PostMapping(path = {"/agregar"})
	public List<Producto> insertarProductos(@RequestBody List<Producto> p){
		for(Producto pro: p) {
			Date d = new Date();
			pro.setDate(d);
			pro.setPrecioTotal(pro.getPrice()*pro.getQuantity());
		}
		return service.insertarTodosLosProductos(p);
	}
	
	@PutMapping(path= {"/editar/{id}"})
	public Producto editarProducto(@RequestBody Producto p, @PathVariable("id") int id) {
		p.setId_producto(id);
		p.setPrecioTotal(p.getQuantity()*p.getPrice());
		return service.editarProducto(p);
	}
	
	@DeleteMapping(path= {"/eliminar/{id}"})
	public Producto eliminarProducto(@PathVariable("id") int id) {
		return service.eliminarProductoPorId(id);
	}
	
	@GetMapping(path= {"/descargarReporte"})
	public ResponseEntity<Resource> descargar(@RequestParam Map<String, Object> params) throws IOException, JRException{
		Reportes dto= service.obtenerReporteProveedores(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediatype = MediaType.APPLICATION_PDF;
		
		
		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\""+dto.getFileName()+"\"").contentLength(dto.getLength()).contentType(mediatype).body(streamResource);
	}
}
