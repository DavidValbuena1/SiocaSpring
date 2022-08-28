package com.david.ProyectoSioca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TipoDocumento")
public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdTipoDocumento;
	@Column(name="TipoDocumento")
	private String Nombre;
	
	@OneToMany(mappedBy="TipoDocumento")
	private List<Usuario> Usuario = new ArrayList<Usuario>();

	public TipoDocumento() {
		super();
	}

	public TipoDocumento(int idTipoDocumento, String nombre, List<Usuario> usuario) {
		super();
		IdTipoDocumento = idTipoDocumento;
		Nombre = nombre;
		Usuario = usuario;
	}

	@Override
	public String toString() {
		return "TipoDocumento [IdTipoDocumento=" + IdTipoDocumento + ", Nombre=" + Nombre + ", Usuario=" + Usuario
				+ "]";
	}

	public int getIdTipoDocumento() {
		return IdTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		IdTipoDocumento = idTipoDocumento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public List<Usuario> getUsuario() {
		return Usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		Usuario = usuario;
	}
	
	
	
	
}
