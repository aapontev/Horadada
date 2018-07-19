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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TRANSPORTISTA", schema = "HORADADA", uniqueConstraints = @UniqueConstraint(columnNames = "IDPERSONA"))
public class Transportista implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transportista_seq")
	@SequenceGenerator(name = "transportista_seq", sequenceName = "transportista_sequence", allocationSize = 1)
	@Column(name = "IDTRANSPORTISTA", unique = true, nullable = false, precision = 3)
	private int idtransportista;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPERSONA", unique = true, nullable = false)
	private Persona persona;

	@Column(name = "NROLICENCIA", nullable = false, length = 15)
	private String nrolicencia;

	@Column(name = "CATLICENCIA", length = 5)
	private String catlicencia;

	@Column(name = "IDSITUACIONTRANSPORTISTA", precision = 5, scale = 0)
	private int idsituaciontransportista;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportista", cascade = CascadeType.ALL)
	private List<Vehiculo> vehiculos;

	public Transportista() {
	}

	public Transportista(int idtransportista, Persona persona, String nrolicencia) {
		this.idtransportista = idtransportista;
		this.persona = persona;
		this.nrolicencia = nrolicencia;
	}

	public Transportista(int idtransportista, Persona persona, String nrolicencia, String catlicencia,
			int idsituaciontransportista, List<Vehiculo> vehiculos) {
		this.idtransportista = idtransportista;
		this.persona = persona;
		this.nrolicencia = nrolicencia;
		this.catlicencia = catlicencia;
		this.idsituaciontransportista = idsituaciontransportista;
		this.vehiculos = vehiculos;
	}

	public int getIdtransportista() {
		return this.idtransportista;
	}

	public void setIdtransportista(int idtransportista) {
		this.idtransportista = idtransportista;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getNrolicencia() {
		return this.nrolicencia;
	}

	public void setNrolicencia(String nrolicencia) {
		this.nrolicencia = nrolicencia;
	}

	public String getCatlicencia() {
		return this.catlicencia;
	}

	public void setCatlicencia(String catlicencia) {
		this.catlicencia = catlicencia;
	}

	public int getIdsituaciontransportista() {
		return this.idsituaciontransportista;
	}

	public void setIdsituaciontransportista(int idsituaciontransportista) {
		this.idsituaciontransportista = idsituaciontransportista;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	private static final long serialVersionUID = 1L;
}
