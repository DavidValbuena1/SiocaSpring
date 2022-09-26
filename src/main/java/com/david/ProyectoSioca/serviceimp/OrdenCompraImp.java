package com.david.ProyectoSioca.serviceimp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.david.ProyectoSioca.model.DetalleOrdenCompra;
import com.david.ProyectoSioca.model.OrdenCompra;
import com.david.ProyectoSioca.model.Proveedor;
import com.david.ProyectoSioca.model.Reportes;
import com.david.ProyectoSioca.repository.OrdenCompraRepository;
import com.david.ProyectoSioca.repository.ProveedorRepository;
import com.david.ProyectoSioca.service.OrdenCompraService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class OrdenCompraImp implements OrdenCompraService {
	
	@Autowired(required=true)
	private OrdenCompraRepository repositorio;
	
	@Autowired(required=true)
	private SendEmail sendEmail;
	
	@Autowired(required=true)
	private ProveedorRepository repositorioProveedor;
	
	
	@Override
	public List<OrdenCompra> encontrarOrdenesDeCompra() {
		return repositorio.findAll();
	}

	@Override
	public OrdenCompra insertarOrdenesDeCompra(OrdenCompra lista) {
		return repositorio.save(lista);
	}

	@Override
	public OrdenCompra editarOrdenDeCompra(OrdenCompra oc) {
		return repositorio.save(oc);
	}

	@Override
	public OrdenCompra buscarOrdenPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public OrdenCompra eliminarOrdenPorId(int id) {
		return repositorio.deleteById(id);
	}
	
	public String exportarReporte(List<DetalleOrdenCompra> doc) throws FileNotFoundException, JRException {
		int idorden=0;
		int idproveedor=0;
		for(DetalleOrdenCompra d: doc) {
			idorden= d.getOrdenCompra().getIdorden();
			d.setOrdenCompra(repositorio.findById(idorden));
			idproveedor = d.getOrdenCompra().getProveedor().getId_proveedor();
		}
		File file= ResourceUtils.getFile("src//main//resources//ordencompra.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(doc);
		Map<String,Object> map = new HashMap<>();
		map.put("createdBy", "David Valbuena");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		String URLpdf="ordencompra"+idorden+".pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint,URLpdf);
		System.out.println("Pasaste la creación de la orden");
		EnviarEmail(URLpdf,idproveedor);
		return "Bien socio, lo genero";
	}
	
	public void EnviarEmail(String URLpdf,int id) {
		Proveedor p = new Proveedor();
		p = repositorioProveedor.findById(id);
		String to = p.getCorreo1();
		String subject = "Reabastecimiento - Orden de compra";
		String body = "Estimado proveedor " + p.getNombre() + " enviamos Orden de compra para abastecimiento de dichos productos";
		sendEmail.sendMail(to, subject, body, URLpdf);
	}

	@Override
	public int obtenerIdMaximo() {
		return repositorio.obtenerIdMaximo();
	}
	
	public ByteArrayOutputStream export(Map<String,Object> params) throws JRException,IOException{
		List<OrdenCompra> doc = new ArrayList<>();
		doc = repositorio.findAll();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		File file= ResourceUtils.getFile("src//main//resources//ordenes.jrxml");
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
		dto.setFileName("ordencompra.pdf");
		ByteArrayOutputStream stream = export(params);
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}
	
}
