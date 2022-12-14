package com.david.ProyectoSioca.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.Pedidos;
import com.david.ProyectoSioca.repository.PedidosRepository;
import com.david.ProyectoSioca.service.PedidosService;

@Component
public class PedidosImp implements PedidosService {

	@Autowired(required=true)
	private PedidosRepository repositorio;

	@Override
	public List<Pedidos> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Pedidos> findById(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Pedidos save(Pedidos pedidos) {
		return repositorio.save(pedidos);
	}

	@Override
	public Pedidos editar(Pedidos pedido) {
		return repositorio.save(pedido);
	}

	@Override
	public List<Pedidos> pedidosPorCliente(int id) {
		return repositorio.pedidosPorUsuario(id);
	}
	
	
}
