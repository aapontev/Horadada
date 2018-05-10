package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Valorizaciondetalle generated by hbm2java
 */
@Entity
@Table(name="VALORIZACIONDETALLE"
    ,schema="HORADADA"
)
public class Valorizaciondetalle  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private ValorizaciondetalleId id;
     private Valorizacion valorizacion;
     private Factura factura;
     private Integer iddespacho;
     private int item;
     private Date fechacarga;
     private Date fechadescarga;
     private String nroguiatransporte;
     private String guiaanexada;
     private Byte diasstamby;
     private BigDecimal costostamby;
     private BigDecimal neto;
     private BigDecimal subtotal;
     private BigDecimal igv;
     private BigDecimal total;

    public Valorizaciondetalle() {
    }

	
    public Valorizaciondetalle(ValorizaciondetalleId id, Valorizacion valorizacion) {
        this.id = id;
        this.valorizacion = valorizacion;
    }
    public Valorizaciondetalle(ValorizaciondetalleId id, Valorizacion valorizacion, Factura factura, Integer iddespacho, int item, Date fechacarga, Date fechadescarga, String nroguiatransporte, String guiaanexada, Byte diasstamby, BigDecimal costostamby, BigDecimal neto, BigDecimal subtotal, BigDecimal igv, BigDecimal total) {
       this.id = id;
       this.valorizacion = valorizacion;
       this.factura = factura;
       this.iddespacho = iddespacho;
       this.item = item;
       this.fechacarga = fechacarga;
       this.fechadescarga = fechadescarga;
       this.nroguiatransporte = nroguiatransporte;
       this.guiaanexada = guiaanexada;
       this.diasstamby = diasstamby;
       this.costostamby = costostamby;
       this.neto = neto;
       this.subtotal = subtotal;
       this.igv = igv;
       this.total = total;
    }
   
     @EmbeddedId

     @GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "valorizacion_detalle_seq") @SequenceGenerator ( 
 		    name = "valorizacion_detalle_seq" , 
 		    sequenceName = "valorizacion_detalle_sequence" , 
 		    allocationSize = 1 )
    @AttributeOverrides( {
        @AttributeOverride(name="idvalorizaciondetalle", column=@Column(name="IDVALORIZACIONDETALLE", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="idvalorizacion", column=@Column(name="IDVALORIZACION", nullable=false, precision=5, scale=0) ) } )
    public ValorizaciondetalleId getId() {
        return this.id;
    }
    
    public void setId(ValorizaciondetalleId id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDVALORIZACION", nullable=false, insertable=false, updatable=false)
    public Valorizacion getValorizacion() {
        return this.valorizacion;
    }
    
    public void setValorizacion(Valorizacion valorizacion) {
        this.valorizacion = valorizacion;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDFACTURA")
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    
    @Column(name="IDDESPACHO", precision=5, scale=0)
    public Integer getIddespacho() {
        return this.iddespacho;
    }
    
    public void setIddespacho(Integer iddespacho) {
        this.iddespacho = iddespacho;
    }

    
    @Column(name="ITEM", precision=4, scale=0)
    public int getItem() {
        return this.item;
    }
    
    public void setItem(int item) {
        this.item = item;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHACARGA", length=7)
    public Date getFechacarga() {
        return this.fechacarga;
    }
    
    public void setFechacarga(Date fechacarga) {
        this.fechacarga = fechacarga;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHADESCARGA", length=7)
    public Date getFechadescarga() {
        return this.fechadescarga;
    }
    
    public void setFechadescarga(Date fechadescarga) {
        this.fechadescarga = fechadescarga;
    }

    
    @Column(name="NROGUIATRANSPORTE", length=20)
    public String getNroguiatransporte() {
        return this.nroguiatransporte;
    }
    
    public void setNroguiatransporte(String nroguiatransporte) {
        this.nroguiatransporte = nroguiatransporte;
    }

    
    @Column(name="GUIAANEXADA", length=20)
    public String getGuiaanexada() {
        return this.guiaanexada;
    }
    
    public void setGuiaanexada(String guiaanexada) {
        this.guiaanexada = guiaanexada;
    }

    
    @Column(name="DIASSTAMBY", precision=2, scale=0)
    public Byte getDiasstamby() {
        return this.diasstamby;
    }
    
    public void setDiasstamby(Byte diasstamby) {
        this.diasstamby = diasstamby;
    }

    
    @Column(name="COSTOSTAMBY", precision=9)
    public BigDecimal getCostostamby() {
        return this.costostamby;
    }
    
    public void setCostostamby(BigDecimal costostamby) {
        this.costostamby = costostamby;
    }

    
    @Column(name="NETO", precision=9)
    public BigDecimal getNeto() {
        return this.neto;
    }
    
    public void setNeto(BigDecimal neto) {
        this.neto = neto;
    }

    
    @Column(name="SUBTOTAL", precision=9)
    public BigDecimal getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    
    @Column(name="IGV", precision=9)
    public BigDecimal getIgv() {
        return this.igv;
    }
    
    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    
    @Column(name="TOTAL", precision=9)
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }




}


