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
	
	@Column
	private int descuento;
	
	@ManyToOne
	@JoinColumn(name="Idproducto")
	private Producto IdProducto;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="Idventa")
	private Venta IdVenta;

	public int getIddetalle() {
		return Iddetalle;
	}

	public void setIdDetalle(int iddetalle) {
		Iddetalle = iddetalle;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public long getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(long subtotal) {
		Subtotal = subtotal;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DetalleVenta [Iddetalle=" + Iddetalle + ", Cantidad=" + Cantidad + ", Subtotal=" + Subtotal
				+ ", descuento=" + descuento + ", IdProducto=" + IdProducto + ", IdVenta=" + IdVenta + "]";
	}
	

	
	
	
	
}
