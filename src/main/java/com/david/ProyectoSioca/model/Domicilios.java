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

@Entity
@Table(name="domicilios")
public class Domicilios implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3079191991934982212L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date fechaasignacion;
	
	private Date fechasalida;
	
	private Date fechaentrega;
	
	@ManyToOne
	@JoinColumn(name="estadodomicilio")
	private EstadoDomicilio estado;
	
	@ManyToOne
	@JoinColumn(name="idrepartidor")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="idpedido")
	private Pedidos pedido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EstadoDomicilio getEstado() {
		return estado;
	}

	public void setEstado(EstadoDomicilio estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Date getFechaasignacion() {
		return fechaasignacion;
	}

	public void setFechaasignacion(Date fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	public Date getFechaentrega() {
		return fechaentrega;
	}

	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Domicilios [id=" + id + ", fechaasignacion=" + fechaasignacion + ", fechasalida=" + fechasalida
				+ ", fechaentrega=" + fechaentrega + ", estado=" + estado + ", usuario=" + usuario + ", pedido="
				+ pedido + "]";
	}
	
}
