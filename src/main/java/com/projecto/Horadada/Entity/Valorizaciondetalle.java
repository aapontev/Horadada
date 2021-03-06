package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "VALORIZACIONDETALLE", schema = "HORADADA")
public class Valorizaciondetalle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valorizacion_detalle_seq")
	@SequenceGenerator(name = "valorizacion_detalle_seq", sequenceName = "valorizacion_detalle_sequence", allocationSize = 1)
	@Column(name = "IDVALORIZACIONDETALLE", unique = true, nullable = false, precision = 3)
	private int idvalorizaciondetalle;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDVALORIZACION", nullable = false, insertable = false, updatable = false)
	private Valorizacion valorizacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDFACTURA")
	private Factura factura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDDESPACHO")
	private Despacho despacho;

	@Column(name = "ITEM", precision = 2)
	private int item;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHACARGA")
	private Date fechacarga;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHADESCARGA")
	private Date fechadescarga;

	@Column(name = "NROGUIATRANSPORTE", length = 20)
	private String nroguiatransporte;

	@Column(name = "GUIAANEXADA", length = 20)
	private String guiaanexada;

	@Column(name = "DIASSTAMBY", precision = 2)
	private Byte diasstamby;

	@Column(name = "COSTOSTAMBY", precision = 12, scale = 2)
	private BigDecimal costostamby;

	@Column(name = "NETO", precision = 12, scale = 2)
	private BigDecimal neto;

	@Column(name = "SUBTOTAL", precision = 12, scale = 2)
	private BigDecimal subtotal;

	@Column(name = "IGV", precision = 12, scale = 2)
	private BigDecimal igv;

	@Column(name = "TOTAL", precision = 12, scale = 2)
	private BigDecimal total;

	public Valorizaciondetalle() {
	}

	public Valorizaciondetalle(int idvalorizaciondetalle, Valorizacion valorizacion) {
		this.idvalorizaciondetalle = idvalorizaciondetalle;
		this.valorizacion = valorizacion;
	}

	public Valorizaciondetalle(int idvalorizaciondetalle, Valorizacion valorizacion, Factura factura, Despacho despacho,
			int item, Date fechacarga, Date fechadescarga, String nroguiatransporte, String guiaanexada,
			Byte diasstamby, BigDecimal costostamby, BigDecimal neto, BigDecimal subtotal, BigDecimal igv,
			BigDecimal total) {
		this.idvalorizaciondetalle = idvalorizaciondetalle;
		this.valorizacion = valorizacion;
		this.factura = factura;
		this.despacho = despacho;
		this.item = item;
		this.fechacarga = fechacarga;
		this.fechadescarga = fechadescarga;
		this.nroguiatransporte = nroguiatransporte;
		this.guiaanexada = guiaanexada;
		this.diasstamby = diasstamby;
		this.costostamby = costostamby;
		this.neto = neto;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
	}

	public int getIdvalorizaciondetalle() {
		return this.idvalorizaciondetalle;
	}

	public void setId(int idvalorizaciondetalle) {
		this.idvalorizaciondetalle = idvalorizaciondetalle;
	}

	public Valorizacion getValorizacion() {
		return this.valorizacion;
	}

	public void setValorizacion(Valorizacion valorizacion) {
		this.valorizacion = valorizacion;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Despacho getDespacho() {
		return this.despacho;
	}

	public void setDespacho(Despacho despacho) {
		this.despacho = despacho;
	}

	public int getItem() {
		return this.item;
	}

	public void setItem(int item) {
		this.item = item;
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

	public String getNroguiatransporte() {
		return this.nroguiatransporte;
	}

	public void setNroguiatransporte(String nroguiatransporte) {
		this.nroguiatransporte = nroguiatransporte;
	}

	public String getGuiaanexada() {
		return this.guiaanexada;
	}

	public void setGuiaanexada(String guiaanexada) {
		this.guiaanexada = guiaanexada;
	}

	public Byte getDiasstamby() {
		return this.diasstamby;
	}

	public void setDiasstamby(Byte diasstamby) {
		this.diasstamby = diasstamby;
	}

	public BigDecimal getCostostamby() {
		return this.costostamby;
	}

	public void setCostostamby(BigDecimal costostamby) {
		this.costostamby = costostamby;
	}

	public BigDecimal getNeto() {
		return this.neto;
	}

	public void setNeto(BigDecimal neto) {
		this.neto = neto;
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

	private static final long serialVersionUID = 1L;
}
