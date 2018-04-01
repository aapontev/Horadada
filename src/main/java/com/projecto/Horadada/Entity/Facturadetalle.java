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
@Table(name="FACTURADETALLE")
public class Facturadetalle {

	@Id
	 @Column(name="IDDETALLEFACTURA", nullable=false, precision=10, scale=0)
	 private int idfacturadetalle;
     
     @ManyToOne(fetch=FetchType.EAGER)
     @JoinColumn(name="IDFACTURA", nullable=false, insertable=false, updatable=false)
     private Factura factura;
     
     @Column(name="CANTIDAD", precision=10, scale=0)
     private Long cantidad;
     
     @Column(name="DESCRIPCION", length=200)
     private String descripcion;
     
     @Column(name="PRECIOUNITARIO", precision=12)
     private BigDecimal preciounitario;
     
     @Column(name="VALORVENTA", precision=12)
     private BigDecimal valorventa;

    public Facturadetalle() {
    }

	
    public Facturadetalle(int idfacturadetalle, Factura factura) {
        this.idfacturadetalle = idfacturadetalle;
        this.factura = factura;
    }
    public Facturadetalle(int idfacturadetalle, Factura factura, Long cantidad, String descripcion, BigDecimal preciounitario, BigDecimal valorventa) {
       this.idfacturadetalle = idfacturadetalle;
       this.factura = factura;
       this.cantidad = cantidad;
       this.descripcion = descripcion;
       this.preciounitario = preciounitario;
       this.valorventa = valorventa;
    }

    public int getIdfacturadetalle() {
        return this.idfacturadetalle;
    }
    
    public void setIdfacturadetalle(int idfacturadetalle) {
        this.idfacturadetalle = idfacturadetalle;
    }

    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Long getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPreciounitario() {
        return this.preciounitario;
    }
    
    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }

    public BigDecimal getValorventa() {
        return this.valorventa;
    }
    
    public void setValorventa(BigDecimal valorventa) {
        this.valorventa = valorventa;
    }
}


