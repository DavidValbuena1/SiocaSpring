package com.david.ProyectoSioca.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estadodomicilio")
public class EstadoDomicilio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7025864576090242796L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "EstadoDomicilio [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
