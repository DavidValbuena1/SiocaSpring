package com.david.ProyectoSioca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.EstadoDomicilio;

@Service
public interface EstadoDomiciliosService {
	
	public List<EstadoDomicilio> findAll();
	public Optional<EstadoDomicilio> findById(int id);
}
