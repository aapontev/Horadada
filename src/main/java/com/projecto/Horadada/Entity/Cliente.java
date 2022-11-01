package com.projecto.Horadada.Entity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idcliente;
	private String correo;
	private String direccionfiscal;
	private String razonsocial;
	private String ruc;
	private String telefono;
	private List<Factura> facturas;
	private List<Contacto> contactos;
	private List<Valorizacion> valorizacions;
	private List<Solicitud> solicituds;

	public Cliente() {
	}

	public Cliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public Cliente(int idcliente, String correo, String direccionfiscal, String razonsocial, String ruc,
			String telefono, List<Factura> facturas, List<Contacto> contactos, List<Valorizacion> valorizacions,
			List<Solicitud> solicituds) {
		this.idcliente = idcliente;
		this.correo = correo;
		this.direccionfiscal = direccionfiscal;
		this.razonsocial = razonsocial;
		this.ruc = ruc;
		this.telefono = telefono;
		this.facturas = facturas;
		this.contactos = contactos;
		this.valorizacions = valorizacions;
		this.solicituds = solicituds;
	}

	@Id

	@Column(name = "idcliente", unique = true, nullable = false)
	public int getidcliente() {
		return this.idcliente;
	}

	public void setidcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	@Column(name = "correo", length = 60)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "direccionfiscal", length = 40)
	public String getdireccionfiscal() {
		return this.direccionfiscal;
	}

	public void setdireccionfiscal(String direccionfiscal) {
		this.direccionfiscal = direccionfiscal;
	}

	@Column(name = "razonsocial", length = 40)
	public String getrazonsocial() {
		return this.razonsocial;
	}

	public void setrazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	@Column(name = "ruc", length = 11)
	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	@Column(name = "telefono", length = 40)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public List<Valorizacion> getValorizacions() {
		return this.valorizacions;
	}

	public void setValorizacions(List<Valorizacion> valorizacions) {
		this.valorizacions = valorizacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public List<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(List<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

}
