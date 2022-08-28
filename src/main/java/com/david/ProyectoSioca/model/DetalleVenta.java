package com.david.ProyectoSioca.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalleventa")
public class DetalleVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdDetalle;
	
	@Column
	private int Cantidad;
	
	@Column
	private long SubTotal;
	
	@ManyToOne
	@JoinColumn(name="IdProducto")
	private Producto IdProducto;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="IdVenta")
	private Venta IdVenta;
	

	public DetalleVenta(int idDetalle, int cantidad, long subTotal, Producto idProducto, Venta idVenta) {
		super();
		IdDetalle = idDetalle;
		Cantidad = cantidad;
		SubTotal = subTotal;
		IdProducto = idProducto;
		IdVenta = idVenta;
	}

	public DetalleVenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDetalle() {
		return IdDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		IdDetalle = idDetalle;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public long getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(long subTotal) {
		SubTotal = subTotal;
	}

	public Producto getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(Producto idProducto) {
		IdProducto = idProducto;
	}

	public Venta getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(Venta idVenta) {
		IdVenta = idVenta;
	}

	
	
	
	
}
