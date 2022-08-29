package com.david.ProyectoSioca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venta")
public class Venta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "Valortotal")
	private long Precio;

	@Column(name = "Estado")
	private String Estado;

	@Column(name = "fechaventa")
	@Temporal(TemporalType.DATE)
	private Date Fecha;


	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(int id, long precio, String estado, Date fecha) {
		super();
		Id = id;
		Precio = precio;
		Estado = estado;
		Fecha = fecha;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public long getPrecio() {
		return Precio;
	}

	public void setPrecio(long precio) {
		Precio = precio;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	@Override
	public String toString() {
		return "Venta [Id=" + Id + ", Precio=" + Precio + ", Estado=" + Estado + ", Fecha=" + Fecha + "]";
	}

	

}
