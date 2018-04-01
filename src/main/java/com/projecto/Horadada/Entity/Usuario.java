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

	@Column(name = "USUARIO", length = 45)
	private String usuario;

	@Column(name = "CONTRASENA", length = 60)
	private String contrasena;

	@Column(name = "FECHAUPDATE")
	private Date fechaupdate;

	@Column(name = "ESTADO", precision = 5, scale = 0)
	private Integer estado;
	
	

	public Usuario() {
	}

	public Usuario(int idUsuario, Persona persona, String usuario, String contrasena, Date fechaupdate, Integer estado) {
		super();
		this.idUsuario = idUsuario;
		this.persona = persona;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.fechaupdate = fechaupdate;
		this.estado = estado;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
