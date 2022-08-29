package com.david.ProyectoSioca.model;

import java.io.Serializable;

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
public class DetalleVenta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Iddetalle;
	
	@Column
	private int Cantidad;
	
	@Column
	private long Subtotal;
	
	@ManyToOne
	@JoinColumn(name="Idproducto")
	private Producto IdProducto;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="Idventa")
	private Venta IdVenta;
	

	public DetalleVenta(int idDetalle, int cantidad, long subTotal, Producto idProducto, Venta idVenta) {
		super();
		Iddetalle = idDetalle;
		Cantidad = cantidad;
		Subtotal = subTotal;
		IdProducto = idProducto;
		IdVenta = idVenta;
	}

	public DetalleVenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDetalle() {
		return Iddetalle;
	}

	public void setIdDetalle(int idDetalle) {
		Iddetalle = idDetalle;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public long getSubTotal() {
		return Subtotal;
	}

	public void setSubTotal(long subTotal) {
		Subtotal = subTotal;
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
