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
	@JoinColumn(name = "IDORDENCOMPRA", nullable = false)
	private Ordencompra ordencompra;

	@Column(name = "IDESTADODESPACHO", precision = 3)
	private int idestadodespacho;

	@Column(name = "DESCRIPCIONMATERIA", length = 150)
	private String descripcionmateria;

	@Column(name = "IDDIRECCIONPARTIDA")
	private int iddireccionpartida;

	@Column(name = "IDDIRECCIONLLEGADA")
	private int iddireccionllegada;

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
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDDESPACHO")
	private List<Despachoxvehiculo> despachoxvehiculo;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "despacho", cascade = CascadeType.ALL)
	private List<Valorizaciondetalle> valorizaciondetalles;

	public Despacho() {
	}

	public Despacho(int iddespacho, Ordencompra ordencompra) {
		this.iddespacho = iddespacho;
		this.ordencompra = ordencompra;
	}

	public Despacho(int iddespacho,  Ordencompra ordencompra, int idestadodespacho,
			String descripcionmateria, int iddireccionpartida, int iddireccionllegada, int diasestimados,
			Date fechainicio, Date fechafin ,List<Despachoxvehiculo> despachoxvehiculo,List<Valorizaciondetalle> valorizaciondetalles) {
		this.iddespacho = iddespacho;
		this.ordencompra = ordencompra;
		this.idestadodespacho = idestadodespacho;
		this.descripcionmateria = descripcionmateria;
		this.iddireccionpartida = iddireccionpartida;
		this.iddireccionllegada = iddireccionllegada;
		this.diasestimados = diasestimados;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.despachoxvehiculo = despachoxvehiculo;
		this.valorizaciondetalles = valorizaciondetalles;
	}

	public int getIddespacho() {
		return this.iddespacho;
	}

	public void setIddespacho(int iddespacho) {
		this.iddespacho = iddespacho;
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

	public int getIddireccionpartida() {
		return iddireccionpartida;
	}

	public void setIddireccionpartida(int iddireccionpartida) {
		this.iddireccionpartida = iddireccionpartida;
	}

	public int getIddireccionllegada() {
		return iddireccionllegada;
	}

	public void setIddireccionllegada(int iddireccionllegada) {
		this.iddireccionllegada = iddireccionllegada;
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
	
	public List<Despachoxvehiculo> getDespachoxvehiculo() {
		return despachoxvehiculo;
	}

	public void setDespachoxvehiculo(List<Despachoxvehiculo> despachoxvehiculo) {
		this.despachoxvehiculo = despachoxvehiculo;
	}

	public List<Valorizaciondetalle> getValorizaciondetalles() {
		return valorizaciondetalles;
	}

	public void setValorizaciondetalles(List<Valorizaciondetalle> valorizaciondetalles) {
		this.valorizaciondetalles = valorizaciondetalles;
	}



	private static final long serialVersionUID = 1L;

}
