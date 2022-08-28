package com.david.ProyectoSioca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id_proveedor;
	
	@Column(name="Nombre_proveedor")
	private String Nombre;
	
	@Column(name="Nombre_empresa")
	private String NombreEmpresa;
	
	@Column(name="Direccion1_proveedor")
	private String Direccion1;
	
	@Column(name="Direccion2_proveedor")
	private String Direccion2;
	
	@Column(name="Correo1_proveedor")
	private String Correo1;
	
	@Column(name="Correo2_proveedor")
	private String Correo2;
	
	@Column(name="Nit")
	private String Nit;
	
	@ManyToOne
	@JoinColumn(name="Categoria")
	private Categoria Categoria;
	
	@OneToMany(mappedBy="proveedor", cascade= CascadeType.MERGE)
	private List<Producto> Producto;
	
	@Column(name="Ciudad")
	private String Ciudad;

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Proveedor(int id_proveedor, String nombre, String nombreEmpresa, String direccion1, String direccion2,
			String correo1, String correo2, String nit, Categoria categoria,
			List<Producto> producto, String ciudad) {
		super();
		Id_proveedor = id_proveedor;
		Nombre = nombre;
		NombreEmpresa = nombreEmpresa;
		Direccion1 = direccion1;
		Direccion2 = direccion2;
		Correo1 = correo1;
		Correo2 = correo2;
		Nit = nit;
		Categoria = categoria;
		Producto = producto;
		Ciudad = ciudad;
	}



	@Override
	public String toString() {
		return "Proveedor [Id_proveedor=" + Id_proveedor + ", Nombre=" + Nombre + ", Apellido=" 
				+ ", NombreEmpresa=" + NombreEmpresa + ", Direccion1=" + Direccion1 + ", Direccion2=" + Direccion2
				+ ", Correo1=" + Correo1 + ", Correo2=" + Correo2 + ", Nit=" + Nit + ", Categoria=" + Categoria
				+ ", Ciudad=" + Ciudad + "]";
	}

	
	public List<Producto> getProducto() {
		return Producto;
	}



	public void setProducto(List<Producto> producto) {
		Producto = producto;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getId_proveedor() {
		return Id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		Id_proveedor = id_proveedor;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	


	public String getNombreEmpresa() {
		return NombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		NombreEmpresa = nombreEmpresa;
	}

	public String getDireccion1() {
		return Direccion1;
	}

	public void setDireccion1(String direccion1) {
		Direccion1 = direccion1;
	}

	public String getDireccion2() {
		return Direccion2;
	}

	public void setDireccion2(String direccion2) {
		Direccion2 = direccion2;
	}

	public String getCorreo1() {
		return Correo1;
	}

	public void setCorreo1(String correo1) {
		Correo1 = correo1;
	}

	public String getCorreo2() {
		return Correo2;
	}

	public void setCorreo2(String correo2) {
		Correo2 = correo2;
	}

	public String getNit() {
		return Nit;
	}

	public void setNit(String nit) {
		Nit = nit;
	}

	public Categoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	
	
	
	
}
