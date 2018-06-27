package com.projecto.Horadada.Entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "OBSERVACIONES", schema = "HORADADA")
public class Observaciones implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "observaciones_seq")
	@SequenceGenerator(name = "observaciones_seq", sequenceName = "observaciones_sequence", allocationSize = 1)
	@Column(name = "IDOBSERVACIONES", unique = true, nullable = false, precision = 3)
	private int idobservaciones;

	@Column(name = "IDDESPACHO", nullable = false, precision = 3)
	private int iddespacho;

	@Column(name = "OBSERVACIONDETALLE", length = 200)
	private String observaciondetalle;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAINGRESO")
	private Date fechaingreso;

	public Observaciones() {
	}

	public Observaciones(int idobservaciones, int iddespacho) {
		this.idobservaciones = idobservaciones;
		this.iddespacho = iddespacho;
	}

	public Observaciones(int idobservaciones, int iddespacho, String observaciondetalle, Date fechaingreso) {
		this.idobservaciones = idobservaciones;
		this.iddespacho = iddespacho;
		this.observaciondetalle = observaciondetalle;
		this.fechaingreso = fechaingreso;
	}

	public int getIdobservaciones() {
		return this.idobservaciones;
	}

	public void setIdobservaciones(int idobservaciones) {
		this.idobservaciones = idobservaciones;
	}

	public int getIddespacho() {
		return this.iddespacho;
	}

	public void setIddespacho(int iddespacho) {
		this.iddespacho = iddespacho;
	}

	public String getObservaciondetalle() {
		return this.observaciondetalle;
	}

	public void setObservaciondetalle(String observaciondetalle) {
		this.observaciondetalle = observaciondetalle;
	}

	public Date getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	private static final long serialVersionUID = 1L;
}
