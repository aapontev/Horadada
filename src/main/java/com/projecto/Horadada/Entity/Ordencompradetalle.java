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
@Table(name="ORDENCOMPRADETALLE")
public class Ordencompradetalle {

	@Id
	@Column(name="IDORDENCOMPRADETALLE", nullable=false, precision=10, scale=0)
     private int idordencompradetalle;
     
     @ManyToOne(fetch=FetchType.EAGER)
     @JoinColumn(name="IDORDENCOMPRA", nullable=false, insertable=false, updatable=false)
     private Ordencompra ordencompra;
     
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

    public Ordencompradetalle() {
    }

	
    public Ordencompradetalle(int idordencompradetalle, Ordencompra ordencompra) {
        this.idordencompradetalle = idordencompradetalle;
        this.ordencompra = ordencompra;
    }
    public Ordencompradetalle(int idordencompradetalle, Ordencompra ordencompra, Long item, String codrecurso, String descripcion, String ccostos, Long idunidadmedida, BigDecimal cantidad, BigDecimal preciounitario, BigDecimal descuento, BigDecimal totaldetalle) {
       this.idordencompradetalle = idordencompradetalle;
       this.ordencompra = ordencompra;
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

    public int getIdordencompradetalle() {
        return this.idordencompradetalle;
    }
    
    public void setIdordencompradetalle(int idordencompradetalle) {
        this.idordencompradetalle = idordencompradetalle;
    }

    public Ordencompra getOrdencompra() {
        return this.ordencompra;
    }
    
    public void setOrdencompra(Ordencompra ordencompra) {
        this.ordencompra = ordencompra;
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


