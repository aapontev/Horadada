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
@Table(name = "DESPACHOXVEHICULO", schema = "HORADADA")
public class Despachoxvehiculo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "despacho_vehiculo_seq")
	@SequenceGenerator(name = "despacho_vehiculo_seq", sequenceName = "despacho_vehiculo_sequence", allocationSize = 1)
	@Column(name = "IDDESPACHOXVEHICULO", unique = true, nullable = false, precision = 3)
	private int iddespachoxvehiculo;

	@Column(name = "IDTRANSPORTISTA", nullable = false, precision = 3)
	private int idtransportista;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHACARGA")
	private Date fechacarga;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHADESCARGA")
	private Date fechadescarga;

	@Column(name = "HORACARGA")
	private String horacarga;

	@Column(name = "HORADESCARGA")
	private String horadescarga;

	public Despachoxvehiculo() {
	}

	public Despachoxvehiculo(int iddespachoxvehiculo, int idtransportista) {
		this.iddespachoxvehiculo = iddespachoxvehiculo;
		this.idtransportista = idtransportista;
	}

	public Despachoxvehiculo(int iddespachoxvehiculo, int idtransportista, Date fechacarga, Date fechadescarga,
			String horacarga, String horadescarga) {
		this.iddespachoxvehiculo = iddespachoxvehiculo;
		this.idtransportista = idtransportista;
		this.fechacarga = fechacarga;
		this.fechadescarga = fechadescarga;
		this.horacarga = horacarga;
		this.horadescarga = horadescarga;
	}

	public int getIddespachoxvehiculo() {
		return this.iddespachoxvehiculo;
	}

	public void setId(int iddespachoxvehiculo) {
		this.iddespachoxvehiculo = iddespachoxvehiculo;
	}

	public int getIdtransportista() {
		return this.idtransportista;
	}

	public void setIdtransportista(int idtransportista) {
		this.idtransportista = idtransportista;
	}

	public Date getFechacarga() {
		return this.fechacarga;
	}

	public void setFechacarga(Date fechacarga) {
		this.fechacarga = fechacarga;
	}

	public Date getFechadescarga() {
		return this.fechadescarga;
	}

	public void setFechadescarga(Date fechadescarga) {
		this.fechadescarga = fechadescarga;
	}

	public String getHoracarga() {
		return this.horacarga;
	}

	public void setHoracarga(String horacarga) {
		this.horacarga = horacarga;
	}

	public String getHoradescarga() {
		return this.horadescarga;
	}

	public void setHoradescarga(String horadescarga) {
		this.horadescarga = horadescarga;
	}

	private static final long serialVersionUID = 1L;

}
