package com.david.ProyectoSioca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Domicilios;

@Service
public interface DomiciliosService {
	
	public List<Domicilios> findAll();
	public Domicilios save(Domicilios domicilios);
	public Domicilios editarDomicilio(Domicilios domicilio);
	public Optional<Domicilios> findById(int id);
	
	public List<Domicilios> domiciliosPorRepartidor(int id);
}
