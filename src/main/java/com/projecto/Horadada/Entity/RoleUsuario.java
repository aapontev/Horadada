package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ROLEUSUARIO", uniqueConstraints = @UniqueConstraint(columnNames = { "NOMBREROL",
		"NOMBREUSUARIO" }), schema = "HORADADA")
public class RoleUsuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(name = "role_seq", sequenceName = "role_sequence", allocationSize = 1)
	@Column(name = "IDROLEUSUARIO", unique = true, nullable = false, precision = 3)
	private Integer idroleusuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOMBREUSUARIO", nullable = false)
	private Usuario usuario;

	@Column(name = "NOMBREROL", length = 25)
	private String nombrerol;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHACREACION")
	private Date fechacreacion;

	@PrePersist
	private void prepersist() {
		fechacreacion = new Date();
	}
	public RoleUsuario() {
	}

	public RoleUsuario(Integer idroleusuario) {
		this.idroleusuario = idroleusuario;
	}

	public RoleUsuario(Integer idroleusuario, Usuario usuario, String nombrerol, Date fechacreacion) {
		this.idroleusuario = idroleusuario;
		this.usuario = usuario;
		this.nombrerol = nombrerol;
		this.fechacreacion = fechacreacion;
	}

	public Integer getIdroleusuario() {
		return this.idroleusuario;
	}

	public void setIdroleusuario(Integer idroleusuario) {
		this.idroleusuario = idroleusuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombrerol() {
		return this.nombrerol;
	}

	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	private static final long serialVersionUID = 1L;
}
