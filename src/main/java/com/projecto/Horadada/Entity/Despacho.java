package com.projecto.Horadada.Entity;
// Generated 28/01/2020 04:40:27 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Despacho generated by hbm2java
 */
@Entity
@Table(name = "despacho", schema = "dbo", catalog = "HORADADA")
public class Despacho implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private int idDespacho;
	private OrdenCompra ordenCompra;
	private String descripcionMateria;
	private Integer diasEstimados;
	private Date fechaFin;
	private Date fechaInicio;
	private Integer idDireccionLlegada;
	private Integer idDireccionPartida;
	private Integer idEstadoDespacho;
	private List<DespachoXvehiculo> despachoXvehiculos;
	private List<ValorizacionDetalle> valorizacionDetalles;

	public Despacho() {
	}

	public Despacho(int idDespacho, OrdenCompra ordenCompra) {
		this.idDespacho = idDespacho;
		this.ordenCompra = ordenCompra;
	}

	public Despacho(int idDespacho, OrdenCompra ordenCompra, String descripcionMateria, Integer diasEstimados,
			Date fechaFin, Date fechaInicio, Integer idDireccionLlegada, Integer idDireccionPartida,
			Integer idEstadoDespacho, List<DespachoXvehiculo> despachoXvehiculos, List<ValorizacionDetalle> valorizacionDetalles) {
		this.idDespacho = idDespacho;
		this.ordenCompra = ordenCompra;
		this.descripcionMateria = descripcionMateria;
		this.diasEstimados = diasEstimados;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.idDireccionLlegada = idDireccionLlegada;
		this.idDireccionPartida = idDireccionPartida;
		this.idEstadoDespacho = idEstadoDespacho;
		this.despachoXvehiculos = despachoXvehiculos;
		this.valorizacionDetalles = valorizacionDetalles;
	}

	@Id

	@Column(name = "idDespacho", unique = true, nullable = false)
	public int getIdDespacho() {
		return this.idDespacho;
	}

	public void setIdDespacho(int idDespacho) {
		this.idDespacho = idDespacho;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idOrdenCompra", nullable = false)
	public OrdenCompra getOrdenCompra() {
		return this.ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	@Column(name = "descripcionMateria", length = 150)
	public String getDescripcionMateria() {
		return this.descripcionMateria;
	}

	public void setDescripcionMateria(String descripcionMateria) {
		this.descripcionMateria = descripcionMateria;
	}

	@Column(name = "diasEstimados")
	public Integer getDiasEstimados() {
		return this.diasEstimados;
	}

	public void setDiasEstimados(Integer diasEstimados) {
		this.diasEstimados = diasEstimados;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaFin", length = 10)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaInicio", length = 10)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Column(name = "idDireccionLlegada")
	public Integer getIdDireccionLlegada() {
		return this.idDireccionLlegada;
	}

	public void setIdDireccionLlegada(Integer idDireccionLlegada) {
		this.idDireccionLlegada = idDireccionLlegada;
	}

	@Column(name = "idDireccionPartida")
	public Integer getIdDireccionPartida() {
		return this.idDireccionPartida;
	}

	public void setIdDireccionPartida(Integer idDireccionPartida) {
		this.idDireccionPartida = idDireccionPartida;
	}

	@Column(name = "idEstadoDespacho")
	public Integer getIdEstadoDespacho() {
		return this.idEstadoDespacho;
	}

	public void setIdEstadoDespacho(Integer idEstadoDespacho) {
		this.idEstadoDespacho = idEstadoDespacho;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "despacho")
	public List<DespachoXvehiculo> getDespachoXvehiculos() {
		return this.despachoXvehiculos;
	}

	public void setDespachoXvehiculos(List<DespachoXvehiculo> despachoXvehiculos) {
		this.despachoXvehiculos = despachoXvehiculos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "despacho")
	public List<ValorizacionDetalle> getValorizacionDetalles() {
		return this.valorizacionDetalles;
	}

	public void setValorizacionDetalles(List<ValorizacionDetalle> valorizacionDetalles) {
		this.valorizacionDetalles = valorizacionDetalles;
	}

}
