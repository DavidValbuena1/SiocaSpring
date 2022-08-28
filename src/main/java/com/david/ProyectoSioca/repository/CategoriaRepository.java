package com.david.ProyectoSioca.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.david.ProyectoSioca.model.Categoria;

public interface CategoriaRepository extends Repository<Categoria, Integer> {
	public List<Categoria> findAll();
	public Categoria findById(int id);
	public Categoria save(Categoria c);
	public Categoria deleteById(int id);
}
