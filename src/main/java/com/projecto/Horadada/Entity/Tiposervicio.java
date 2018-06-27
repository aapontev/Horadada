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
@Table(name = "TIPOSERVICIO", schema = "HORADADA")
public class Tiposervicio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_servicio_seq")
	@SequenceGenerator(name = "tipo_servicio_seq", sequenceName = "tipo_servicio_sequence", allocationSize = 1)
	@Column(name = "IDSERVICIO", unique = true, nullable = false, precision = 3)
	private int idservicio;

	@Column(name = "NOMBRESERVICIO", length = 50)
	private String nombreservicio;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAINGRESO")
	private Date fechaingreso;

	@PrePersist
	private void prepersist() {
		fechaingreso = new Date();
	}

	public Tiposervicio() {

	}

	public Tiposervicio(int idservicio) {
		this.idservicio = idservicio;
	}

	public Tiposervicio(int idservicio, String nombreservicio, Date fechaingreso) {
		this.idservicio = idservicio;
		this.nombreservicio = nombreservicio;
		this.fechaingreso = fechaingreso;
	}

	public int getIdservicio() {
		return this.idservicio;
	}

	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}

	public String getNombreservicio() {
		return this.nombreservicio;
	}

	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
	}

	public Date getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	private static final long serialVersionUID = 1L;

}
