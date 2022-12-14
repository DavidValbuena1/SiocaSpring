package com.david.ProyectoSioca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Pedidos;

@Service
public interface PedidosService {
	
	public List<Pedidos> findAll();
	public Optional<Pedidos> findById(int id);
	public Pedidos save(Pedidos pedidos);
	public Pedidos editar(Pedidos pedido);
	
	public List<Pedidos> pedidosPorCliente(int id);
}
