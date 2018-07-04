package com.projecto.Horadada.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECCION", schema = "HORADADA")
public class Direccion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "direccion_seq")
	@SequenceGenerator(name = "direccion_seq", sequenceName = "direccion_sequence", allocationSize = 1)
	@Column(name = "IDDIRECCION", unique = true, nullable = false, precision = 3)
	private int iddireccion;

	@Column(name = "NOMBREDIRECCION", nullable = false, length = 20)
	private String nombredireccion;

	@Column(name = "LONGITUD", nullable = false, length = 20)
	private String longitud;

	@Column(name = "LATITUD", nullable = false, length = 20)
	private String latitud;

	@Column(name = "CALLE", length = 45)
	private String calle;

	public Direccion() {
	}

	public Direccion(int iddireccion, String longitud, String latitud, String calle, String nombredireccion) {
		this.iddireccion = iddireccion;
		this.longitud = longitud;
		this.latitud = latitud;
		this.calle = calle;
		this.nombredireccion = nombredireccion;
	}

	public int getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}

	public String getNombredireccion() {
		return nombredireccion;
	}

	public void setNombredireccion(String nombredireccion) {
		this.nombredireccion = nombredireccion;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	private static final long serialVersionUID = 1L;
}
