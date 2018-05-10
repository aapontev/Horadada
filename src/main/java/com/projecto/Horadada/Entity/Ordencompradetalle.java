package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Ordencompradetalle generated by hbm2java
 */
@Entity
@Table(name="ORDENCOMPRADETALLE"
    ,schema="HORADADA"
)
public class Ordencompradetalle  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private OrdencompradetalleId id;
     private Ordencompra ordencompra;
     private int item;
     private String codrecurso;
     private String descripcion;
     private String ccostos;
     private int idunidadmedida;
     private BigDecimal cantidad;
     private BigDecimal preciounitario;
     private BigDecimal descuento;
     private BigDecimal totaldetalle;

    public Ordencompradetalle() {
    }

	
    public Ordencompradetalle(OrdencompradetalleId id, Ordencompra ordencompra) {
        this.id = id;
        this.ordencompra = ordencompra;
    }
    public Ordencompradetalle(OrdencompradetalleId id, Ordencompra ordencompra, int item, String codrecurso, String descripcion, String ccostos, int idunidadmedida, BigDecimal cantidad, BigDecimal preciounitario, BigDecimal descuento, BigDecimal totaldetalle) {
       this.id = id;
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
   
     @EmbeddedId

     @GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "orden_compra_detalle_seq") @SequenceGenerator ( 
 		    name = "orden_compra_detalle_seq" , 
 		    sequenceName = "orden_compra_detalle_sequence" , 
 		    allocationSize = 1 )
    @AttributeOverrides( {
        @AttributeOverride(name="idordencompradetalle", column=@Column(name="IDORDENCOMPRADETALLE", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="idordencompra", column=@Column(name="IDORDENCOMPRA", nullable=false, precision=10, scale=0) ) } )
    public OrdencompradetalleId getId() {
        return this.id;
    }
    
    public void setId(OrdencompradetalleId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDORDENCOMPRA", nullable=false, insertable=false, updatable=false)
    public Ordencompra getOrdencompra() {
        return this.ordencompra;
    }
    
    public void setOrdencompra(Ordencompra ordencompra) {
        this.ordencompra = ordencompra;
    }

    
    @Column(name="ITEM", precision=10, scale=0)
    public int getItem() {
        return this.item;
    }
    
    public void setItem(int item) {
        this.item = item;
    }

    
    @Column(name="CODRECURSO", length=10)
    public String getCodrecurso() {
        return this.codrecurso;
    }
    
    public void setCodrecurso(String codrecurso) {
        this.codrecurso = codrecurso;
    }

    
    @Column(name="DESCRIPCION", length=150)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="CCOSTOS", length=30)
    public String getCcostos() {
        return this.ccostos;
    }
    
    public void setCcostos(String ccostos) {
        this.ccostos = ccostos;
    }

    
    @Column(name="IDUNIDADMEDIDA", precision=10, scale=0)
    public int getIdunidadmedida() {
        return this.idunidadmedida;
    }
    
    public void setIdunidadmedida(int idunidadmedida) {
        this.idunidadmedida = idunidadmedida;
    }

    
    @Column(name="CANTIDAD", precision=6, scale=4)
    public BigDecimal getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    
    @Column(name="PRECIOUNITARIO", precision=9)
    public BigDecimal getPreciounitario() {
        return this.preciounitario;
    }
    
    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }

    
    @Column(name="DESCUENTO", precision=9)
    public BigDecimal getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    
    @Column(name="TOTALDETALLE", precision=9)
    public BigDecimal getTotaldetalle() {
        return this.totaldetalle;
    }
    
    public void setTotaldetalle(BigDecimal totaldetalle) {
        this.totaldetalle = totaldetalle;
    }




}


