package com.projecto.Horadada.Entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="COTIZACION")
public class Cotizacion {
	
	 @Id 	    
	 @Column(name="IDCOTIZACION", unique=true, nullable=false, precision=10, scale=0)
     private long idcotizacion;
	 
	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="IDSOLICITUD")
     private Solicitud solicitud;

    @Temporal(TemporalType.DATE)
    @Column(name="FECHAENVIO", length=7)
     private Date fechaenvio;
    
    @Column(name="SUBTOTAL", precision=9)
     private BigDecimal subtotal;
    
    @Column(name="DESCUENTOS", precision=9)
     private BigDecimal descuentos;
    
    @Column(name="NETO", precision=9)
     private BigDecimal neto;
    
    @Column(name="IGV", precision=9)
     private BigDecimal igv;
    
    @Column(name="PERCEPCION", precision=9)
     private BigDecimal percepcion;
    
    @Column(name="TOTAL", precision=9)
     private BigDecimal total;
    
    @Column(name="IDMONEDA", precision=10, scale=0)
     private Long idmoneda;
    
    @Column(name="OBSERVACIONES", length=250)
     private String observaciones;
    
    @Column(name="CARGOS", precision=9)
     private BigDecimal cargos;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="cotizacion")
     private Set<Cotizaciondetalle> cotizaciondetalles = new HashSet<Cotizaciondetalle>(0);
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="cotizacion")
     private Set<Ordencompra> ordencompras = new HashSet<Ordencompra>(0);

    public Cotizacion() {
    }

	
    public Cotizacion(long idcotizacion) {
        this.idcotizacion = idcotizacion;
    }
    public Cotizacion(long idcotizacion, Solicitud solicitud, Date fechaenvio, BigDecimal subtotal, BigDecimal descuentos, BigDecimal neto, BigDecimal igv, BigDecimal percepcion, BigDecimal total, Long idmoneda, String observaciones, BigDecimal cargos, Set<Cotizaciondetalle> cotizaciondetalles, Set<Ordencompra> ordencompras) {
       this.idcotizacion = idcotizacion;
       this.solicitud = solicitud;
       this.fechaenvio = fechaenvio;
       this.subtotal = subtotal;
       this.descuentos = descuentos;
       this.neto = neto;
       this.igv = igv;
       this.percepcion = percepcion;
       this.total = total;
       this.idmoneda = idmoneda;
       this.observaciones = observaciones;
       this.cargos = cargos;
       this.cotizaciondetalles = cotizaciondetalles;
       this.ordencompras = ordencompras;
    }
   
    public long getIdcotizacion() {
        return this.idcotizacion;
    }
    
    public void setIdcotizacion(long idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public Solicitud getSolicitud() {
        return this.solicitud;
    }
    
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Date getFechaenvio() {
        return this.fechaenvio;
    }
    
    public void setFechaenvio(Date fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDescuentos() {
        return this.descuentos;
    }
    
    public void setDescuentos(BigDecimal descuentos) {
        this.descuentos = descuentos;
    }

    public BigDecimal getNeto() {
        return this.neto;
    }
    
    public void setNeto(BigDecimal neto) {
        this.neto = neto;
    }

    public BigDecimal getIgv() {
        return this.igv;
    }
    
    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getPercepcion() {
        return this.percepcion;
    }
    
    public void setPercepcion(BigDecimal percepcion) {
        this.percepcion = percepcion;
    }

    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getIdmoneda() {
        return this.idmoneda;
    }
    
    public void setIdmoneda(Long idmoneda) {
        this.idmoneda = idmoneda;
    }

    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getCargos() {
        return this.cargos;
    }
    
    public void setCargos(BigDecimal cargos) {
        this.cargos = cargos;
    }

    public Set<Cotizaciondetalle> getCotizaciondetalles() {
        return this.cotizaciondetalles;
    }
    
    public void setCotizaciondetalles(Set<Cotizaciondetalle> cotizaciondetalles) {
        this.cotizaciondetalles = cotizaciondetalles;
    }

    public Set<Ordencompra> getOrdencompras() {
        return this.ordencompras;
    }
    
    public void setOrdencompras(Set<Ordencompra> ordencompras) {
        this.ordencompras = ordencompras;
    }
}


