package com.david.ProyectoSioca.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.david.ProyectoSioca.model.DetalleOrdenCompra;

@Service
public interface DetalleOrdenCompraService {
	
	public List<DetalleOrdenCompra> findAll();
	public DetalleOrdenCompra findById(int id);
	public DetalleOrdenCompra save(DetalleOrdenCompra doc);
	public List<DetalleOrdenCompra> saveAll(Iterable<DetalleOrdenCompra> doc);
	public DetalleOrdenCompra deleteById(int id);
	public List<DetalleOrdenCompra> findByIdOrden(int Idorden);
}
