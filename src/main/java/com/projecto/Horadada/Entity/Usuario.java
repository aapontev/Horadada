package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "USUARIO", schema = "HORADADA")
public class Usuario implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPERSONA", nullable = false)
	private Persona persona;

	@Id
	@Column(name = "NOMBREUSUARIO", unique = true, nullable = false, length = 45)
	private String nombreUsuario;

	@Column(name = "CONTRASENA", length = 60)
	private String contrasena;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAUPDATE")
	private Date fechaupdate;

	@Column(name = "ESTADO", precision = 2)
	private Boolean estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<RoleUsuario> roleUsuario;

	public Usuario() {
	}

	public Usuario(Persona persona) {
		this.persona = persona;
	}

	public Usuario(List<RoleUsuario> roleUsuario, Persona persona, String nombreUsuario, String contrasena,
			Date fechaupdate, Boolean estado) {

		this.persona = persona;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.fechaupdate = fechaupdate;
		this.estado = estado;
		this.roleUsuario = roleUsuario;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaupdate() {
		return this.fechaupdate;
	}

	public void setFechaupdate(Date fechaupdate) {
		this.fechaupdate = fechaupdate;
	}

	public Boolean isEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<RoleUsuario> getRoleUsuario() {
		return roleUsuario;
	}

	public void setRoleUsuario(List<RoleUsuario> roleUsuario) {
		this.roleUsuario = roleUsuario;
	}

	private static final long serialVersionUID = 1L;
}
