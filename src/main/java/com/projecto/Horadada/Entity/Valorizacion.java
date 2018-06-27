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
@Table(name = "VALORIZACION", schema = "HORADADA")
public class Valorizacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valorizacion_seq")
	@SequenceGenerator(name = "valorizacion_seq", sequenceName = "valorizacion_sequence", allocationSize = 1)
	@Column(name = "IDVALORIZACION", unique = true, nullable = false, precision = 3)
	private int idvalorizacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENTE")
	private Cliente cliente;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA", length = 7)
	private Date fecha;

	@Column(name = "OBSERVACIONES", length = 150)
	private String observaciones;

	@Column(name = "SUBTOTAL", precision = 12, scale = 2)
	private BigDecimal subtotal;

	@Column(name = "IGV", precision = 12, scale = 2)
	private BigDecimal igv;

	@Column(name = "TOTAL", precision = 12, scale = 2)
	private BigDecimal total;

	@Column(name = "IDMONEDA", precision = 2)
	private Byte idmoneda;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "valorizacion", cascade = CascadeType.ALL)
	private List<Valorizaciondetalle> valorizaciondetalles;

	public Valorizacion() {
	}

	public Valorizacion(int idvalorizacion) {
		this.idvalorizacion = idvalorizacion;
	}

	public Valorizacion(int idvalorizacion, Cliente cliente, Date fecha, String observaciones, BigDecimal subtotal,
			BigDecimal igv, BigDecimal total, Byte idmoneda, List<Valorizaciondetalle> valorizaciondetalles) {
		this.idvalorizacion = idvalorizacion;
		this.cliente = cliente;
		this.fecha = fecha;
		this.observaciones = observaciones;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
		this.idmoneda = idmoneda;
		this.valorizaciondetalles = valorizaciondetalles;
	}

	public int getIdvalorizacion() {
		return this.idvalorizacion;
	}

	public void setIdvalorizacion(int idvalorizacion) {
		this.idvalorizacion = idvalorizacion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getIgv() {
		return this.igv;
	}

	public void setIgv(BigDecimal igv) {
		this.igv = igv;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Byte getIdmoneda() {
		return this.idmoneda;
	}

	public void setIdmoneda(Byte idmoneda) {
		this.idmoneda = idmoneda;
	}

	public List<Valorizaciondetalle> getValorizaciondetalles() {
		return this.valorizaciondetalles;
	}

	public void setValorizaciondetalles(List<Valorizaciondetalle> valorizaciondetalles) {
		this.valorizaciondetalles = valorizaciondetalles;
	}

	private static final long serialVersionUID = 1L;
}
