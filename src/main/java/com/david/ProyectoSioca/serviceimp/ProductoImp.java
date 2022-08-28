package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.Producto;
import com.david.ProyectoSioca.repository.ProductoRepository;
import com.david.ProyectoSioca.service.ProductoService;

@Component
public class ProductoImp implements ProductoService{
	
	@Autowired(required=true)
	private ProductoRepository repositorio;

	@Override
	public List<Producto> encontrarTodosLosProductos() {
		return repositorio.findAll();
	}

	@Override
	public List<Producto> insertarTodosLosProductos(List<Producto> lista) {
		return repositorio.saveAll(lista);
	}

	@Override
	public Producto editarProducto(Producto p) {
		return repositorio.save(p);
	}

	@Override
	public Producto buscarProductoPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Producto eliminarProductoPorId(int id) {
		return repositorio.deleteById(id);
	}
}
