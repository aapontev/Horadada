package com.projecto.Horadada.Entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FACTURA")
public class Factura {

	   
    @Id     
    @Column(name="IDFACTURA", unique=true, nullable=false, precision=10, scale=0)
     private long idfactura;
    
    @ManyToOne(fetch=FetchType.EAGER)
     private Cliente cliente;
    
    @Column(name="IDDESPACHO", precision=10, scale=0)
     private Long iddespacho;
    
    @Column(name="CORRELATIVO", precision=10, scale=0)
     private Long correlativo;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHAEMISION", length=7)
     private Date fechaemision;
    
    @Column(name="GUIAREMISION", length=20)
     private String guiaremision;
    
    @Column(name="COSTOSTANDBY", precision=18)
     private BigDecimal costostandby;
    
    @Column(name="SUBTOTAL", precision=12)
     private BigDecimal subtotal;
    
    @Column(name="IGV", precision=12, scale=0)
     private Long igv;
    
    @Column(name="TOTAL", precision=12, scale=0)
     private Long total;
    
    @Column(name="IDMONEDA", precision=10, scale=0)
     private Long idmoneda;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="factura")
     private Set<Facturadetalle> facturadetalles = new HashSet<Facturadetalle>(0);

    @OneToMany(fetch=FetchType.EAGER, mappedBy="factura")
     private Set<Valorizaciondetalle> valorizaciondetalles = new HashSet<Valorizaciondetalle>(0);

    public Factura() {
    }

	
    public Factura(long idfactura, Cliente cliente) {
        this.idfactura = idfactura;
        this.cliente = cliente;
    }
    public Factura(long idfactura, Cliente cliente, Long iddespacho, Long correlativo, Date fechaemision, String guiaremision, BigDecimal costostandby, BigDecimal subtotal, Long igv, Long total, Long idmoneda, Set<Facturadetalle> facturadetalles, Set<Valorizaciondetalle> valorizaciondetalles) {
       this.idfactura = idfactura;
       this.cliente = cliente;
       this.iddespacho = iddespacho;
       this.correlativo = correlativo;
       this.fechaemision = fechaemision;
       this.guiaremision = guiaremision;
       this.costostandby = costostandby;
       this.subtotal = subtotal;
       this.igv = igv;
       this.total = total;
       this.idmoneda = idmoneda;
       this.facturadetalles = facturadetalles;
       this.valorizaciondetalles = valorizaciondetalles;
    }

    public long getIdfactura() {
        return this.idfactura;
    }
    
    public void setIdfactura(long idfactura) {
        this.idfactura = idfactura;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getIddespacho() {
        return this.iddespacho;
    }
    
    public void setIddespacho(Long iddespacho) {
        this.iddespacho = iddespacho;
    }

    public Long getCorrelativo() {
        return this.correlativo;
    }
    
    public void setCorrelativo(Long correlativo) {
        this.correlativo = correlativo;
    }

    public Date getFechaemision() {
        return this.fechaemision;
    }
    
    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getGuiaremision() {
        return this.guiaremision;
    }
    
    public void setGuiaremision(String guiaremision) {
        this.guiaremision = guiaremision;
    }

    public BigDecimal getCostostandby() {
        return this.costostandby;
    }
    
    public void setCostostandby(BigDecimal costostandby) {
        this.costostandby = costostandby;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Long getIgv() {
        return this.igv;
    }
    
    public void setIgv(Long igv) {
        this.igv = igv;
    }

    public Long getTotal() {
        return this.total;
    }
    
    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getIdmoneda() {
        return this.idmoneda;
    }
    
    public void setIdmoneda(Long idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Set<Facturadetalle> getFacturadetalles() {
        return this.facturadetalles;
    }
    
    public void setFacturadetalles(Set<Facturadetalle> facturadetalles) {
        this.facturadetalles = facturadetalles;
    }

    public Set<Valorizaciondetalle> getValorizaciondetalles() {
        return this.valorizaciondetalles;
    }
    
    public void setValorizaciondetalles(Set<Valorizaciondetalle> valorizaciondetalles) {
        this.valorizaciondetalles = valorizaciondetalles;
    }
}


