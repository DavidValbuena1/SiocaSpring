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

	private byte estado;
	
	private int valortotal;

	@ManyToOne
	@JoinColumn(name = "idproveedor")
	private Proveedor proveedor;
	
	public int getValortotal() {
		return valortotal;
	}

	public void setValortotal(int valortotal) {
		this.valortotal = valortotal;
	}

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
		return "OrdenCompra [Idorden=" + Idorden + ", Fecha=" + Fecha + ", estado="
				+ estado + ", proveedor=" + proveedor + "]";
	}

	public OrdenCompra(int idorden, Date fecha, byte estado, int valortotal,
			Proveedor proveedor) {
		super();
		Idorden = idorden;
		Fecha = fecha;
		this.estado = estado;
		this.valortotal = valortotal;
		this.proveedor = proveedor;
	}

	public OrdenCompra() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
