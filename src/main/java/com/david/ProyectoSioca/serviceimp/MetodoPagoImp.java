package com.david.ProyectoSioca.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.MetodoPago;
import com.david.ProyectoSioca.repository.MetodoPagoRepository;
import com.david.ProyectoSioca.service.MetodoPagoService;

@Component
public class MetodoPagoImp implements MetodoPagoService {

	@Autowired(required=true)
	private MetodoPagoRepository repositorio;

	@Override
	public List<MetodoPago> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Optional<MetodoPago> findById(int id) {
		return repositorio.findById(id);
	}

	@Override
	public MetodoPago save(MetodoPago mp) {
		return repositorio.save(mp);
	}
	
	
}
