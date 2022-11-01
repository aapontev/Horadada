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
 * TipoServicio generated by hbm2java
 */
@Entity
@Table(name="tipoServicio"
    ,schema="dbo"
    ,catalog="HORADADA"
)
public class TipoServicio  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idServicio;
     private Date fechaIngreso;
     private String nombreServicio;

    public TipoServicio() {
    }

	
    public TipoServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    public TipoServicio(int idServicio, Date fechaIngreso, String nombreServicio) {
       this.idServicio = idServicio;
       this.fechaIngreso = fechaIngreso;
       this.nombreServicio = nombreServicio;
    }
   
     @Id 

    
    @Column(name="idServicio", unique=true, nullable=false)
    public int getIdServicio() {
        return this.idServicio;
    }
    
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaIngreso", length=10)
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    
    @Column(name="nombreServicio", length=50)
    public String getNombreServicio() {
        return this.nombreServicio;
    }
    
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }




}

