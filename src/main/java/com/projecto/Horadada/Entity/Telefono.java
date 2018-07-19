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
@Table(name = "TELEFONOMONITOREO", schema = "HORADADA")
public class Telefono implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefono_monitoreo_seq")
	@SequenceGenerator(name = "telefono_monitoreo_seq", sequenceName = "telefono_monitoreo_sequence", allocationSize = 1)
	@Column(name = "IDTELEFONO", unique = true, nullable = false, precision = 3)
	private int idtelefono;


	@Column(name = "IDTIPOTELEFONO", precision = 3)
	private int idtipotelefono;

	@Column(name = "IDOPERADOR", precision = 5, scale = 0)
	private Integer idoperador;

	@Column(name = "NUMEROTELEFONO", length = 18)
	private String numerotelefono;

	@Column(name = "IMEI", length = 20)
	private String imei;

	public Telefono() {
	}

	public Telefono(int idtelefono, Persona persona) {
		this.idtelefono = idtelefono;
	}

	public Telefono(int idtelefono, Persona persona, int idtipotelefono, Integer idoperador, String numerotelefono,
			String imei) {
		this.idtelefono = idtelefono;
		this.idtipotelefono = idtipotelefono;
		this.idoperador = idoperador;
		this.numerotelefono = numerotelefono;
		this.imei = imei;
	}

	public int getIdtelefono() {
		return this.idtelefono;
	}

	public void setId(int idtelefono) {
		this.idtelefono = idtelefono;
	}


	public int getIdtipotelefono() {
		return this.idtipotelefono;
	}

	public void setIdtipotelefono(int idtipotelefono) {
		this.idtipotelefono = idtipotelefono;
	}

	public Integer getIdoperador() {
		return this.idoperador;
	}

	public void setIdoperador(Integer idoperador) {
		this.idoperador = idoperador;
	}

	public String getNumerotelefono() {
		return this.numerotelefono;
	}

	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	private static final long serialVersionUID = 1L;
}
