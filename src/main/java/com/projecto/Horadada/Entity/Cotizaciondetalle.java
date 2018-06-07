package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Cotizaciondetalle generated by hbm2java
 */
@Entity
@Table(name = "COTIZACIONDETALLE", schema = "HORADADA")
public class Cotizaciondetalle {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idcotizaciondetalle", column = @Column(name = "IDCOTIZACIONDETALLE", nullable = false, precision = 3)),
			@AttributeOverride(name = "idcotizacion", column = @Column(name = "IDCOTIZACION", nullable = false, precision = 3)) })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotizacion_detalle_seq")
	@SequenceGenerator(name = "cotizacion_detalle_seq", sequenceName = "cotizacion_detalle_sequence", allocationSize = 1)
	private CotizaciondetalleId id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDCOTIZACION", nullable = false, insertable = false, updatable = false)
	private Cotizacion cotizacion;

	@Column(name = "ITEM", precision = 2)
	private int item;

	@Column(name = "CODRECURSO", length = 3)
	private String codrecurso;

	@Column(name = "DESCRIPCION", length = 100)
	private String descripcion;

	@Column(name = "CCOSTOS", length = 30)
	private String ccostos;

	@Column(name = "IDUNIDADMEDIDA", precision = 2)
	private int idunidadmedida;

	@Column(name = "CANTIDAD", precision = 6, scale = 4)
	private BigDecimal cantidad;

	@Column(name = "PRECIOUNITARIO", precision = 12, scale = 2)
	private BigDecimal preciounitario;

	@Column(name = "DESCUENTO", precision = 12, scale = 2)
	private BigDecimal descuento;

	@Column(name = "TOTALDETALLE", precision = 12, scale = 2)
	private BigDecimal totaldetalle;

	public Cotizaciondetalle() {
	}

	public Cotizaciondetalle(CotizaciondetalleId id, Cotizacion cotizacion) {
		this.id = id;
		this.cotizacion = cotizacion;
	}

	public Cotizaciondetalle(CotizaciondetalleId id, Cotizacion cotizacion, int item, String codrecurso,
			String descripcion, String ccostos, int idunidadmedida, BigDecimal cantidad, BigDecimal preciounitario,
			BigDecimal descuento, BigDecimal totaldetalle) {
		this.id = id;
		this.cotizacion = cotizacion;
		this.item = item;
		this.codrecurso = codrecurso;
		this.descripcion = descripcion;
		this.ccostos = ccostos;
		this.idunidadmedida = idunidadmedida;
		this.cantidad = cantidad;
		this.preciounitario = preciounitario;
		this.descuento = descuento;
		this.totaldetalle = totaldetalle;
	}

	public CotizaciondetalleId getId() {
		return this.id;
	}

	public void setId(CotizaciondetalleId id) {
		this.id = id;
	}

	public Cotizacion getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public int getItem() {
		return this.item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getCodrecurso() {
		return this.codrecurso;
	}

	public void setCodrecurso(String codrecurso) {
		this.codrecurso = codrecurso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCcostos() {
		return this.ccostos;
	}

	public void setCcostos(String ccostos) {
		this.ccostos = ccostos;
	}

	public int getIdunidadmedida() {
		return this.idunidadmedida;
	}

	public void setIdunidadmedida(int idunidadmedida) {
		this.idunidadmedida = idunidadmedida;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPreciounitario() {
		return this.preciounitario;
	}

	public void setPreciounitario(BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getTotaldetalle() {
		return this.totaldetalle;
	}

	public void setTotaldetalle(BigDecimal totaldetalle) {
		this.totaldetalle = totaldetalle;
	}
}
