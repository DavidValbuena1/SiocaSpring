package com.david.ProyectoSioca.model;

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
public class OrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdOrden;

	@Temporal(TemporalType.DATE)
	private Date Fecha;

	private int CantidadProductos;

	private long PrecioUnidad;

	private long PrecioTotal;

	private String Observaciones;
	
	private boolean Estado;

	@ManyToOne
	@JoinColumn(name = "IdProveedor")
	private Proveedor proveedor;

	
	
	public boolean Estado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

	public int getIdOrden() {
		return IdOrden;
	}

	public void setIdOrden(int idOrden) {
		IdOrden = idOrden;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public int getCantidadProductos() {
		return CantidadProductos;
	}

	public void setCantidadProductos(int cantidadProductos) {
		CantidadProductos = cantidadProductos;
	}

	public long getPrecioUnidad() {
		return PrecioUnidad;
	}

	public void setPrecioUnidad(long precioUnidad) {
		PrecioUnidad = precioUnidad;
	}

	public long getPrecioTotal() {
		return PrecioTotal;
	}

	public void setPrecioTotal(long precioTotal) {
		PrecioTotal = precioTotal;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public OrdenCompra(int idOrden, Date fecha, int cantidadProductos, long precioUnidad, long precioTotal,
			String observaciones, Proveedor proveedor) {
		super();
		IdOrden = idOrden;
		Fecha = fecha;
		CantidadProductos = cantidadProductos;
		PrecioUnidad = precioUnidad;
		PrecioTotal = precioTotal;
		Observaciones = observaciones;
		this.proveedor = proveedor;
	}

	public OrdenCompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrdenCompra [IdOrden=" + IdOrden + ", Fecha=" + Fecha + ", CantidadProductos=" + CantidadProductos
				+ ", PrecioUnidad=" + PrecioUnidad + ", PrecioTotal=" + PrecioTotal + ", Observaciones=" + Observaciones
				+ ", proveedor=" + proveedor + "]";
	}

	

}
