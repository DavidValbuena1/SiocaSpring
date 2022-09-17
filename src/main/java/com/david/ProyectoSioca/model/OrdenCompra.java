package com.david.ProyectoSioca.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "ordencompra")
public class OrdenCompra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Idorden;

	@Temporal(TemporalType.DATE)
	private Date Fecha;

	private String observaciones;
	
	private byte estado;

	@ManyToOne
	@JoinColumn(name = "idproveedor")
	private Proveedor proveedor;

	public int getIdorden() {
		return Idorden;
	}

	public void setIdorden(int idorden) {
		Idorden = idorden;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
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

	@Override
	public String toString() {
		return "OrdenCompra [Idorden=" + Idorden + ", Fecha=" + Fecha + ", observaciones=" + observaciones + ", estado="
				+ estado + ", proveedor=" + proveedor + "]";
	}
	
	
	
	

}
