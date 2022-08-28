package com.david.ProyectoSioca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Proveedor;

@Service
public interface ProveedorService {
	public List<Proveedor> encontrarTodosLosProveedores();
	public List<Proveedor> insertarProveedores(List<Proveedor> lista);
	public Proveedor editarProveedor(Proveedor p);
	public Proveedor encontrarProveedorPorId(int id);
	public Proveedor eliminarProveedorPorId(int id);
}
