package com.david.ProyectoSioca.serviceimp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.david.ProyectoSioca.model.Producto;
import com.david.ProyectoSioca.model.Reportes;
import com.david.ProyectoSioca.repository.ProductoRepository;
import com.david.ProyectoSioca.service.ProductoService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class ProductoImp implements ProductoService{
	
	@Autowired(required=true)
	private ProductoRepository repositorio;

	@Override
	public List<Producto> encontrarTodosLosProductos() {
		return repositorio.findAll();
	}

	@Override
	public List<Producto> insertarTodosLosProductos(List<Producto> lista) {
		return repositorio.saveAll(lista);
	}

	@Override
	public Producto editarProducto(Producto p) {
		return repositorio.save(p);
	}

	@Override
	public Producto buscarProductoPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Producto eliminarProductoPorId(int id) {
		return repositorio.deleteById(id);
	}
	
	public ByteArrayOutputStream export(Map<String,Object> params) throws JRException,IOException{
		List<Producto> doc = new ArrayList<>();
		doc = repositorio.findAll();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		File file= ResourceUtils.getFile("src//main//resources//inventario.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(doc);
		Map<String,Object> map = new HashMap<>();
		map.put("createdBy", "David Valbuena");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		return stream;
	}

	@Override
	public Reportes obtenerReporteProveedores(Map<String, Object> params) throws IOException, JRException {
		Reportes dto = new Reportes();
		dto.setFileName("inventario.pdf");
		ByteArrayOutputStream stream = export(params);
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}
}
