package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "UBICACIONHIST", schema = "HORADADA")
public class Ubicacionhist implements Serializable {

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "ubicacion"))
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ubicacion_hist_seq")
	@SequenceGenerator(name = "ubicacion_hist_seq", sequenceName = "ubicacion_hist_sequence", allocationSize = 1)
	@Column(name = "IDUBICACIONHIST", unique = true, nullable = false, precision = 3)
	private int idubicacionhist;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Ubicacion ubicacion;

	@Column(name = "IDUBICACION", precision = 3)
	private int idubicacion;

	@Column(name = "IDVEHICULO", precision = 3)
	private int idvehiculo;

	@Column(name = "LONGITUD", length = 20)
	private String longitud;

	@Column(name = "LATITUD", length = 20)
	private String latitud;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA")
	private Date fecha;

	@Column(name = "HORA")
	private String hora;

	@Column(name = "DIRECCION", length = 45)
	private String direccion;

	@Column(name = "DEPARTAMENTO", length = 15)
	private String departamento;

	@Column(name = "PROVINCIA", length = 15)
	private String provincia;

	public Ubicacionhist() {
	}

	public Ubicacionhist(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Ubicacionhist(Ubicacion ubicacion, int idubicacion, int idvehiculo, String longitud, String latitud,
			Date fecha, String hora, String direccion, String departamento, String provincia) {
		this.ubicacion = ubicacion;
		this.idubicacion = idubicacion;
		this.idvehiculo = idvehiculo;
		this.longitud = longitud;
		this.latitud = latitud;
		this.fecha = fecha;
		this.hora = hora;
		this.direccion = direccion;
		this.departamento = departamento;
		this.provincia = provincia;
	}

	public int getIdubicacionhist() {
		return this.idubicacionhist;
	}

	public void setIdubicacionhist(int idubicacionhist) {
		this.idubicacionhist = idubicacionhist;
	}

	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getIdubicacion() {
		return this.idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}

	public int getIdvehiculo() {
		return this.idvehiculo;
	}

	public void setIdvehiculo(int idvehiculo) {
		this.idvehiculo = idvehiculo;
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

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	private static final long serialVersionUID = 1L;

}
