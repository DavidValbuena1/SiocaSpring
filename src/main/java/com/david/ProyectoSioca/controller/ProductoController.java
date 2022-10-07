package com.david.ProyectoSioca.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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
import org.springframework.web.multipart.MultipartFile;

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
	    List<Producto> lista = new ArrayList<>();
	    lista = service.encontrarTodosLosProductos();
	    for(Producto p: lista) {
	        p.setByteimagen(descomprimitbites(p.getByteimagen()));
	    }
		return lista;
	}
	
	@GetMapping(path= {"/listarId/{id}"})
	public Producto encontrarProducto(@PathVariable("id") int id) {
		Producto p = new Producto();
		p=service.buscarProductoPorId(id);
		p.setByteimagen(descomprimitbites(p.getByteimagen()));
		return p;
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
	
	@PutMapping(path= {"/subirImagen/{id}"})
	public Producto subirImagen(@RequestParam("imagen") MultipartFile file, @PathVariable("id") int id) throws IOException{
	    Producto p = new Producto();
	    p = service.buscarProductoPorId(id);
	    p.setNombreimagen(file.getOriginalFilename());
	    p.setTipoimagen(file.getContentType());
	    p.setByteimagen(comprimirbites(file.getBytes()));
	    return service.editarProducto(p);
	}
	
	public static byte[] comprimirbites(byte[] data) {
	    Deflater deflater = new Deflater();
	    deflater.setInput(data);
	    deflater.finish();
	    
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
	    while(!deflater.finished()) {
	        int count = deflater.deflate(buffer);
	        output.write(buffer,0,count);
	    }
	    
	    try {
	        output.close();
	    }catch(IOException e) {
	        
	    }
	    return output.toByteArray();
	}
	
	public static byte[] descomprimitbites(byte[] data) {
	    Inflater inflater = new Inflater();
	    inflater.setInput(data);
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
	    try {
	        while(!inflater.finished()) {
	            int count = inflater.inflate(buffer);
	            output.write(buffer,0,count);
	        }
	        output.close();
	    }catch(IOException e) {      
	    } catch (DataFormatException e) {
        }
	    
	    return output.toByteArray();
	}
}
