package com.david.ProyectoSioca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.ProyectoSioca.model.EstadoDomicilio;

@Repository
public interface EstadoDomicilioRepository extends JpaRepository<EstadoDomicilio, Integer> {

}
