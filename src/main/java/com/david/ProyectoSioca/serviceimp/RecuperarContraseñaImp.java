package com.david.ProyectoSioca.serviceimp;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

 	@Scheduled(fixedRate = 1000*10)
 	public void tarea() {
 		List<RecuperarContraseña> codigos = new ArrayList<>();
		codigos = codigosactivos();
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime fecha;
 		for(RecuperarContraseña c : codigos) {
 			fecha = c.getHoradecreacion().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
 			
 			long diferenciadesegundos = ChronoUnit.SECONDS.between(fecha, hoy);
 			if(diferenciadesegundos>1800) {
 				c.setEstado((byte) 0);				
 				repository.save(c);
 			}
 		}
 	}
	
}
