package com.david.ProyectoSioca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Venta;

@Service
public interface VentaService {
	
	public List<Venta> encontrarTodas();
	public Venta insertarVenta(Venta v);
	public Venta encontrarVentaPorId(int id);
	public Venta editarVenta(Venta v);
	public Venta eliminarVenta(int id);
	
	public int MaxId();
}
