package com.projecto.Horadada.Entity;
// Generated 28/01/2020 04:40:27 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cotizacionDetalle"
    ,schema="dbo"
    ,catalog="HORADADA"
)
public class CotizacionDetalle  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCotizacionDetalle;
     private Cotizacion cotizacion;
     private Double cantidad;
     private String ccostos;
     private String codRecurso;
     private String descripcion;
     private Double descuento;
     private Integer idUnidadMedida;
     private Integer item;
     private Double precioUnitario;
     private Double totalDetalle;

    public CotizacionDetalle() {
    }

	
    public CotizacionDetalle(int idCotizacionDetalle) {
        this.idCotizacionDetalle = idCotizacionDetalle;
    }
    public CotizacionDetalle(int idCotizacionDetalle, Cotizacion cotizacion, Double cantidad, String ccostos, String codRecurso, String descripcion, Double descuento, Integer idUnidadMedida, Integer item, Double precioUnitario, Double totalDetalle) {
       this.idCotizacionDetalle = idCotizacionDetalle;
       this.cotizacion = cotizacion;
       this.cantidad = cantidad;
       this.ccostos = ccostos;
       this.codRecurso = codRecurso;
       this.descripcion = descripcion;
       this.descuento = descuento;
       this.idUnidadMedida = idUnidadMedida;
       this.item = item;
       this.precioUnitario = precioUnitario;
       this.totalDetalle = totalDetalle;
    }
   
     @Id 

    
    @Column(name="idCotizacion_detalle", unique=true, nullable=false)
    public int getIdCotizacionDetalle() {
        return this.idCotizacionDetalle;
    }
    
    public void setIdCotizacionDetalle(int idCotizacionDetalle) {
        this.idCotizacionDetalle = idCotizacionDetalle;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCotizacion")
    public Cotizacion getCotizacion() {
        return this.cotizacion;
    }
    
    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    
    @Column(name="cantidad", precision=53, scale=0)
    public Double getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    
    @Column(name="ccostos", length=30)
    public String getCcostos() {
        return this.ccostos;
    }
    
    public void setCcostos(String ccostos) {
        this.ccostos = ccostos;
    }

    
    @Column(name="codRecurso", length=15)
    public String getCodRecurso() {
        return this.codRecurso;
    }
    
    public void setCodRecurso(String codRecurso) {
        this.codRecurso = codRecurso;
    }

    
    @Column(name="descripcion", length=100)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="descuento", precision=53, scale=0)
    public Double getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    
    @Column(name="idUnidadMedida")
    public Integer getIdUnidadMedida() {
        return this.idUnidadMedida;
    }
    
    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    
    @Column(name="item")
    public Integer getItem() {
        return this.item;
    }
    
    public void setItem(Integer item) {
        this.item = item;
    }

    
    @Column(name="precioUnitario", precision=53, scale=0)
    public Double getPrecioUnitario() {
        return this.precioUnitario;
    }
    
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
    @Column(name="totalDetalle", precision=53, scale=0)
    public Double getTotalDetalle() {
        return this.totalDetalle;
    }
    
    public void setTotalDetalle(Double totalDetalle) {
        this.totalDetalle = totalDetalle;
    }




}


