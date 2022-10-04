package com.david.ProyectoSioca.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Reportes;
import com.david.ProyectoSioca.model.Venta;
import com.david.ProyectoSioca.model.VentasGrafico;

import net.sf.jasperreports.engine.JRException;

@Service
public interface VentaService {
	
	public List<Venta> encontrarTodas();
	public Venta insertarVenta(Venta v);
	public Venta encontrarVentaPorId(int id);
	public Venta editarVenta(Venta v);
	public Venta eliminarVenta(int id);
	
	public int MaxId();
	public Reportes obtenerReporte(Map<String, Object> params) throws IOException, JRException;
	public Reportes ventasPorMes(Map<String,Object> params) throws IOException, JRException;
}
