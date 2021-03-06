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
@Table(name = "DESPACHOHIST", schema = "HORADADA")
public class Despachohist implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "despacho_hist_seq")
	@SequenceGenerator(name = "despacho_hist_seq", sequenceName = "despacho_hist_sequence", allocationSize = 1)
	@Column(name = "IDDESPACHOHIST", unique = true, nullable = false, precision = 3)
	private int iddespachohist;

	@Column(name = "IDDESPACHO", nullable = false, precision = 3)
	private int iddespacho;

	@Column(name = "IDORDENCOMPRA", nullable = false, precision = 3)
	private int idordencompra;

	@Column(name = "IDTRANSPORTISTA", nullable = false, precision = 3)
	private int idtransportista;

	@Column(name = "DESCRIPCIONMATERIA", length = 50)
	private String descripcionmateria;

	@Column(name = "DIRECCIONPARTIDA", length = 65)
	private String direccionpartida;

	@Column(name = "DIRECCIONLLEGADA", length = 65)
	private String direccionllegada;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHACARGA")
	private Date fechacarga;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHADESCARGA")
	private Date fechadescarga;

	@Column(name = "DIASSTANDBY", precision = 4)
	private int diasstandby;

	public Despachohist() {
	}

	public Despachohist(int iddespachohist, int iddespacho, int idordencompra, int idtransportista) {
		this.iddespachohist = iddespachohist;
		this.iddespacho = iddespacho;
		this.idordencompra = idordencompra;
		this.idtransportista = idtransportista;
	}

	public Despachohist(int iddespachohist, int iddespacho, int idordencompra, int idtransportista,
			String descripcionmateria, String direccionpartida, String direccionllegada, Date fechacarga,
			Date fechadescarga, int diasstandby) {
		this.iddespachohist = iddespachohist;
		this.iddespacho = iddespacho;
		this.idordencompra = idordencompra;
		this.idtransportista = idtransportista;
		this.descripcionmateria = descripcionmateria;
		this.direccionpartida = direccionpartida;
		this.direccionllegada = direccionllegada;
		this.fechacarga = fechacarga;
		this.fechadescarga = fechadescarga;
		this.diasstandby = diasstandby;
	}

	public int getIddespachohist() {
		return this.iddespachohist;
	}

	public void setIddespachohist(int iddespachohist) {
		this.iddespachohist = iddespachohist;
	}

	public int getIddespacho() {
		return this.iddespacho;
	}

	public void setIddespacho(int iddespacho) {
		this.iddespacho = iddespacho;
	}

	public int getIdordencompra() {
		return this.idordencompra;
	}

	public void setIdordencompra(int idordencompra) {
		this.idordencompra = idordencompra;
	}

	public int getIdtransportista() {
		return this.idtransportista;
	}

	public void setIdtransportista(int idtransportista) {
		this.idtransportista = idtransportista;
	}

	public String getDescripcionmateria() {
		return this.descripcionmateria;
	}

	public void setDescripcionmateria(String descripcionmateria) {
		this.descripcionmateria = descripcionmateria;
	}

	public String getDireccionpartida() {
		return this.direccionpartida;
	}

	public void setDireccionpartida(String direccionpartida) {
		this.direccionpartida = direccionpartida;
	}

	public String getDireccionllegada() {
		return this.direccionllegada;
	}

	public void setDireccionllegada(String direccionllegada) {
		this.direccionllegada = direccionllegada;
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

	public int getDiasstandby() {
		return this.diasstandby;
	}

	public void setDiasstandby(int diasstandby) {
		this.diasstandby = diasstandby;
	}

	private static final long serialVersionUID = 1L;

}
