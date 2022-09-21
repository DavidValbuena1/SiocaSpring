package com.david.ProyectoSioca.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.Categoria;
import com.david.ProyectoSioca.repository.CategoriaRepository;
import com.david.ProyectoSioca.service.CategoriaService;

@Component
public class CategoriaImp implements CategoriaService {

	@Autowired(required=true)
	private CategoriaRepository repositorio;
	
	@Override
	public List<Categoria> encontrarCategorias() {
		return repositorio.findAll();
	}

	@Override
	public Categoria insertarCategoria(Categoria c) {
		return repositorio.save(c);
	}

	@Override
	public Categoria editarCategoria(Categoria c) {
		return repositorio.save(c);
	}

	@Override
	public Categoria eliminarCategoriaPorId(int id) {
		return repositorio.deleteById(id);
	}

	@Override
	public Categoria encontrarCategoriaPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Categoria buscarPorNombre(String nombre) {
		return repositorio.buscarPorNombre(nombre);
	}

}
