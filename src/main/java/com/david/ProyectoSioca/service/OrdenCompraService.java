package com.david.ProyectoSioca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.OrdenCompra;

@Service
public interface OrdenCompraService {
	public List<OrdenCompra> encontrarOrdenesDeCompra();
	public OrdenCompra insertarOrdenesDeCompra(OrdenCompra lista);
	public OrdenCompra editarOrdenDeCompra(OrdenCompra oc);
	public OrdenCompra buscarOrdenPorId(int id);
	public OrdenCompra eliminarOrdenPorId(int id);
	
	public int obtenerIdMaximo();
}
