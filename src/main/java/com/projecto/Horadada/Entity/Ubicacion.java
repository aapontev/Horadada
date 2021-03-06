package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "UBICACION", schema = "HORADADA")
public class Ubicacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ubicacion_seq")
	@SequenceGenerator(name = "ubicacion_seq", sequenceName = "ubicacion_sequence", allocationSize = 1)
	@Column(name = "IDUBICACION", unique = true, nullable = false, precision = 3)
	private int idubicacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDVEHICULO", nullable = true)
	private Vehiculo vehiculo;

	@Column(name = "IDDESPACHO", nullable = true, precision = 3)
	private int iddespacho;

	@Column(name = "LONGITUD", nullable = false, length = 20)
	private String longitud;

	@Column(name = "LATITUD", nullable = false, length = 20)
	private String latitud;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA")
	private Date fecha;

	@Column(name = "HORA")
	private String hora;

	@Column(name = "DIRECCION", length = 45)
	private String direccion;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "ubicacion", cascade = CascadeType.ALL)
	private Ubicacionhist ubicacionhist;

	public Ubicacion() {
	}

	public Ubicacion(int idubicacion, Vehiculo vehiculo, int iddespacho, String longitud, String latitud) {
		this.idubicacion = idubicacion;
		this.vehiculo = vehiculo;
		this.iddespacho = iddespacho;
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public Ubicacion(int idubicacion, Vehiculo vehiculo, int iddespacho, String longitud, String latitud, Date fecha,
			String hora, String direccion, Ubicacionhist ubicacionhist) {
		this.idubicacion = idubicacion;
		this.vehiculo = vehiculo;
		this.iddespacho = iddespacho;
		this.longitud = longitud;
		this.latitud = latitud;
		this.fecha = fecha;
		this.hora = hora;
		this.direccion = direccion;
		this.ubicacionhist = ubicacionhist;
	}

	public int getIdubicacion() {
		return this.idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public int getIddespacho() {
		return this.iddespacho;
	}

	public void setIddespacho(int iddespacho) {
		this.iddespacho = iddespacho;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ubicacionhist getUbicacionhist() {
		return this.ubicacionhist;
	}

	public void setUbicacionhist(Ubicacionhist ubicacionhist) {
		this.ubicacionhist = ubicacionhist;
	}

	private static final long serialVersionUID = 1L;
}
