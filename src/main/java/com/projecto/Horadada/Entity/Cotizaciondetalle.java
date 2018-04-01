package com.projecto.Horadada.Entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COTIZACIONDETALLE")
public class Cotizaciondetalle {

	 @Id 
	 @Column(name="IDCOTIZACION", nullable=false, precision=10, scale=0)
     private int idCotizacionDetalle;
     
     @ManyToOne(fetch=FetchType.EAGER)
     @JoinColumn(name="IDCOTIZACION", nullable=false, insertable=false, updatable=false)
     private Cotizacion cotizacion;
     
     @Column(name="ITEM", precision=10, scale=0)
     private Long item;
     
     @Column(name="CODRECURSO", length=10)
     private String codrecurso;
     
     @Column(name="DESCRIPCION", length=150)
     private String descripcion;
     
     @Column(name="CCOSTOS", length=30)
     private String ccostos;
     
     @Column(name="IDUNIDADMEDIDA", precision=10, scale=0)
     private Long idunidadmedida;
     
     @Column(name="CANTIDAD", precision=6, scale=4)
     private BigDecimal cantidad;
     
     @Column(name="PRECIOUNITARIO", precision=9)
     private BigDecimal preciounitario;
     
     @Column(name="DESCUENTO", precision=9)
     private BigDecimal descuento;
     
     @Column(name="TOTALDETALLE", precision=9)
     private BigDecimal totaldetalle;

    public Cotizaciondetalle() {
    }

    public Cotizaciondetalle(int idCotizacionDetalle, Cotizacion cotizacion, Long item, String codrecurso, String descripcion, String ccostos, Long idunidadmedida, BigDecimal cantidad, BigDecimal preciounitario, BigDecimal descuento, BigDecimal totaldetalle) {
       this.idCotizacionDetalle = idCotizacionDetalle;
       this.cotizacion = cotizacion;
       this.item = item;
       this.codrecurso = codrecurso;
       this.descripcion = descripcion;
       this.ccostos = ccostos;
       this.idunidadmedida = idunidadmedida;
       this.cantidad = cantidad;
       this.preciounitario = preciounitario;
       this.descuento = descuento;
       this.totaldetalle = totaldetalle;
    }

    public int getIdCotizacionDetalle() {
        return this.idCotizacionDetalle;
    }
    
    public void setId(int idCotizacionDetalle) {
        this.idCotizacionDetalle = idCotizacionDetalle;
    }

    public Cotizacion getCotizacion() {
        return this.cotizacion;
    }
    
    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Long getItem() {
        return this.item;
    }
    
    public void setItem(Long item) {
        this.item = item;
    }

    public String getCodrecurso() {
        return this.codrecurso;
    }
    
    public void setCodrecurso(String codrecurso) {
        this.codrecurso = codrecurso;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCcostos() {
        return this.ccostos;
    }
    
    public void setCcostos(String ccostos) {
        this.ccostos = ccostos;
    }

    public Long getIdunidadmedida() {
        return this.idunidadmedida;
    }
    
    public void setIdunidadmedida(Long idunidadmedida) {
        this.idunidadmedida = idunidadmedida;
    }

    public BigDecimal getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPreciounitario() {
        return this.preciounitario;
    }
    
    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }

    public BigDecimal getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotaldetalle() {
        return this.totaldetalle;
    }
    
    public void setTotaldetalle(BigDecimal totaldetalle) {
        this.totaldetalle = totaldetalle;
    }
}


