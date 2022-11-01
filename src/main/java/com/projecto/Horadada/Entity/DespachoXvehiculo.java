package com.projecto.Horadada.Entity;
// Generated 28/01/2020 04:40:27 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DespachoXvehiculo generated by hbm2java
 */
@Entity
@Table(name="despachoXVehiculo"
    ,schema="dbo"
    ,catalog="HORADADA"
)
public class DespachoXvehiculo  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDespachoXvehiculo;
     private Despacho despacho;
     private Date fechaCarga;
     private Date fechaDescarga;
     private String horaCarga;
     private String horaDescarga;
     private int idTransportista;

    public DespachoXvehiculo() {
    }

	
    public DespachoXvehiculo(int idDespachoXvehiculo, int idTransportista) {
        this.idDespachoXvehiculo = idDespachoXvehiculo;
        this.idTransportista = idTransportista;
    }
    public DespachoXvehiculo(int idDespachoXvehiculo, Despacho despacho, Date fechaCarga, Date fechaDescarga, String horaCarga, String horaDescarga, int idTransportista) {
       this.idDespachoXvehiculo = idDespachoXvehiculo;
       this.despacho = despacho;
       this.fechaCarga = fechaCarga;
       this.fechaDescarga = fechaDescarga;
       this.horaCarga = horaCarga;
       this.horaDescarga = horaDescarga;
       this.idTransportista = idTransportista;
    }
   
     @Id 

    
    @Column(name="idDespachoXVehiculo", unique=true, nullable=false)
    public int getIdDespachoXvehiculo() {
        return this.idDespachoXvehiculo;
    }
    
    public void setIdDespachoXvehiculo(int idDespachoXvehiculo) {
        this.idDespachoXvehiculo = idDespachoXvehiculo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idDespacho")
    public Despacho getDespacho() {
        return this.despacho;
    }
    
    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaCarga", length=10)
    public Date getFechaCarga() {
        return this.fechaCarga;
    }
    
    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaDescarga", length=10)
    public Date getFechaDescarga() {
        return this.fechaDescarga;
    }
    
    public void setFechaDescarga(Date fechaDescarga) {
        this.fechaDescarga = fechaDescarga;
    }

    
    @Column(name="horaCarga")
    public String getHoraCarga() {
        return this.horaCarga;
    }
    
    public void setHoraCarga(String horaCarga) {
        this.horaCarga = horaCarga;
    }

    
    @Column(name="horaDescarga")
    public String getHoraDescarga() {
        return this.horaDescarga;
    }
    
    public void setHoraDescarga(String horaDescarga) {
        this.horaDescarga = horaDescarga;
    }

    
    @Column(name="idTransportista", nullable=false)
    public int getIdTransportista() {
        return this.idTransportista;
    }
    
    public void setIdTransportista(int idTransportista) {
        this.idTransportista = idTransportista;
    }




}


