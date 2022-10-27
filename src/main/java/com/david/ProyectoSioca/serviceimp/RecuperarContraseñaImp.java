package com.david.ProyectoSioca.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.RecuperarContraseña;
import com.david.ProyectoSioca.repository.RecuperarContraseñaRepository;
import com.david.ProyectoSioca.service.RecuperarContraseñaService;

@Component
public class RecuperarContraseñaImp implements RecuperarContraseñaService {

	
	@Autowired(required=true)
	private RecuperarContraseñaRepository repository;
	
	@Override
	public RecuperarContraseña validar(String codigorecuperar, String Correo) {
		return repository.validar(codigorecuperar, Correo);
	}

}
