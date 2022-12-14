package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.david.ProyectoSioca.model.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer>{

	@Query("SELECT p FROM Pedidos p WHERE p.cliente.id_usuario=?1")
	public List<Pedidos> pedidosPorUsuario(int id);
}
