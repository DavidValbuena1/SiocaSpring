package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.david.ProyectoSioca.model.Domicilios;

@Repository
public interface DomiciliosRepository extends JpaRepository<Domicilios, Integer> {

	@Query("SELECT d FROM Domicilios d WHERE d.usuario.id_usuario=?1")
	public List<Domicilios> domiciliosPorRepartidor(int id);
}
