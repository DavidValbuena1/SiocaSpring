package com.david.ProyectoSioca.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipodocumento")
public class TipoDocumento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtipodocumento;
	@Column(name="tipodocumento")
	private String Nombre;
	


	public TipoDocumento() {
		super();
	}

	public TipoDocumento(int idTipoDocumento, String nombre) {
		super();
		idtipodocumento = idTipoDocumento;
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoDocumento [IdTipoDocumento=" + idtipodocumento + ", Nombre=" + Nombre 
				+ "]";
	}

	public int getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
	
}
