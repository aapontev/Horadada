package com.projecto.Horadada.Entity;
// Generated 28/01/2020 04:40:27 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FacturaDetalle generated by hbm2java
 */
@Entity
@Table(name="facturaDetalle"
    ,schema="dbo"
    ,catalog="HORADADA"
)
public class FacturaDetalle  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idFacturaDetalle;
     private Factura factura;
     private Integer cantidad;
     private String descripcion;
     private BigDecimal precioUnitario;
     private BigDecimal valorVenta;

    public FacturaDetalle() {
    }

	
    public FacturaDetalle(int idFacturaDetalle, Factura factura) {
        this.idFacturaDetalle = idFacturaDetalle;
        this.factura = factura;
    }
    public FacturaDetalle(int idFacturaDetalle, Factura factura, Integer cantidad, String descripcion, BigDecimal precioUnitario, BigDecimal valorVenta) {
       this.idFacturaDetalle = idFacturaDetalle;
       this.factura = factura;
       this.cantidad = cantidad;
       this.descripcion = descripcion;
       this.precioUnitario = precioUnitario;
       this.valorVenta = valorVenta;
    }
   
     @Id 

    
    @Column(name="idFacturaDetalle", unique=true, nullable=false)
    public int getIdFacturaDetalle() {
        return this.idFacturaDetalle;
    }
    
    public void setIdFacturaDetalle(int idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idFactura", nullable=false)
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    
    @Column(name="cantidad")
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
    @Column(name="descripcion", length=160)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="precioUnitario", precision=12)
    public BigDecimal getPrecioUnitario() {
        return this.precioUnitario;
    }
    
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
    @Column(name="valorVenta", precision=12)
    public BigDecimal getValorVenta() {
        return this.valorVenta;
    }
    
    public void setValorVenta(BigDecimal valorVenta) {
        this.valorVenta = valorVenta;
    }




}

