package com.david.ProyectoSioca.service;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.RecuperarContraseña;

@Service
public interface RecuperarContraseñaService {
	
	public RecuperarContraseña validar(String codigorecuperar, String correo);
}
