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

	private int cantidadproductos;

	private long preciounidad;

	private long preciototal;

	private String observaciones;
	
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "idproveedor")
	private Proveedor proveedor;

	public int getIdorden() {
		return Idorden;
	}

	public void setIdorden(int idOrden) {
		this.Idorden = idOrden;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public int getCantidadproductos() {
		return cantidadproductos;
	}

	public void setCantidadproductos(int cantidadproductos) {
		this.cantidadproductos = cantidadproductos;
	}

	public long getPreciounidad() {
		return preciounidad;
	}

	public void setPreciounidad(long preciounidad) {
		this.preciounidad = preciounidad;
	}

	public long getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(long preciototal) {
		this.preciototal = preciototal;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "OrdenCompra [IdOrden=" + Idorden + ", Fecha=" + Fecha + ", cantidadproductos=" + cantidadproductos
				+ ", preciounidad=" + preciounidad + ", preciototal=" + preciototal + ", observaciones=" + observaciones
				+ ", estado=" + estado + ", proveedor=" + proveedor + "]";
	}

	public OrdenCompra(int idOrden, Date fecha, int cantidadproductos, long preciounidad, long preciototal,
			String observaciones, boolean estado, Proveedor proveedor) {
		super();
		Idorden = idOrden;
		Fecha = fecha;
		this.cantidadproductos = cantidadproductos;
		this.preciounidad = preciounidad;
		this.preciototal = preciototal;
		this.observaciones = observaciones;
		this.estado = estado;
		this.proveedor = proveedor;
	}

	public OrdenCompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
