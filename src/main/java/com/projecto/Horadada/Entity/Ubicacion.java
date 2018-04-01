package com.projecto.Horadada.Entity;

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

@Entity
@Table(name="UBICACION"
    ,schema="HORADADA"
)
public class Ubicacion {


     @Id     
     @Column(name="IDUBICACION", unique=true, nullable=false, precision=10, scale=0)
     private long idubicacion;
     
     @ManyToOne(fetch=FetchType.EAGER)
     @JoinColumn(name="IDVEHICULO", nullable=false)
     private Vehiculo vehiculo;
     
     @Column(name="IDDESPACHO", nullable=false, precision=10, scale=0)
     private long iddespacho;
     
     @Column(name="LONGITUD", nullable=false, length=20)
     private String longitud;
     
     @Column(name="LATITUD", nullable=false, length=20)
     private String latitud;
     
     @Temporal(TemporalType.DATE)
     @Column(name="FECHA", length=7)
     private Date fecha;
     
     @Column(name="HORA")
     private Serializable hora;
     
     @Column(name="DIRECCION", length=45)
     private String direccion; 
     
     @OneToOne(fetch=FetchType.EAGER, mappedBy="ubicacion")
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
   
    public long getIdubicacion() {
        return this.idubicacion;
    }
    
    public void setIdubicacion(long idubicacion) {
        this.idubicacion = idubicacion;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public long getIddespacho() {
        return this.iddespacho;
    }
    
    public void setIddespacho(long iddespacho) {
        this.iddespacho = iddespacho;
    }

    public String getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Serializable getHora() {
        return this.hora;
    }
    
    public void setHora(Serializable hora) {
        this.hora = hora;
    }

    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ubicacionhist getUbicacionhist() {
        return this.ubicacionhist;
    }
    
    public void setUbicacionhist(Ubicacionhist ubicacionhist) {
        this.ubicacionhist = ubicacionhist;
    }




}


