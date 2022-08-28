package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.DetalleVenta;

public interface DetalleVentaRepository extends Repository<DetalleVenta, Integer> {
	public List<DetalleVenta> findAll();
	public DetalleVenta findById(int id);
	public DetalleVenta save(DetalleVenta dv);
	public List<DetalleVenta> saveAll(Iterable<DetalleVenta> df);
	public DetalleVenta deleteById(int id);
	
	@Query(value="SELECT dv FROM DetalleVenta dv WHERE dv.IdVenta.Id = ?1")
	public List<DetalleVenta> encontrarDetallesPorVenta(int Id);
}
