package com.david.ProyectoSioca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.ProyectoSioca.model.Categoria;

@Service
public interface CategoriaService {
	public List<Categoria> encontrarCategorias();
	public Categoria insertarCategoria(Categoria c);
	public Categoria editarCategoria(Categoria c);
	public Categoria eliminarCategoriaPorId(int id);
	public Categoria encontrarCategoriaPorId(int id);
	
	public Categoria buscarPorNombre(String nombre);
}
