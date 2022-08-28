package com.david.ProyectoSioca.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "ValorTotal")
	private long Precio;

	@Column(name = "Estado")
	private String Estado;

	@Column(name = "FechaVenta")
	@Temporal(TemporalType.DATE)
	private Date Fecha;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy="IdVenta")
	private List<DetalleVenta> DetalleVenta;

	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(int id, long precio, String estado, Date fecha,
			List<DetalleVenta> detalleVenta) {
		super();
		Id = id;
		Precio = precio;
		Estado = estado;
		Fecha = fecha;
		DetalleVenta = detalleVenta;
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

	public List<DetalleVenta> getDetalleVenta() {
		return DetalleVenta;
	}

	public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
		DetalleVenta = detalleVenta;
	}

	@Override
	public String toString() {
		return "Venta [Id=" + Id + ", Precio=" + Precio + ", Estado=" + Estado + ", Fecha=" + Fecha + "]";
	}

	

}
