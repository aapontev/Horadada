package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE", schema = "HORADADA")
public class Cliente implements Serializable {

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Factura> facturas;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Contacto> contactos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Valorizacion> valorizacions;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Solicitud> solicituds;

	public Cliente() {
	}

	public Cliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public Cliente(int idcliente, String ruc, String razonsocial, List<Factura> facturas,
			List<Contacto> contactos, List<Valorizacion> valorizacions, List<Solicitud> solicituds,
			String direccionfiscal, String telefono, String correo) {
		this.idcliente = idcliente;
		this.ruc = ruc;
		this.razonsocial = razonsocial;
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

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public List<Valorizacion> getValorizacions() {
		return this.valorizacions;
	}

	public void setValorizacions(List<Valorizacion> valorizacions) {
		this.valorizacions = valorizacions;
	}

	public List<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(List<Solicitud> solicituds) {
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

	private static final long serialVersionUID = 1L;

}
