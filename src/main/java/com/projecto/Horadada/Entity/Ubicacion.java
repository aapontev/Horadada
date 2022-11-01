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
 * Ubicacion generated by hbm2java
 */
@Entity
@Table(name="ubicacion"
    ,schema="dbo"
    ,catalog="HORADADA"
)
public class Ubicacion  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUbicacion;
     private Vehiculo vehiculo;
     private String direccion;
     private Date fecha;
     private String hora;
     private Integer idDespacho;
     private String latitud;
     private String longitud;

    public Ubicacion() {
    }

	
    public Ubicacion(int idUbicacion, String latitud, String longitud) {
        this.idUbicacion = idUbicacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public Ubicacion(int idUbicacion, Vehiculo vehiculo, String direccion, Date fecha, String hora, Integer idDespacho, String latitud, String longitud) {
       this.idUbicacion = idUbicacion;
       this.vehiculo = vehiculo;
       this.direccion = direccion;
       this.fecha = fecha;
       this.hora = hora;
       this.idDespacho = idDespacho;
       this.latitud = latitud;
       this.longitud = longitud;
    }
   
     @Id 

    
    @Column(name="idUbicacion", unique=true, nullable=false)
    public int getIdUbicacion() {
        return this.idUbicacion;
    }
    
    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idVehiculo")
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    
    @Column(name="direccion", length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="hora")
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }

    
    @Column(name="idDespacho")
    public Integer getIdDespacho() {
        return this.idDespacho;
    }
    
    public void setIdDespacho(Integer idDespacho) {
        this.idDespacho = idDespacho;
    }

    
    @Column(name="latitud", nullable=false, length=20)
    public String getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    
    @Column(name="longitud", nullable=false, length=20)
    public String getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }




}


