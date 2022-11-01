package com.projecto.Horadada.Entity;
// Generated 28/01/2020 04:40:27 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CotizacionHist generated by hbm2java
 */
@Entity
@Table(name="cotizacionHist"
    ,schema="dbo"
    ,catalog="HORADADA"
)
public class CotizacionHist  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCotizacionHist;
     private BigDecimal cargos;
     private BigDecimal descuentos;
     private Date fechaEnvio;
     private Integer idMoneda;
     private BigDecimal igv;
     private BigDecimal neto;
     private String observaciones;
     private BigDecimal percepcion;
     private Integer idSolicitud;
     private BigDecimal subTotal;
     private BigDecimal total;

    public CotizacionHist() {
    }

	
    public CotizacionHist(int idCotizacionHist) {
        this.idCotizacionHist = idCotizacionHist;
    }
    public CotizacionHist(int idCotizacionHist, BigDecimal cargos, BigDecimal descuentos, Date fechaEnvio, Integer idMoneda, BigDecimal igv, BigDecimal neto, String observaciones, BigDecimal percepcion, Integer idSolicitud, BigDecimal subTotal, BigDecimal total) {
       this.idCotizacionHist = idCotizacionHist;
       this.cargos = cargos;
       this.descuentos = descuentos;
       this.fechaEnvio = fechaEnvio;
       this.idMoneda = idMoneda;
       this.igv = igv;
       this.neto = neto;
       this.observaciones = observaciones;
       this.percepcion = percepcion;
       this.idSolicitud = idSolicitud;
       this.subTotal = subTotal;
       this.total = total;
    }
   
     @Id 

    
    @Column(name="idCotizacionHist", unique=true, nullable=false)
    public int getIdCotizacionHist() {
        return this.idCotizacionHist;
    }
    
    public void setIdCotizacionHist(int idCotizacionHist) {
        this.idCotizacionHist = idCotizacionHist;
    }

    
    @Column(name="cargos", precision=12)
    public BigDecimal getCargos() {
        return this.cargos;
    }
    
    public void setCargos(BigDecimal cargos) {
        this.cargos = cargos;
    }

    
    @Column(name="descuentos", precision=12)
    public BigDecimal getDescuentos() {
        return this.descuentos;
    }
    
    public void setDescuentos(BigDecimal descuentos) {
        this.descuentos = descuentos;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaEnvio", length=10)
    public Date getFechaEnvio() {
        return this.fechaEnvio;
    }
    
    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    
    @Column(name="idMoneda")
    public Integer getIdMoneda() {
        return this.idMoneda;
    }
    
    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    
    @Column(name="igv", precision=12)
    public BigDecimal getIgv() {
        return this.igv;
    }
    
    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    
    @Column(name="neto", precision=12)
    public BigDecimal getNeto() {
        return this.neto;
    }
    
    public void setNeto(BigDecimal neto) {
        this.neto = neto;
    }

    
    @Column(name="observaciones", length=250)
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
    @Column(name="percepcion", precision=12)
    public BigDecimal getPercepcion() {
        return this.percepcion;
    }
    
    public void setPercepcion(BigDecimal percepcion) {
        this.percepcion = percepcion;
    }

    
    @Column(name="idSolicitud")
    public Integer getIdSolicitud() {
        return this.idSolicitud;
    }
    
    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    
    @Column(name="subTotal", precision=12)
    public BigDecimal getSubTotal() {
        return this.subTotal;
    }
    
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    
    @Column(name="total", precision=12)
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }




}


