package com.david.ProyectoSioca.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Proveedor;
import com.david.ProyectoSioca.model.ReporteProveedores;

import net.sf.jasperreports.engine.JRException;

@Service
public interface ProveedorService {
	public List<Proveedor> encontrarTodosLosProveedores();
	public List<Proveedor> insertarProveedores(List<Proveedor> lista);
	public Proveedor editarProveedor(Proveedor p);
	public Proveedor encontrarProveedorPorId(int id);
	public Proveedor eliminarProveedorPorId(int id);
	
	public ReporteProveedores obtenerReporteProveedores(Map<String, Object> params) throws IOException, JRException;
}
