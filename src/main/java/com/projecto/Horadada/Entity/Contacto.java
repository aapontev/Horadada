package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CONTACTO", schema = "HORADADA")
public class Contacto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacto_seq")
	@SequenceGenerator(name = "contacto_seq", sequenceName = "contacto_seq", allocationSize = 1)
	@Column(name = "IDCONTACTO", unique = true, nullable = false, precision = 3)
	private int idcontacto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENTE")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPERSONA")
	private Persona persona;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHACREACION", nullable = false)
	private Date fechacreacion;
	
	@PrePersist
	private void prepersist() {
		fechacreacion =  new Date();
	}

	public Contacto() {
	}

	public Contacto(int idcontacto, Date fechacreacion) {
		this.idcontacto = idcontacto;
		this.fechacreacion = fechacreacion;
	}

	public Contacto(int idcontacto, Cliente cliente, Persona persona, Date fechacreacion) {
		this.idcontacto = idcontacto;
		this.cliente = cliente;
		this.persona = persona;
		this.fechacreacion = fechacreacion;
	}

	public int getIdcontacto() {
		return this.idcontacto;
	}

	public void setIdcontacto(int idcontacto) {
		this.idcontacto = idcontacto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	private static final long serialVersionUID = 1L;

}
