package com.projecto.Horadada.Entity;
// Generated 28/01/2020 04:40:27 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Observaciones generated by hbm2java
 */
@Entity
@Table(name="observaciones"
    ,schema="dbo"
    ,catalog="HORADADA"
)
public class Observaciones  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idObservaciones;
     private Date fechaIngreso;
     private int idDespacho;
     private String observacionDetalle;

    public Observaciones() {
    }

	
    public Observaciones(int idObservaciones, int idDespacho) {
        this.idObservaciones = idObservaciones;
        this.idDespacho = idDespacho;
    }
    public Observaciones(int idObservaciones, Date fechaIngreso, int idDespacho, String observacionDetalle) {
       this.idObservaciones = idObservaciones;
       this.fechaIngreso = fechaIngreso;
       this.idDespacho = idDespacho;
       this.observacionDetalle = observacionDetalle;
    }
   
     @Id 

    
    @Column(name="idObservaciones", unique=true, nullable=false)
    public int getIdObservaciones() {
        return this.idObservaciones;
    }
    
    public void setIdObservaciones(int idObservaciones) {
        this.idObservaciones = idObservaciones;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaIngreso", length=10)
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    
    @Column(name="idDespacho", nullable=false)
    public int getIdDespacho() {
        return this.idDespacho;
    }
    
    public void setIdDespacho(int idDespacho) {
        this.idDespacho = idDespacho;
    }

    
    @Column(name="observacionDetalle", length=200)
    public String getObservacionDetalle() {
        return this.observacionDetalle;
    }
    
    public void setObservacionDetalle(String observacionDetalle) {
        this.observacionDetalle = observacionDetalle;
    }




}


