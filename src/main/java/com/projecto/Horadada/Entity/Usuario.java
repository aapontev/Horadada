package com.projecto.Horadada.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	//@AttributeOverrides({
			//@AttributeOverride(name = "idusuario", column = @Column(name = "IDUSUARIO", nullable = false, precision = 10, scale = 0))//,
			//@AttributeOverride(name = "idpersona", column = @Column(name = "IDPERSONA", nullable = false, precision = 10, scale = 0)) })
	@Id
	@GeneratedValue	
	private int idUsuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDPERSONA", nullable = false)
	private Persona persona;

	@Column(name = "USERNAME", length = 45)
	private String username;

	@Column(name = "CONTRASENA", length = 60)
	private String contrasena;

	@Column(name = "FECHAUPDATE")
	private Date fechaupdate;

	@Column(name = "ESTADO", precision = 5, scale = 0)
	private boolean estado;
	
	@Column(name = "TIPOPERSONA")
	private String tipopersona;
	
	

	public Usuario() {
	}

	public Usuario(int idUsuario, Persona persona, String username, String contrasena, Date fechaupdate, boolean estado, String tipopersona) {
		super();
		this.idUsuario = idUsuario;
		this.persona = persona;
		this.username = username;
		this.contrasena = contrasena;
		this.fechaupdate = fechaupdate;
		this.estado = estado;
		this.tipopersona = tipopersona;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuarioname() {
		return username;
	}

	public void setUsuarioname(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaupdate() {
		return fechaupdate;
	}

	public void setFechaupdate(Date fechaupdate) {
		this.fechaupdate = fechaupdate;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
        this.persona = persona;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTipopersona() {
		return tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	
	
}
