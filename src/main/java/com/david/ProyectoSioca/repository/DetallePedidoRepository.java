package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.david.ProyectoSioca.model.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

	@Query("SELECT p FROM DetallePedido p WHERE p.pedido.id= ?1")
	public List<DetallePedido> detallesPorPedido(int id);
}
