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

import com.david.ProyectoSioca.model.Reportes;
import com.david.ProyectoSioca.model.Venta;
import com.david.ProyectoSioca.model.VentasGrafico;
import com.david.ProyectoSioca.repository.VentaRepository;
import com.david.ProyectoSioca.service.VentaService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class VentaImp implements VentaService {

	@Autowired(required=true)
	private VentaRepository repositorio;
	
	@Override
	public List<Venta> encontrarTodas() {
		return repositorio.findAll();
	}

	@Override
	public Venta insertarVenta(Venta v) {
		return repositorio.save(v);
	}

	@Override
	public Venta encontrarVentaPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Venta editarVenta(Venta v) {
		return repositorio.save(v);
	}

	@Override
	public Venta eliminarVenta(int id) {
		return repositorio.deleteById(id);
	}

	@Override
	public int MaxId() {
		return repositorio.MaxId();
	}
	
	public ByteArrayOutputStream export(Map<String,Object> params) throws JRException,IOException{
		List<Venta> doc = new ArrayList<>();
		doc = repositorio.findAll();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		File file= ResourceUtils.getFile("src//main//resources//venta.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(doc);
		Map<String,Object> map = new HashMap<>();
		map.put("createdBy", "David Valbuena");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		return stream;
	}

	@Override
	public Reportes obtenerReporte(Map<String, Object> params) throws IOException, JRException {
		Reportes dto = new Reportes();
		dto.setFileName("venta.pdf");
		ByteArrayOutputStream stream = export(params);
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

    @Override
    public Reportes ventasPorMes(Map<String, Object> params) throws IOException, JRException {
        Reportes dto = new Reportes();
        dto.setFileName("ventasgraficos.pdf");
        ByteArrayOutputStream stream = exportarGrafico(params);
        byte[] bs = stream.toByteArray();
        dto.setStream(new ByteArrayInputStream(bs));
        dto.setLength(bs.length);
        return dto;
    }
    
    public ByteArrayOutputStream exportarGrafico(Map<String,Object> params) throws JRException,IOException{
        List<VentasGrafico> doc = new ArrayList<>();
        doc = repositorio.ventasPorMes();
        System.out.println(doc);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        File file= ResourceUtils.getFile("src//main//resources//graficoVenta.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(doc);
        Map<String,Object> map = new HashMap<>();
        map.put("createdBy", "David Valbuena");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
        return stream;
    }

	@Override
	public List<VentasGrafico> graficoVentas() {
		return repositorio.ventasPorMes();
	}

    
	
	
	
}
