package com.david.ProyectoSioca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.MetodoPago;

@Service
public interface MetodoPagoService {

	public List<MetodoPago> findAll();
	public Optional<MetodoPago> findById(int id);
	public MetodoPago save(MetodoPago mp);
}
