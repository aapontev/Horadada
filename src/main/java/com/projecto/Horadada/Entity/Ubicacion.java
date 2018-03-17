package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ubicacion generated by hbm2java
 */
@Entity
@Table(name="UBICACION"
    ,schema="HORADADA"
)
public class Ubicacion  implements java.io.Serializable {


     private long idubicacion;
     private Vehiculo vehiculo;
     private long iddespacho;
     private String longitud;
     private String latitud;
     private Date fecha;
     private Serializable hora;
     private String direccion;
     private Ubicacionhist ubicacionhist;

    public Ubicacion() {
    }

	
    public Ubicacion(long idubicacion, Vehiculo vehiculo, long iddespacho, String longitud, String latitud) {
        this.idubicacion = idubicacion;
        this.vehiculo = vehiculo;
        this.iddespacho = iddespacho;
        this.longitud = longitud;
        this.latitud = latitud;
    }
    public Ubicacion(long idubicacion, Vehiculo vehiculo, long iddespacho, String longitud, String latitud, Date fecha, Serializable hora, String direccion, Ubicacionhist ubicacionhist) {
       this.idubicacion = idubicacion;
       this.vehiculo = vehiculo;
       this.iddespacho = iddespacho;
       this.longitud = longitud;
       this.latitud = latitud;
       this.fecha = fecha;
       this.hora = hora;
       this.direccion = direccion;
       this.ubicacionhist = ubicacionhist;
    }
   
     @Id 

    
    @Column(name="IDUBICACION", unique=true, nullable=false, precision=10, scale=0)
    public long getIdubicacion() {
        return this.idubicacion;
    }
    
    public void setIdubicacion(long idubicacion) {
        this.idubicacion = idubicacion;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDVEHICULO", nullable=false)
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    
    @Column(name="IDDESPACHO", nullable=false, precision=10, scale=0)
    public long getIddespacho() {
        return this.iddespacho;
    }
    
    public void setIddespacho(long iddespacho) {
        this.iddespacho = iddespacho;
    }

    
    @Column(name="LONGITUD", nullable=false, length=20)
    public String getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    
    @Column(name="LATITUD", nullable=false, length=20)
    public String getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", length=7)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="HORA")
    public Serializable getHora() {
        return this.hora;
    }
    
    public void setHora(Serializable hora) {
        this.hora = hora;
    }

    
    @Column(name="DIRECCION", length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="ubicacion")
    public Ubicacionhist getUbicacionhist() {
        return this.ubicacionhist;
    }
    
    public void setUbicacionhist(Ubicacionhist ubicacionhist) {
        this.ubicacionhist = ubicacionhist;
    }




}


