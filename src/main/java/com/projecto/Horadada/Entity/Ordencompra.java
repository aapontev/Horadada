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
@Table(name="ORDENCOMPRA")
public class Ordencompra {
	   
    @Id    
    @Column(name="IDORDENCOMPRA", unique=true, nullable=false, precision=10, scale=0)
     private long idordencompra;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDCOTIZACION")
     private Cotizacion cotizacion;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHAENVIO", length=7)
     private Date fechaenvio;
    
    @Column(name="SUBTOTAL", precision=9)
     private BigDecimal subtotal;
    
    @Column(name="DESCUENTOS", precision=9)
     private BigDecimal descuentos;
    
    @Column(name="CARGOS", precision=9)
     private BigDecimal cargos;
    
    @Column(name="NETO", precision=9)
     private BigDecimal neto;
    
    @Column(name="IGV", precision=9)
     private BigDecimal igv;
    
    @Column(name="PERCEPCION", precision=9)
     private BigDecimal percepcion;
    
    @Column(name="TOTAL", precision=9)
     private BigDecimal total;
    
    @Column(name="OBSERVACIONES", length=250)
     private String observaciones;
    
    @Column(name="IDMONEDA", precision=10, scale=0)
     private Long idmoneda;
    
    @Column(name="ESTADOORDENCOMPRA", precision=5, scale=0)
     private Integer estadoordencompra;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="ordencompra")
     private Set<Ordencompradetalle> ordencompradetalles = new HashSet<Ordencompradetalle>(0);
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="ordencompra")
     private Set<Despacho> despachos = new HashSet<Despacho>(0);

    public Ordencompra() {
    }

	
    public Ordencompra(long idordencompra) {
        this.idordencompra = idordencompra;
    }
    public Ordencompra(long idordencompra, Cotizacion cotizacion, Date fechaenvio, BigDecimal subtotal, BigDecimal descuentos, BigDecimal cargos, BigDecimal neto, BigDecimal igv, BigDecimal percepcion, BigDecimal total, String observaciones, Long idmoneda, Integer estadoordencompra, Set<Ordencompradetalle> ordencompradetalles, Set<Despacho> despachos) {
       this.idordencompra = idordencompra;
       this.cotizacion = cotizacion;
       this.fechaenvio = fechaenvio;
       this.subtotal = subtotal;
       this.descuentos = descuentos;
       this.cargos = cargos;
       this.neto = neto;
       this.igv = igv;
       this.percepcion = percepcion;
       this.total = total;
       this.observaciones = observaciones;
       this.idmoneda = idmoneda;
       this.estadoordencompra = estadoordencompra;
       this.ordencompradetalles = ordencompradetalles;
       this.despachos = despachos;
    }

    public long getIdordencompra() {
        return this.idordencompra;
    }
    
    public void setIdordencompra(long idordencompra) {
        this.idordencompra = idordencompra;
    }

    public Cotizacion getCotizacion() {
        return this.cotizacion;
    }
    
    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
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

    public BigDecimal getCargos() {
        return this.cargos;
    }
    
    public void setCargos(BigDecimal cargos) {
        this.cargos = cargos;
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

    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getIdmoneda() {
        return this.idmoneda;
    }
    
    public void setIdmoneda(Long idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Integer getEstadoordencompra() {
        return this.estadoordencompra;
    }
    
    public void setEstadoordencompra(Integer estadoordencompra) {
        this.estadoordencompra = estadoordencompra;
    }

    public Set<Ordencompradetalle> getOrdencompradetalles() {
        return this.ordencompradetalles;
    }
    
    public void setOrdencompradetalles(Set<Ordencompradetalle> ordencompradetalles) {
        this.ordencompradetalles = ordencompradetalles;
    }

    public Set<Despacho> getDespachos() {
        return this.despachos;
    }
    
    public void setDespachos(Set<Despacho> despachos) {
        this.despachos = despachos;
    }



}


