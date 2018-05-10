package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Historicoprecios generated by hbm2java
 */
@Entity
@Table(name="HISTORICOPRECIOS"
    ,schema="HORADADA"
)
public class Historicoprecios  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private int idhistoricoprecios;
     private String origen;
     private String destino;
     private int pesotoneladas;
     private int longitudmetros;
     private BigDecimal preciosubtotal;
     private BigDecimal precioigv;
     private BigDecimal preciototal;

    public Historicoprecios() {
    }

	
    public Historicoprecios(int idhistoricoprecios) {
        this.idhistoricoprecios = idhistoricoprecios;
    }
    public Historicoprecios(int idhistoricoprecios, String origen, String destino, int pesotoneladas, int longitudmetros, BigDecimal preciosubtotal, BigDecimal precioigv, BigDecimal preciototal) {
       this.idhistoricoprecios = idhistoricoprecios;
       this.origen = origen;
       this.destino = destino;
       this.pesotoneladas = pesotoneladas;
       this.longitudmetros = longitudmetros;
       this.preciosubtotal = preciosubtotal;
       this.precioigv = precioigv;
       this.preciototal = preciototal;
    }
   
     @Id 

     @GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "historico_precios_seq") @SequenceGenerator ( 
 		    name = "historico_precios_seq" , 
 		    sequenceName = "historico_precios_sequence" , 
 		    allocationSize = 1 )
    @Column(name="IDHISTORICOPRECIOS", unique=true, nullable=false, precision=10, scale=0)
    public int getIdhistoricoprecios() {
        return this.idhistoricoprecios;
    }
    
    public void setIdhistoricoprecios(int idhistoricoprecios) {
        this.idhistoricoprecios = idhistoricoprecios;
    }

    
    @Column(name="ORIGEN", length=50)
    public String getOrigen() {
        return this.origen;
    }
    
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    
    @Column(name="DESTINO", length=50)
    public String getDestino() {
        return this.destino;
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
    }

    
    @Column(name="PESOTONELADAS", precision=10, scale=0)
    public int getPesotoneladas() {
        return this.pesotoneladas;
    }
    
    public void setPesotoneladas(int pesotoneladas) {
        this.pesotoneladas = pesotoneladas;
    }

    
    @Column(name="LONGITUDMETROS", precision=10, scale=0)
    public int getLongitudmetros() {
        return this.longitudmetros;
    }
    
    public void setLongitudmetros(int longitudmetros) {
        this.longitudmetros = longitudmetros;
    }

    
    @Column(name="PRECIOSUBTOTAL", precision=12)
    public BigDecimal getPreciosubtotal() {
        return this.preciosubtotal;
    }
    
    public void setPreciosubtotal(BigDecimal preciosubtotal) {
        this.preciosubtotal = preciosubtotal;
    }

    
    @Column(name="PRECIOIGV", precision=12)
    public BigDecimal getPrecioigv() {
        return this.precioigv;
    }
    
    public void setPrecioigv(BigDecimal precioigv) {
        this.precioigv = precioigv;
    }

    
    @Column(name="PRECIOTOTAL", precision=12)
    public BigDecimal getPreciototal() {
        return this.preciototal;
    }
    
    public void setPreciototal(BigDecimal preciototal) {
        this.preciototal = preciototal;
    }




}


