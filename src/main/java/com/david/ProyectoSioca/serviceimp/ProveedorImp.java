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

import com.david.ProyectoSioca.model.Proveedor;
import com.david.ProyectoSioca.model.Reportes;
import com.david.ProyectoSioca.repository.ProveedorRepository;
import com.david.ProyectoSioca.service.ProveedorService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class ProveedorImp implements ProveedorService{

	@Autowired(required=true)
	private ProveedorRepository repositorio;

	
	@Override
	public List<Proveedor> encontrarTodosLosProveedores() {
		return repositorio.findAll();
	}

	@Override
	public List<Proveedor> insertarProveedores(List<Proveedor> lista) {
		return repositorio.saveAll(lista);
	}

	@Override
	public Proveedor editarProveedor(Proveedor p) {
		return repositorio.save(p);
	}

	@Override
	public Proveedor encontrarProveedorPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Proveedor eliminarProveedorPorId(int id) {
		return repositorio.deleteById(id);
	}
	
	
	public ByteArrayOutputStream export(Map<String,Object> params) throws JRException,IOException{
		List<Proveedor> doc = new ArrayList<>();
		doc = repositorio.findAll();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		File file= ResourceUtils.getFile("src//main//resources//proveedor.jrxml");
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
		dto.setFileName("Proveedor.pdf");
		ByteArrayOutputStream stream = export(params);
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}
	
}
