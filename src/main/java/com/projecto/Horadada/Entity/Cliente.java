package com.projecto.Horadada.Entity;
// Generated 12-may-2018 11:30:17 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "CLIENTE", schema = "HORADADA")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_sequence", allocationSize = 1)

	@Column(name = "IDCLIENTE", unique = true, nullable = false, precision = 3)
	private int idcliente;

	@Column(name = "RUC", length = 11)
	private String ruc;

	@Column(name = "RAZONSOCIAL", length = 40)
	private String razonsocial;

	@Column(name = "DIRECCIONFISCAL", length = 40)
	private String direccionfiscal;

	@Column(name = "TELEFONO", length = 40)
	private String telefono;

	@Column(name = "CORREO", length = 60)
	private String correo;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	private Set<Despacho> despachos = new HashSet<Despacho>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	private Set<Factura> facturas = new HashSet<Factura>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	private Set<Contacto> contactos = new HashSet<Contacto>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	private Set<Valorizacion> valorizacions = new HashSet<Valorizacion>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	private Set<Solicitud> solicituds = new HashSet<Solicitud>(0);

	public Cliente() {
	}

	public Cliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public Cliente(int idcliente, String ruc, String razonsocial, Set<Despacho> despachos, Set<Factura> facturas,
			Set<Contacto> contactos, Set<Valorizacion> valorizacions, Set<Solicitud> solicituds, String direccionfiscal,
			String telefono, String correo) {
		this.idcliente = idcliente;
		this.ruc = ruc;
		this.razonsocial = razonsocial;
		this.despachos = despachos;
		this.facturas = facturas;
		this.contactos = contactos;
		this.valorizacions = valorizacions;
		this.solicituds = solicituds;
		this.direccionfiscal = direccionfiscal;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonsocial() {
		return this.razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public Set<Despacho> getDespachos() {
		return this.despachos;
	}

	public void setDespachos(Set<Despacho> despachos) {
		this.despachos = despachos;
	}

	public Set<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

	public Set<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(Set<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Set<Valorizacion> getValorizacions() {
		return this.valorizacions;
	}

	public void setValorizacions(Set<Valorizacion> valorizacions) {
		this.valorizacions = valorizacions;
	}

	public Set<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(Set<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

	public String getDireccionfiscal() {
		return direccionfiscal;
	}

	public void setDireccionfiscal(String direccionfiscal) {
		this.direccionfiscal = direccionfiscal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
