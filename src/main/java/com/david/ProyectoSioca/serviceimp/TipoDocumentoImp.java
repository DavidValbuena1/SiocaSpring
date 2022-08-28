package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.TipoDocumento;
import com.david.ProyectoSioca.repository.TipoDocumentoRepository;
import com.david.ProyectoSioca.service.TipoDocumentoService;

@Component
public class TipoDocumentoImp implements TipoDocumentoService{
	
	@Autowired(required=true)
	private TipoDocumentoRepository repositorio;

	@Override
	public List<TipoDocumento> encontrarTodosLosTipos() {
		return repositorio.findAll();
	}

	@Override
	public TipoDocumento insertarTipo(TipoDocumento td) {
		return repositorio.save(td);
	}

	@Override
	public TipoDocumento editarTipo(TipoDocumento td) {
		return repositorio.save(td);
	}

	@Override
	public TipoDocumento eliminarTipoPorId(int id) {
		return repositorio.deleteById(id);
	}

	@Override
	public TipoDocumento encontrarTipoPorId(int id) {
		return repositorio.findById(id);
	}
	
	
}
