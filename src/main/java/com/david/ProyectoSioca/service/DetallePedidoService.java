package com.david.ProyectoSioca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.DetallePedido;

@Service
public interface DetallePedidoService {
	
	public List<DetallePedido> detallesPorPedido(int idpedido);
	public List<DetallePedido> insertarTodosLosDetalles(Iterable<DetallePedido> detalles);
	public DetallePedido editarDetalle(DetallePedido detalle);
	public Optional<DetallePedido> findById(int id);
}
