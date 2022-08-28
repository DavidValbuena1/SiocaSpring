package com.david.ProyectoSioca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="producto")
public class Producto implements Serializable{
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_producto;
	
	@Column (name="tallas")
	private String Size;
	
	@Column (name="nombre_producto")
	private String Nombre;
	
	@Column (name="Referencia")
	private String Reference;
	
	@Column (name="Cantidad")
	private int Quantity;
	
	@Column (name="Precio_unidad")
	private int Price;
	
	@Column (name="Fecha")
	@Temporal(TemporalType.DATE)
	private Date Date;
	
	@Column(name="PrecioTotal")
	private long PrecioTotal;
	
	@ManyToOne
	@JoinColumn(name="Tipo")
	private Categoria Type;
	
	@ManyToOne
	@JoinColumn(name="Id_proveedor")
	private Proveedor proveedor;

	public long getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Categoria getType() {
		return Type;
	}

	public void setType(Categoria type) {
		Type = type;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public long getPrecioTotal() {
		return PrecioTotal;
	}

	public void setPrecioTotal(long precioTotal) {
		PrecioTotal = precioTotal;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int id_producto, String size, String nombre, String reference, int quantity, int price,
			java.util.Date date, long precioTotal, Categoria type, Proveedor proveedor) {
		super();
		this.id_producto = id_producto;
		Size = size;
		Nombre = nombre;
		Reference = reference;
		Quantity = quantity;
		Price = price;
		Date = date;
		PrecioTotal = precioTotal;
		Type = type;
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", Size=" + Size + ", Nombre=" + Nombre + ", Reference="
				+ Reference + ", Quantity=" + Quantity + ", Price=" + Price + ", Date=" + Date + ", PrecioTotal="
				+ PrecioTotal + ", Type=" + Type + ", proveedor=" + proveedor + "]";
	}

	

	
}
