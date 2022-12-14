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
@Table(name="detallepedido")
public class DetallePedido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4038525857625889589L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private long cantidad;
	
	private long valorunidad;
	
	private long valortotal;
	
	private int descuento;
	
	@ManyToOne
	@JoinColumn(name="idpedido")
	private Pedidos pedido;
	
	@ManyToOne
	@JoinColumn(name="idproducto")
	private Producto producto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public long getValorunidad() {
		return valorunidad;
	}

	public void setValorunidad(long valorunidad) {
		this.valorunidad = valorunidad;
	}

	public long getValortotal() {
		return valortotal;
	}

	public void setValortotal(long valortotal) {
		this.valortotal = valortotal;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", cantidad=" + cantidad + ", valorunidad=" + valorunidad + ", valortotal="
				+ valortotal + ", descuento=" + descuento + ", pedido=" + pedido + ", producto=" + producto + "]";
	}
	
	
	
}
