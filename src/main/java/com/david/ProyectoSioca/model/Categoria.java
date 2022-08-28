package com.david.ProyectoSioca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String Nombre;
	
	@OneToMany(mappedBy="Type", cascade=CascadeType.MERGE)
	private List<Producto> Producto = new ArrayList<Producto>();
	
	@OneToMany(mappedBy="Categoria", cascade=CascadeType.MERGE)
	private List<Proveedor> Proveedor = new ArrayList<Proveedor>();
	
	public Categoria() {
		super();		
	}

	

	public Categoria(int id, String nombre, List<Producto> producto,
			List<Proveedor> proveedor) {
		super();
		this.id = id;
		Nombre = nombre;
		Producto = producto;
		Proveedor = proveedor;
	}



	public List<Producto> getProducto() {
		return Producto;
	}



	public void setProducto(List<Producto> producto) {
		Producto = producto;
	}



	public List<Proveedor> getProveedor() {
		return Proveedor;
	}



	public void setProveedor(List<Proveedor> proveedor) {
		Proveedor = proveedor;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
