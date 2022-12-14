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
@Table(name = "pedidos")
public class Pedidos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6653238592537011145L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String direccion;
	
	private long valortotal;
	
	@ManyToOne
	@JoinColumn(name="metodopago")
	private MetodoPago metodopago;
	
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Usuario cliente;
	
	@ManyToOne
	@JoinColumn(name="estadopedido")
	private EstadoPedido estadopedido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getValortotal() {
		return valortotal;
	}

	public void setValortotal(long valortotal) {
		this.valortotal = valortotal;
	}

	public MetodoPago getMetodopago() {
		return metodopago;
	}

	public void setMetodopago(MetodoPago metodopago) {
		this.metodopago = metodopago;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public EstadoPedido getEstadopedido() {
		return estadopedido;
	}

	public void setEstadopedido(EstadoPedido estadopedido) {
		this.estadopedido = estadopedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", direccion=" + direccion + ", valortotal=" + valortotal + ", metodopago="
				+ metodopago + ", cliente=" + cliente + ", estadopedido=" + estadopedido + "]";
	}
	
}
