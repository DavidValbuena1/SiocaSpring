package com.david.ProyectoSioca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
@Table(name="recuperarcontraseña")
public class RecuperarContraseña implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3250654898946856959L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 6)
	private String codigorecuperacion;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	@Column
	private byte estado;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date horadecreacion;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigorecuperacion() {
		return codigorecuperacion;
	}

	public void setCodigorecuperacion(String codigorecuperacion) {
		this.codigorecuperacion = codigorecuperacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getHoradecreacion() {
		return horadecreacion;
	}

	public void setHoradecreacion(Date horadecreacion) {
		this.horadecreacion = horadecreacion;
	}

	@Override
	public String toString() {
		return "RecuperarContraseña [id=" + id + ", codigorecuperacion=" + codigorecuperacion + ", usuario=" + usuario
				+ ", estado=" + estado + ", horadecreacion=" + horadecreacion + "]";
	}
	
	

	
	
	
}
