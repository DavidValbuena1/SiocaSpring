package com.david.ProyectoSioca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.EstadoPedido;

@Service
public interface EstadoPedidoService {
	
	public List<EstadoPedido> findAll();
	public Optional<EstadoPedido> findById(int id);
}
