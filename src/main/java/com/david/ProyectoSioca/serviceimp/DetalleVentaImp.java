package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.DetalleVenta;
import com.david.ProyectoSioca.repository.DetalleVentaRepository;
import com.david.ProyectoSioca.service.DetalleVentaService;

@Component
public class DetalleVentaImp implements DetalleVentaService {
	
	@Autowired(required=true)
	private DetalleVentaRepository repositorio;

	@Override
	public List<DetalleVenta> encontrarTodosLosDetalles() {
		return repositorio.findAll();
	}

	@Override
	public List<DetalleVenta> insertarDetalles(List<DetalleVenta> lista) {
		return repositorio.saveAll(lista);
	}

	@Override
	public DetalleVenta encontrarDetallePorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public DetalleVenta editarDetalle(DetalleVenta dv) {
		return repositorio.save(dv);
	}

	@Override
	public DetalleVenta eliminarPorId(int id) {
		return repositorio.deleteById(id);
	}

	@Override
	public List<DetalleVenta> encontrarDetallesPorFactura(int id) {
		return repositorio.encontrarDetallesPorVenta(id);
	}
}
