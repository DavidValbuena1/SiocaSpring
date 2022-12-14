package com.david.ProyectoSioca.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.EstadoPedido;
import com.david.ProyectoSioca.repository.EstadoPedidoRepository;
import com.david.ProyectoSioca.service.EstadoPedidoService;

@Component
public class EstadoPedidoImp implements EstadoPedidoService {

	@Autowired(required=true)
	private EstadoPedidoRepository repositorio;

	@Override
	public List<EstadoPedido> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Optional<EstadoPedido> findById(int id) {
		return repositorio.findById(id);
	}
}
