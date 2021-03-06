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
@Table(name = "VEHICULO", schema = "HORADADA")
public class Vehiculo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_seq")
	@SequenceGenerator(name = "vehiculo_seq", sequenceName = "vehiculo_sequence", allocationSize = 1)
	@Column(name = "IDVEHICULO", unique = true, nullable = false, precision = 3)
	private int idvehiculo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDTRANSPORTISTA", nullable = false)
	private Transportista transportista;

	@Column(name = "PLACA", length = 7)
	private String placa;

	@Column(name = "COLOR", length = 15)
	private String color;

	@Column(name = "IDMARCA", precision = 3)
	private int idmarca;

	@Column(name = "IDMODELO", precision = 10, scale = 0)
	private int idmodelo;

	@Column(name = "IDASEGURADORA", precision = 10, scale = 0)
	private int idaseguradora;

	@Column(name = "DETALLES", length = 45)
	private String detalles;

	@Column(name = "TARJETACIRCULACION", length = 15)
	private String tarjetacirculacion;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAULTIMAREVISION")
	private Date fechaultimarevision;

	@Column(name = "NROEJES", precision = 3)
	private int nroejes;

	@Column(name = "PESOMAXIMO", precision = 6, scale = 2)
	private BigDecimal pesomaximo;

	@Column(name = "PESOVEHICULO", precision = 6, scale = 2)
	private BigDecimal pesovehiculo;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculo", cascade = CascadeType.ALL)
	private List<Ubicacion> ubicacions;

	public Vehiculo() {
	}

	public Vehiculo(int idvehiculo, Transportista transportista) {
		this.idvehiculo = idvehiculo;
		this.transportista = transportista;
	}

	public Vehiculo(int idvehiculo, Transportista transportista, String placa, String color, int idmarca, int idmodelo,
			int idaseguradora, String detalles, String tarjetacirculacion, Date fechaultimarevision, int nroejes,
			BigDecimal pesomaximo, BigDecimal pesovehiculo, List<Ubicacion> ubicacions) {
		this.idvehiculo = idvehiculo;
		this.transportista = transportista;
		this.placa = placa;
		this.color = color;
		this.idmarca = idmarca;
		this.idmodelo = idmodelo;
		this.idaseguradora = idaseguradora;
		this.detalles = detalles;
		this.tarjetacirculacion = tarjetacirculacion;
		this.fechaultimarevision = fechaultimarevision;
		this.nroejes = nroejes;
		this.pesomaximo = pesomaximo;
		this.pesovehiculo = pesovehiculo;
		this.ubicacions = ubicacions;
	}

	public int getIdvehiculo() {
		return this.idvehiculo;
	}

	public void setIdvehiculo(int idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public Transportista getTransportista() {
		return this.transportista;
	}

	public void setTransportista(Transportista transportista) {
		this.transportista = transportista;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getIdmarca() {
		return this.idmarca;
	}

	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}

	public int getIdmodelo() {
		return this.idmodelo;
	}

	public void setIdmodelo(int idmodelo) {
		this.idmodelo = idmodelo;
	}

	public int getIdaseguradora() {
		return this.idaseguradora;
	}

	public void setIdaseguradora(int idaseguradora) {
		this.idaseguradora = idaseguradora;
	}

	public String getDetalles() {
		return this.detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getTarjetacirculacion() {
		return this.tarjetacirculacion;
	}

	public void setTarjetacirculacion(String tarjetacirculacion) {
		this.tarjetacirculacion = tarjetacirculacion;
	}

	public Date getFechaultimarevision() {
		return this.fechaultimarevision;
	}

	public void setFechaultimarevision(Date fechaultimarevision) {
		this.fechaultimarevision = fechaultimarevision;
	}

	public int getNroejes() {
		return this.nroejes;
	}

	public void setNroejes(int nroejes) {
		this.nroejes = nroejes;
	}

	public BigDecimal getPesomaximo() {
		return this.pesomaximo;
	}

	public void setPesomaximo(BigDecimal pesomaximo) {
		this.pesomaximo = pesomaximo;
	}

	public BigDecimal getPesovehiculo() {
		return this.pesovehiculo;
	}

	public void setPesovehiculo(BigDecimal pesovehiculo) {
		this.pesovehiculo = pesovehiculo;
	}

	public List<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(List<Ubicacion> ubicacions) {
		this.ubicacions = ubicacions;
	}

	private static final long serialVersionUID = 1L;
}
