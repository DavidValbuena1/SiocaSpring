package com.david.ProyectoSioca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.RecuperarContraseña;

@Service
public interface RecuperarContraseñaService {
	
	public RecuperarContraseña validar(String codigorecuperar, String correo);
	
	public RecuperarContraseña insertar(RecuperarContraseña r);
	
	public List<RecuperarContraseña> codigosactivos();
}
