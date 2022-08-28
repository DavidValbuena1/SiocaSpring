package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.TipoDocumento;

public interface TipoDocumentoRepository extends Repository<TipoDocumento,Integer> {
	public List<TipoDocumento> findAll();
	public TipoDocumento findById(int id);
	public TipoDocumento deleteById(int id);
	public TipoDocumento save(TipoDocumento td);
}
