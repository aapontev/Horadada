package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FACTURADETALLE", schema = "HORADADA")
public class Facturadetalle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_detalle_seq")
	@SequenceGenerator(name = "factura_detalle_seq", sequenceName = "factura_detalle_sequence", allocationSize = 1)
	@Column(name = "IDFACTURADETALLE", unique = true, nullable = false, precision = 3)
	private int idfacturadetalle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDFACTURA", nullable = false, insertable = false, updatable = false)
	private Factura factura;

	@Column(name = "CANTIDAD", precision = 3)
	private int cantidad;

	@Column(name = "DESCRIPCION", length = 160)
	private String descripcion;

	@Column(name = "PRECIOUNITARIO", precision = 12, scale = 2)
	private BigDecimal preciounitario;

	@Column(name = "VALORVENTA", precision = 12, scale = 2)
	private BigDecimal valorventa;

	public Facturadetalle() {
	}

	public Facturadetalle(int idfacturadetalle, Factura factura) {
		this.idfacturadetalle = idfacturadetalle;
		this.factura = factura;
	}

	public Facturadetalle(int idfacturadetalle, Factura factura, int cantidad, String descripcion,
			BigDecimal preciounitario, BigDecimal valorventa) {
		this.idfacturadetalle = idfacturadetalle;
		this.factura = factura;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.preciounitario = preciounitario;
		this.valorventa = valorventa;
	}

	public int getIdfacturadetalle() {
		return this.idfacturadetalle;
	}

	public void setId(int idfacturadetalle) {
		this.idfacturadetalle = idfacturadetalle;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPreciounitario() {
		return this.preciounitario;
	}

	public void setPreciounitario(BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
	}

	public BigDecimal getValorventa() {
		return this.valorventa;
	}

	public void setValorventa(BigDecimal valorventa) {
		this.valorventa = valorventa;
	}

	private static final long serialVersionUID = 1L;

}
