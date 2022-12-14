package com.david.ProyectoSioca.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Producto;
import com.david.ProyectoSioca.model.Reportes;

import net.sf.jasperreports.engine.JRException;

@Service
public interface ProductoService {
	public List<Producto> encontrarTodosLosProductos();
	public List<Producto> insertarTodosLosProductos(List<Producto> lista);
	public Producto editarProducto(Producto p);
	public Producto buscarProductoPorId(int id);
	public Producto eliminarProductoPorId(int id);
	public List<Producto> encontrarProductoPorCategoria(int id);
	Reportes obtenerReporteProveedores(Map<String, Object> params) throws IOException, JRException;
}
