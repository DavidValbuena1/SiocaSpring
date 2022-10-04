package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;

import com.david.ProyectoSioca.model.Venta;
import com.david.ProyectoSioca.model.VentasGrafico;

public interface VentaRepository extends Repository<Venta, Integer> {
	public List<Venta> findAll();
	public Venta save(Venta v);
	public Venta findById(int id);
	public Venta deleteById(int id);
	
	@Query("SELECT Max(v.Id) FROM Venta v")
	public int MaxId();
	
	@Query("SELECT NEW com.david.ProyectoSioca.model.VentasGrafico(MONTHNAME(v.Fecha) as mes, SUM(v.Precio) as total) FROM Venta v WHERE YEAR(v.Fecha) = 2022 GROUP BY mes ORDER BY mes ASC")
	public List<VentasGrafico> ventasPorMes();
}
