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
@Table(name = "COTIZACIONDETALLE", schema = "HORADADA")
public class Cotizaciondetalle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotizacion_detalle_seq")
	@SequenceGenerator(name = "cotizacion_detalle_seq", sequenceName = "cotizacion_detalle_sequence", allocationSize = 1)
	@Column(name = "IDCOTIZACIONDETALLE", unique = true, nullable = false, precision = 5)
	private int idcotizaciondetalle;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCOTIZACION", nullable = false, insertable = false, updatable = false)
	private Cotizacion cotizacion;*/

	@Column(name = "ITEM", precision = 2)
	private int item;

	@Column(name = "CODRECURSO", length = 15)
	private String codrecurso;

	@Column(name = "DESCRIPCION", length = 100)
	private String descripcion;

	@Column(name = "CCOSTOS", length = 30)
	private String ccostos;

	@Column(name = "IDUNIDADMEDIDA", precision = 2)
	private int idunidadmedida;

	@Column(name = "CANTIDAD", precision = 6, scale = 2)
	private Double cantidad;

	@Column(name = "PRECIOUNITARIO", precision = 12, scale = 2)
	private Double preciounitario;

	@Column(name = "DESCUENTO", precision = 12, scale = 2)
	private Double descuento;

	@Column(name = "TOTALDETALLE", precision = 12, scale = 2)
	private Double totaldetalle;

	public Cotizaciondetalle() {
	}

	public Cotizaciondetalle(int idcotizaciondetalle) {
		this.idcotizaciondetalle = idcotizaciondetalle;
		//this.cotizacion = cotizacion;
	}

	public Cotizaciondetalle(int idcotizaciondetalle, int item, String codrecurso,
			String descripcion, String ccostos, int idunidadmedida, Double cantidad, Double preciounitario,
			Double descuento, Double totaldetalle) {
		this.idcotizaciondetalle = idcotizaciondetalle;
		//this.cotizacion = cotizacion;
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

	public int getIdcotizaciondetalle() {
		return this.idcotizaciondetalle;
	}

	public void setId(int idcotizaciondetalle) {
		this.idcotizaciondetalle = idcotizaciondetalle;
	}

	/*public Cotizacion getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}*/

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

	public Double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPreciounitario() {
		return this.preciounitario;
	}

	public void setPreciounitario(Double preciounitario) {
		this.preciounitario = preciounitario;
	}

	public Double getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getTotaldetalle() {
		return this.totaldetalle;
	}

	public void setTotaldetalle(Double totaldetalle) {
		this.totaldetalle = totaldetalle;
	}

	private static final long serialVersionUID = 1L;
}
