package com.david.ProyectoSioca.serviceimp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

	@Override
	public RecuperarContraseña insertar(RecuperarContraseña r) {
		return repository.save(r);
	}

	@Override
	public List<RecuperarContraseña> codigosactivos() {
		return repository.codigosactivos();
	}

// 	@Scheduled(fixedRate = 1000)
// 	public void tarea() {
// 		List<RecuperarContraseña> codigos = new ArrayList<>();
// 		codigos = codigosactivos();
// 		DateFormat hoy = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss");
// 		Date fechahoy = hoy.format(new Date());
// 		for(RecuperarContraseña c : codigos) {
// 		}
// 	}
	
}
