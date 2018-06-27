package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DESPACHO", schema = "HORADADA")
public class Despacho implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "despacho_seq")
	@SequenceGenerator(name = "despacho_seq", sequenceName = "despacho_sequence", allocationSize = 1)
	@Column(name = "IDDESPACHO", unique = true, nullable = false, precision = 3)
	private int iddespacho;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENTE")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDORDENCOMPRA", nullable = false)
	private Ordencompra ordencompra;

	@Column(name = "IDESTADODESPACHO", precision = 3)
	private int idestadodespacho;

	@Column(name = "DESCRIPCIONMATERIA", length = 150)
	private String descripcionmateria;

	@Column(name = "DIRECCIONPARTIDA", length = 65)
	private String direccionpartida;

	@Column(name = "DIRECCIONLLEGADA", length = 65)
	private String direccionllegada;

	@Column(name = "DIASESTIMADOS", precision = 4)
	private int diasestimados;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAINICIO")
	private Date fechainicio;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAFIN")
	private Date fechafin;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "despacho", cascade = CascadeType.ALL)
	private List<Valorizaciondetalle> valorizaciondetalles;

	public Despacho() {
	}

	public Despacho(int iddespacho, Ordencompra ordencompra) {
		this.iddespacho = iddespacho;
		this.ordencompra = ordencompra;
	}

	public Despacho(int iddespacho, Cliente cliente, Ordencompra ordencompra, int idestadodespacho,
			String descripcionmateria, String direccionpartida, String direccionllegada, int diasestimados,
			Date fechainicio, Date fechafin) {
		this.iddespacho = iddespacho;
		this.cliente = cliente;
		this.ordencompra = ordencompra;
		this.idestadodespacho = idestadodespacho;
		this.descripcionmateria = descripcionmateria;
		this.direccionpartida = direccionpartida;
		this.direccionllegada = direccionllegada;
		this.diasestimados = diasestimados;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
	}

	public int getIddespacho() {
		return this.iddespacho;
	}

	public void setIddespacho(int iddespacho) {
		this.iddespacho = iddespacho;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Ordencompra getOrdencompra() {
		return this.ordencompra;
	}

	public void setOrdencompra(Ordencompra ordencompra) {
		this.ordencompra = ordencompra;
	}

	public int getIdestadodespacho() {
		return this.idestadodespacho;
	}

	public void setIdestadodespacho(int idestadodespacho) {
		this.idestadodespacho = idestadodespacho;
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

	public int getDiasestimados() {
		return this.diasestimados;
	}

	public void setDiasestimados(int diasestimados) {
		this.diasestimados = diasestimados;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	private static final long serialVersionUID = 1L;

}
