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
@Table(name = "FACTURA", schema = "HORADADA")
public class Factura implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_seq")
	@SequenceGenerator(name = "factura_seq", sequenceName = "factura_sequence", allocationSize = 1)
	@Column(name = "IDFACTURA", unique = true, nullable = false, precision = 3)
	private int idfactura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENTE", nullable = false)
	private Cliente cliente;

	@Column(name = "IDDESPACHO", precision = 3)
	private int iddespacho;

	@Column(name = "CORRELATIVO", precision = 3)
	private int correlativo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAEMISION")
	private Date fechaemision;

	@Column(name = "GUIAREMISION", length = 20)
	private String guiaremision;

	@Column(name = "COSTOSTANDBY", precision = 12, scale = 2)
	private BigDecimal costostandby;

	@Column(name = "SUBTOTAL", precision = 12, scale = 2)
	private BigDecimal subtotal;

	@Column(name = "IGV", precision = 12, scale = 2)
	private int igv;

	@Column(name = "TOTAL", precision = 12, scale = 2)
	private int total;

	@Column(name = "IDMONEDA", precision = 3)
	private int idmoneda;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "factura",cascade = CascadeType.ALL)
	private List<Facturadetalle> facturadetalles ;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "factura",cascade = CascadeType.ALL)
	private List<Valorizaciondetalle> valorizaciondetalles;

	public Factura() {
	}

	public Factura(int idfactura, Cliente cliente) {
		this.idfactura = idfactura;
		this.cliente = cliente;
	}

	public Factura(int idfactura, Cliente cliente, int iddespacho, int correlativo, Date fechaemision,
			String guiaremision, BigDecimal costostandby, BigDecimal subtotal, int igv, int total, int idmoneda,
			List<Facturadetalle> facturadetalles, List<Valorizaciondetalle> valorizaciondetalles) {
		this.idfactura = idfactura;
		this.cliente = cliente;
		this.iddespacho = iddespacho;
		this.correlativo = correlativo;
		this.fechaemision = fechaemision;
		this.guiaremision = guiaremision;
		this.costostandby = costostandby;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
		this.idmoneda = idmoneda;
		this.facturadetalles = facturadetalles;
		this.valorizaciondetalles = valorizaciondetalles;
	}

	public int getIdfactura() {
		return this.idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIddespacho() {
		return this.iddespacho;
	}

	public void setIddespacho(int iddespacho) {
		this.iddespacho = iddespacho;
	}

	public int getCorrelativo() {
		return this.correlativo;
	}

	public void setCorrelativo(int correlativo) {
		this.correlativo = correlativo;
	}

	public Date getFechaemision() {
		return this.fechaemision;
	}

	public void setFechaemision(Date fechaemision) {
		this.fechaemision = fechaemision;
	}

	public String getGuiaremision() {
		return this.guiaremision;
	}

	public void setGuiaremision(String guiaremision) {
		this.guiaremision = guiaremision;
	}

	public BigDecimal getCostostandby() {
		return this.costostandby;
	}

	public void setCostostandby(BigDecimal costostandby) {
		this.costostandby = costostandby;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public int getIgv() {
		return this.igv;
	}

	public void setIgv(int igv) {
		this.igv = igv;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getIdmoneda() {
		return this.idmoneda;
	}

	public void setIdmoneda(int idmoneda) {
		this.idmoneda = idmoneda;
	}

	public List<Facturadetalle> getFacturadetalles() {
		return this.facturadetalles;
	}

	public void setFacturadetalles(List<Facturadetalle> facturadetalles) {
		this.facturadetalles = facturadetalles;
	}

	public List<Valorizaciondetalle> getValorizaciondetalles() {
		return this.valorizaciondetalles;
	}

	public void setValorizaciondetalles(List<Valorizaciondetalle> valorizaciondetalles) {
		this.valorizaciondetalles = valorizaciondetalles;
	}

	private static final long serialVersionUID = 1L;
}
