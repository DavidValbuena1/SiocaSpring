package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.Venta;
import com.david.ProyectoSioca.repository.VentaRepository;
import com.david.ProyectoSioca.service.VentaService;

@Component
public class VentaImp implements VentaService {

	@Autowired(required=true)
	private VentaRepository repositorio;
	
	@Override
	public List<Venta> encontrarTodas() {
		return repositorio.findAll();
	}

	@Override
	public Venta insertarVenta(Venta v) {
		return repositorio.save(v);
	}

	@Override
	public Venta encontrarVentaPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Venta editarVenta(Venta v) {
		return repositorio.save(v);
	}

	@Override
	public Venta eliminarVenta(int id) {
		return repositorio.deleteById(id);
	}

	@Override
	public int MaxId() {
		return repositorio.MaxId();
	}
	
}
