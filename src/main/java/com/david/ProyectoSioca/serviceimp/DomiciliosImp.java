package com.david.ProyectoSioca.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.Domicilios;
import com.david.ProyectoSioca.repository.DomiciliosRepository;
import com.david.ProyectoSioca.service.DomiciliosService;

@Component
public class DomiciliosImp implements DomiciliosService {

	@Autowired(required=true)
	private DomiciliosRepository repositorio;
	
	@Override
	public List<Domicilios> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Domicilios save(Domicilios domicilios) {
		return repositorio.save(domicilios);
	}

	@Override
	public Domicilios editarDomicilio(Domicilios domicilio) {
		return repositorio.save(domicilio);
	}

	@Override
	public Optional<Domicilios> findById(int id) {
		return repositorio.findById(id);
	}

	@Override
	public List<Domicilios> domiciliosPorRepartidor(int id) {
		return repositorio.domiciliosPorRepartidor(id);
	}

}
