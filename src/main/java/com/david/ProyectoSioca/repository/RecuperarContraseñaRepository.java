package com.david.ProyectoSioca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.david.ProyectoSioca.model.RecuperarContraseña;

public interface RecuperarContraseñaRepository extends JpaRepository<RecuperarContraseña, Integer> {
	
	@Query("SELECT r FROM RecuperarContraseña r WHERE r.codigorecuperacion = ?1 AND r.usuario.Correo = ?2")
	public RecuperarContraseña validar(String codigorecuperar, String correo);
}
