package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ORDENCOMPRA", schema = "HORADADA")
public class Ordencompra implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orden_compra_seq")
	@SequenceGenerator(name = "orden_compra_seq", sequenceName = "orden_compra_sequence", allocationSize = 1)
	@Column(name = "IDORDENCOMPRA", unique = true, nullable = false, precision = 10, scale = 0)
	private int idordencompra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCOTIZACION")
	private Cotizacion cotizacion;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAENVIO")
	private Date fechaenvio;

	@Column(name = "SUBTOTAL", precision = 12, scale = 2)
	private BigDecimal subtotal;

	@Column(name = "DESCUENTOS", precision = 12, scale = 2)
	private BigDecimal descuentos;

	@Column(name = "CARGOS", precision = 9)
	private BigDecimal cargos;

	@Column(name = "NETO", precision = 12, scale = 2)
	private BigDecimal neto;

	@Column(name = "IGV", precision = 12, scale = 2)
	private BigDecimal igv;

	@Column(name = "PERCEPCION", precision = 12, scale = 2)
	private BigDecimal percepcion;

	@Column(name = "TOTAL", precision = 12, scale = 2)
	private BigDecimal total;

	@Column(name = "OBSERVACIONES", length = 250)
	private String observaciones;

	@Column(name = "IDMONEDA", precision = 3)
	private int idmoneda;

	@Column(name = "ESTADOORDENCOMPRA", precision = 3)
	private Integer estadoordencompra;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordencompra", cascade = CascadeType.ALL)
	private List<Despacho> despachos;

	public Ordencompra() {
	}

	public Ordencompra(int idordencompra) {
		this.idordencompra = idordencompra;
	}

	public Ordencompra(int idordencompra, Cotizacion cotizacion, Date fechaenvio, BigDecimal subtotal,
			BigDecimal descuentos, BigDecimal cargos, BigDecimal neto, BigDecimal igv, BigDecimal percepcion,
			BigDecimal total, String observaciones, int idmoneda, Integer estadoordencompra, List<Despacho> despachos) {
		this.idordencompra = idordencompra;
		this.cotizacion = cotizacion;
		this.fechaenvio = fechaenvio;
		this.subtotal = subtotal;
		this.descuentos = descuentos;
		this.cargos = cargos;
		this.neto = neto;
		this.igv = igv;
		this.percepcion = percepcion;
		this.total = total;
		this.observaciones = observaciones;
		this.idmoneda = idmoneda;
		this.estadoordencompra = estadoordencompra;
		this.despachos = despachos;
	}

	public int getIdordencompra() {
		return this.idordencompra;
	}

	public void setIdordencompra(int idordencompra) {
		this.idordencompra = idordencompra;
	}

	public Cotizacion getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
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

	public BigDecimal getCargos() {
		return this.cargos;
	}

	public void setCargos(BigDecimal cargos) {
		this.cargos = cargos;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getIdmoneda() {
		return this.idmoneda;
	}

	public void setIdmoneda(int idmoneda) {
		this.idmoneda = idmoneda;
	}

	public Integer getEstadoordencompra() {
		return this.estadoordencompra;
	}

	public void setEstadoordencompra(Integer estadoordencompra) {
		this.estadoordencompra = estadoordencompra;
	}

	public List<Despacho> getDespachos() {
		return this.despachos;
	}

	public void setDespachos(List<Despacho> despachos) {
		this.despachos = despachos;
	}

	private static final long serialVersionUID = 1L;
}
