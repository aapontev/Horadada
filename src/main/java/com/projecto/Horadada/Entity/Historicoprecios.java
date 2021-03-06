package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORICOPRECIOS", schema = "HORADADA")
public class Historicoprecios implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_precios_seq")
	@SequenceGenerator(name = "historico_precios_seq", sequenceName = "historico_precios_sequence", allocationSize = 1)
	@Column(name = "IDHISTORICOPRECIOS", unique = true, nullable = false, precision = 3)
	private int idhistoricoprecios;

	@Column(name = "ORIGEN", length = 50)
	private String origen;

	@Column(name = "DESTINO", length = 50)
	private String destino;

	@Column(name = "PESOTONELADAS", precision = 4, scale = 2)
	private int pesotoneladas;

	@Column(name = "LONGITUDMETROS", precision = 4, scale = 3)
	private int longitudmetros;

	@Column(name = "PRECIOSUBTOTAL", precision = 12, scale = 2)
	private BigDecimal preciosubtotal;

	@Column(name = "PRECIOIGV", precision = 12, scale = 2)
	private BigDecimal precioigv;

	@Column(name = "PRECIOTOTAL", precision = 12, scale = 2)
	private BigDecimal preciototal;

	public Historicoprecios() {
	}

	public Historicoprecios(int idhistoricoprecios) {
		this.idhistoricoprecios = idhistoricoprecios;
	}

	public Historicoprecios(int idhistoricoprecios, String origen, String destino, int pesotoneladas,
			int longitudmetros, BigDecimal preciosubtotal, BigDecimal precioigv, BigDecimal preciototal) {
		this.idhistoricoprecios = idhistoricoprecios;
		this.origen = origen;
		this.destino = destino;
		this.pesotoneladas = pesotoneladas;
		this.longitudmetros = longitudmetros;
		this.preciosubtotal = preciosubtotal;
		this.precioigv = precioigv;
		this.preciototal = preciototal;
	}

	public int getIdhistoricoprecios() {
		return this.idhistoricoprecios;
	}

	public void setIdhistoricoprecios(int idhistoricoprecios) {
		this.idhistoricoprecios = idhistoricoprecios;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getPesotoneladas() {
		return this.pesotoneladas;
	}

	public void setPesotoneladas(int pesotoneladas) {
		this.pesotoneladas = pesotoneladas;
	}

	public int getLongitudmetros() {
		return this.longitudmetros;
	}

	public void setLongitudmetros(int longitudmetros) {
		this.longitudmetros = longitudmetros;
	}

	public BigDecimal getPreciosubtotal() {
		return this.preciosubtotal;
	}

	public void setPreciosubtotal(BigDecimal preciosubtotal) {
		this.preciosubtotal = preciosubtotal;
	}

	public BigDecimal getPrecioigv() {
		return this.precioigv;
	}

	public void setPrecioigv(BigDecimal precioigv) {
		this.precioigv = precioigv;
	}

	public BigDecimal getPreciototal() {
		return this.preciototal;
	}

	public void setPreciototal(BigDecimal preciototal) {
		this.preciototal = preciototal;
	}

	private static final long serialVersionUID = 1L;

}
