package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "COTIZACIONHIST", schema = "HORADADA")
public class CotizacionHist implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotizacion_hist_seq")
	@SequenceGenerator(name = "cotizacion_hist_seq", sequenceName = "cotizacion_hist_sequence", allocationSize = 1)
	@Column(name = "IDCOTIZACIONHIST", unique = true, nullable = false, precision = 3)
	private int idcotizacion;

	@Column(name = "IDSOLICITUD")
	private int solicitud;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAENVIO")
	private Date fechaenvio;

	@Column(name = "SUBTOTAL", precision = 12, scale = 2)
	private BigDecimal subtotal;

	@Column(name = "DESCUENTOS", precision = 12, scale = 2)
	private BigDecimal descuentos;

	@Column(name = "NETO", precision = 12, scale = 2)
	private BigDecimal neto;

	@Column(name = "IGV", precision = 12, scale = 2)
	private BigDecimal igv;

	@Column(name = "PERCEPCION", precision = 12, scale = 2)
	private BigDecimal percepcion;

	@Column(name = "TOTAL", precision = 12, scale = 2)
	private BigDecimal total;

	@Column(name = "IDMONEDA", precision = 2)
	private int idmoneda;

	@Column(name = "OBSERVACIONES", length = 250)
	private String observaciones;

	@Column(name = "CARGOS", precision = 12, scale = 2)
	private BigDecimal cargos;

	public CotizacionHist() {
	}

	public CotizacionHist(int idcotizacion) {
		this.idcotizacion = idcotizacion;
	}

	public CotizacionHist(int idcotizacion, int solicitud, Date fechaenvio, BigDecimal subtotal, BigDecimal descuentos,
			BigDecimal neto, BigDecimal igv, BigDecimal percepcion, BigDecimal total, int idmoneda,
			String observaciones, BigDecimal cargos) {
		this.idcotizacion = idcotizacion;
		this.solicitud = solicitud;
		this.fechaenvio = fechaenvio;
		this.subtotal = subtotal;
		this.descuentos = descuentos;
		this.neto = neto;
		this.igv = igv;
		this.percepcion = percepcion;
		this.total = total;
		this.idmoneda = idmoneda;
		this.observaciones = observaciones;
		this.cargos = cargos;
	}

	public int getIdcotizacion() {
		return this.idcotizacion;
	}

	public void setIdcotizacion(int idcotizacion) {
		this.idcotizacion = idcotizacion;
	}

	public int getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(int solicitud) {
		this.solicitud = solicitud;
	}

	public Date getFechaenvio() {
		return this.fechaenvio;
	}

	public void setFechaenvio(Date fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getDescuentos() {
		return this.descuentos;
	}

	public void setDescuentos(BigDecimal descuentos) {
		this.descuentos = descuentos;
	}

	public BigDecimal getNeto() {
		return this.neto;
	}

	public void setNeto(BigDecimal neto) {
		this.neto = neto;
	}

	public BigDecimal getIgv() {
		return this.igv;
	}

	public void setIgv(BigDecimal igv) {
		this.igv = igv;
	}

	public BigDecimal getPercepcion() {
		return this.percepcion;
	}

	public void setPercepcion(BigDecimal percepcion) {
		this.percepcion = percepcion;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public int getIdmoneda() {
		return this.idmoneda;
	}

	public void setIdmoneda(int idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getCargos() {
		return this.cargos;
	}

	public void setCargos(BigDecimal cargos) {
		this.cargos = cargos;
	}

	private static final long serialVersionUID = 1L;
}
