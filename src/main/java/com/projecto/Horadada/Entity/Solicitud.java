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
@Table(name = "SOLICITUD", schema = "HORADADA")
public class Solicitud implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitud_seq")
	@SequenceGenerator(name = "solicitud_seq", sequenceName = "solicitud_seq", allocationSize = 1)
	@Column(name = "IDSOLICITUD", unique = true, nullable = false, precision = 3)
	private int idsolicitud;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENTE", nullable = false)
	private Cliente cliente;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHARECEPCION")
	private Date fecharecepcion;

	@Column(name = "REQUERIMIENTO", length = 100)
	private String requerimiento;

	@Column(name = "ESTADO", length = 200)
	private int estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "solicitud", cascade = CascadeType.ALL)
	private List<Cotizacion> cotizacions;

	public Solicitud() {
	}

	public Solicitud(int idsolicitud, Cliente cliente) {
		this.idsolicitud = idsolicitud;
		this.cliente = cliente;
	}

	public Solicitud(int idsolicitud, Cliente cliente, Date fecharecepcion, String requerimiento, int estado,
			List<Cotizacion> cotizacions) {
		this.idsolicitud = idsolicitud;
		this.cliente = cliente;
		this.fecharecepcion = fecharecepcion;
		this.requerimiento = requerimiento;
		this.cotizacions = cotizacions;
		this.estado = estado;
	}

	public int getIdsolicitud() {
		return this.idsolicitud;
	}

	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecharecepcion() {
		return this.fecharecepcion;
	}

	public void setFecharecepcion(Date fecharecepcion) {
		this.fecharecepcion = fecharecepcion;
	}

	public String getRequerimiento() {
		return this.requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public List<Cotizacion> getCotizacions() {
		return this.cotizacions;
	}

	public void setCotizacions(List<Cotizacion> cotizacions) {
		this.cotizacions = cotizacions;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
