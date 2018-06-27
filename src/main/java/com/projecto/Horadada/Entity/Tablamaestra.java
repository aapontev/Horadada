package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TABLAMAESTRA", schema = "HORADADA")
public class Tablamaestra implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maestra_seq")
	@SequenceGenerator(name = "maestra_seq", sequenceName = "maestra_sequence", allocationSize = 1)
	@Column(name = "IDREGISTRO", unique = true, nullable = false, precision = 3)
	private int idregistro;

	@Column(name = "IDTABLAMAESTRA", nullable = false, length = 7)
	private String idtablamaestra;

	@Column(name = "DESCRIPCION", length = 45)
	private String descripcion;

	@Column(name = "CLAVE1", length = 15)
	private String clave1;

	@Column(name = "CLAVE2", length = 15)
	private String clave2;

	@Column(name = "CLAVE3", length = 15)
	private String clave3;

	@Column(name = "VALOR1", length = 15)
	private String valor1;

	@Column(name = "VALOR2", length = 15)
	private String valor2;

	@Column(name = "VALOR3", length = 15)
	private String valor3;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHACREACION", length = 7)
	private Date fechacreacion;
	
	@PrePersist
	private void prepersist () {
		fechacreacion =  new Date();
	}

	public Tablamaestra() {
	}

	public Tablamaestra(int idregistro, String idtablamaestra) {
		this.idregistro = idregistro;
		this.idtablamaestra = idtablamaestra;
	}

	public Tablamaestra(int idregistro, String idtablamaestra, String descripcion, String clave1, String clave2,
			String clave3, String valor1, String valor2, String valor3, Date fechacreacion) {
		this.idregistro = idregistro;
		this.idtablamaestra = idtablamaestra;
		this.descripcion = descripcion;
		this.clave1 = clave1;
		this.clave2 = clave2;
		this.clave3 = clave3;
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.fechacreacion = fechacreacion;
	}

	public int getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}

	public String getIdtablamaestra() {
		return this.idtablamaestra;
	}

	public void setIdtablamaestra(String idtablamaestra) {
		this.idtablamaestra = idtablamaestra;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClave1() {
		return this.clave1;
	}

	public void setClave1(String clave1) {
		this.clave1 = clave1;
	}

	public String getClave2() {
		return this.clave2;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}

	public String getClave3() {
		return this.clave3;
	}

	public void setClave3(String clave3) {
		this.clave3 = clave3;
	}

	public String getValor1() {
		return this.valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return this.valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}

	public String getValor3() {
		return this.valor3;
	}

	public void setValor3(String valor3) {
		this.valor3 = valor3;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	private static final long serialVersionUID = 1L;

}
