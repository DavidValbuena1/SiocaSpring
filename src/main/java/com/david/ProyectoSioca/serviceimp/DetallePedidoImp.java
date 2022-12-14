package com.david.ProyectoSioca.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.DetallePedido;
import com.david.ProyectoSioca.repository.DetallePedidoRepository;
import com.david.ProyectoSioca.service.DetallePedidoService;

@Component
public class DetallePedidoImp implements DetallePedidoService {

	@Autowired(required=true)
	private DetallePedidoRepository repositorio;
	
	@Override
	public List<DetallePedido> detallesPorPedido(int idpedido) {
		return repositorio.detallesPorPedido(idpedido);
	}

	@Override
	public List<DetallePedido> insertarTodosLosDetalles(Iterable<DetallePedido> detalles) {
		return repositorio.saveAll(detalles);
	}

	@Override
	public DetallePedido editarDetalle(DetallePedido detalle) {
		return repositorio.save(detalle);
	}

	@Override
	public Optional<DetallePedido> findById(int id) {
		return repositorio.findById(id);
	}

}
