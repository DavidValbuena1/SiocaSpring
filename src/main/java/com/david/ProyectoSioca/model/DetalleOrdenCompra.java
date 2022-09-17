package com.david.ProyectoSioca.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalleordencompra")
public class DetalleOrdenCompra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6337272159808939815L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int cantidadproducto;
	
	@ManyToOne
	@JoinColumn(name="idordencompra")
	private OrdenCompra ordenCompra;
	
	private int preciounidad;
	
	private int preciototal;
	
	private String observaciones;
	
	private int descuento;
	
	private String nombreproducto;
	
	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadproducto() {
		return cantidadproducto;
	}

	public void setCantidadproducto(int cantidadproducto) {
		this.cantidadproducto = cantidadproducto;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public int getPreciounidad() {
		return preciounidad;
	}

	public void setPreciounidad(int preciounidad) {
		this.preciounidad = preciounidad;
	}

	public int getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(int preciototal) {
		this.preciototal = preciototal;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DetalleOrdenCompra [id=" + id + ", cantidadproducto=" + cantidadproducto + ", ordenCompra="
				+ ordenCompra + ", preciounidad=" + preciounidad + ", preciototal=" + preciototal + ", observaciones="
				+ observaciones + ", descuento=" + descuento + ", nombreproducto=" + nombreproducto + "]";
	}
	
}
