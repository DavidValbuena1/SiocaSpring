package com.david.ProyectoSioca.service;

import java.util.List;

import com.david.ProyectoSioca.model.TipoDocumento;

public interface TipoDocumentoService {
	
	public List<TipoDocumento> encontrarTodosLosTipos();
	public TipoDocumento insertarTipo(TipoDocumento td);
	public TipoDocumento editarTipo(TipoDocumento td);
	public TipoDocumento eliminarTipoPorId(int id);
	public TipoDocumento encontrarTipoPorId(int id);
}
