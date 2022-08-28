package com.david.ProyectoSioca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Producto;

@Service
public interface ProductoService {
	public List<Producto> encontrarTodosLosProductos();
	public List<Producto> insertarTodosLosProductos(List<Producto> lista);
	public Producto editarProducto(Producto p);
	public Producto buscarProductoPorId(int id);
	public Producto eliminarProductoPorId(int id);
}
