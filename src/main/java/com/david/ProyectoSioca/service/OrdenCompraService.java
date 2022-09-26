package com.david.ProyectoSioca.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.OrdenCompra;
import com.david.ProyectoSioca.model.Reportes;

import net.sf.jasperreports.engine.JRException;

@Service
public interface OrdenCompraService {
	public List<OrdenCompra> encontrarOrdenesDeCompra();
	public OrdenCompra insertarOrdenesDeCompra(OrdenCompra lista);
	public OrdenCompra editarOrdenDeCompra(OrdenCompra oc);
	public OrdenCompra buscarOrdenPorId(int id);
	public OrdenCompra eliminarOrdenPorId(int id);
	
	public int obtenerIdMaximo();
	Reportes obtenerReporteProveedores(Map<String, Object> params) throws IOException, JRException;
}
