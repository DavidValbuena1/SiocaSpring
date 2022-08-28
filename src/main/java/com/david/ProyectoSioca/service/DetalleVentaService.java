package com.david.ProyectoSioca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.DetalleVenta;

@Service
public interface DetalleVentaService {
	
	public List<DetalleVenta> encontrarTodosLosDetalles();
	public List<DetalleVenta> insertarDetalles(List<DetalleVenta> lista);
	public DetalleVenta encontrarDetallePorId(int id);
	public DetalleVenta editarDetalle (DetalleVenta dv);
	public DetalleVenta eliminarPorId(int id);
	
	public List<DetalleVenta> encontrarDetallesPorFactura(int id);
}
