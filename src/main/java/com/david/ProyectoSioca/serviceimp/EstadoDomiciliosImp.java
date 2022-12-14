package com.david.ProyectoSioca.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.EstadoDomicilio;
import com.david.ProyectoSioca.repository.EstadoDomicilioRepository;
import com.david.ProyectoSioca.service.EstadoDomiciliosService;

@Component
public class EstadoDomiciliosImp implements EstadoDomiciliosService {

	@Autowired(required=true)
	private EstadoDomicilioRepository repositorio;

	@Override
	public List<EstadoDomicilio> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Optional<EstadoDomicilio> findById(int id) {
		return repositorio.findById(id);
	}
	
}
