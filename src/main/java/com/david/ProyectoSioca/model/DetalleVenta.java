package com.david.ProyectoSioca.model;

import java.io.Serializable;

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
	@JoinColumn(name="idproducto")
	private Producto idproducto;
	
	@ManyToOne
	@JoinColumn(name="idventa")
	private Venta idventa;

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

	public Producto getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Producto idproducto) {
		this.idproducto = idproducto;
	}

	public Venta getIdventa() {
		return idventa;
	}

	public void setIdventa(Venta idventa) {
		this.idventa = idventa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DetalleVenta [Iddetalle=" + Iddetalle + ", Cantidad=" + Cantidad + ", Subtotal=" + Subtotal
				+ ", descuento=" + descuento + ", idproducto=" + idproducto + ", idventa=" + idventa + "]";
	}

	
	
}
