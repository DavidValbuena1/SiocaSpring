package com.david.ProyectoSioca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_usuario")
	private int id_usuario;

	@Column
	private String Num_identificacion_usuario;

	@Column(name="Nombres_usuario")
	private String Nombres;

	@Column(name="Apellidos_usuario")
	private String Apellidos;

	@Column(name="Correo_usuario")
	private String Correo;

	@Column(name="Telefono_usuario")
	private String Telefono;

	@Column(name="Direccion_usuario")
	private String Direccion;

	@Column(name="fechanacimiento")
	@Temporal(TemporalType.DATE)
	private Date Fecha;

	@Column(name = "Contraseña_usuario")
	private String contraseña;

	@Column(name = "Confirmar_contraseña_usuario")
	private String confirmar;
	
	
	@ManyToOne
	@JoinColumn(name = "Idrol")
	private Rol Rol;

	@ManyToOne
	@JoinColumn(name = "Tipodocumento_idtipodocumento")
	private TipoDocumento TipoDocumento;

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", Num_Identificacion_usuario=" + Num_identificacion_usuario
				+ ", Nombres=" + Nombres + ", Apellidos=" + Apellidos + ", Correo=" + Correo + ", Telefono=" + Telefono
				+ ", Direccion=" + Direccion + ", Fecha=" + Fecha + ", contraseña=" + contraseña + ", confirmar="
				+ confirmar + ", Rol=" + Rol + ", TipoDocumento=" + TipoDocumento + "]";
	}

	public Usuario(int id_usuario, String num_Identificacion_usuario, String nombres, String apellidos, String correo,
			String telefono, String direccion, Date fecha, String contraseña, String confirmar,
			Rol rol, TipoDocumento tipoDocumento) {
		super();
		this.id_usuario = id_usuario;
		this.Num_identificacion_usuario = num_Identificacion_usuario;
		Nombres = nombres;
		Apellidos = apellidos;
		Correo = correo;
		Telefono = telefono;
		Direccion = direccion;
		Fecha = fecha;
		this.contraseña = contraseña;
		this.confirmar = confirmar;
		Rol = rol;
		TipoDocumento = tipoDocumento;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNum_Identificacion_usuario() {
		return Num_identificacion_usuario;
	}

	public void setNum_Identificacion_usuario(String num_Identificacion_usuario) {
		this.Num_identificacion_usuario = num_Identificacion_usuario;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(String confirmar) {
		this.confirmar = confirmar;
	}

	public Rol getRol() {
		return Rol;
	}

	public void setRol(Rol rol) {
		Rol = rol;
	}

	public TipoDocumento getTipoDocumento() {
		return TipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Rol, TipoDocumento, id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(Rol, other.Rol) && Objects.equals(TipoDocumento, other.TipoDocumento)
				&& id_usuario == other.id_usuario;
	}


}
