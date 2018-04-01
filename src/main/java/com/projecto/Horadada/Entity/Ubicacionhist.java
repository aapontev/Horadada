package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="UBICACIONHIST")
public class Ubicacionhist {

     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="ubicacion"))@Id @GeneratedValue(generator="generator")
     @Column(name="IDUBICACIONHIST", unique=true, nullable=false, precision=10, scale=0)
     private long idubicacionhist;
     
     @OneToOne(fetch=FetchType.EAGER)@PrimaryKeyJoinColumn
     private Ubicacion ubicacion;
     
     @Column(name="IDUBICACION", precision=10, scale=0)
     private Long idubicacion;
     
     @Column(name="IDVEHICULO", precision=10, scale=0)
     private Long idvehiculo;
     
     @Column(name="LONGITUD", length=20)
     private String longitud;
     
     @Column(name="LATITUD", length=20)
     private String latitud;
     
     @Temporal(TemporalType.DATE)
     @Column(name="FECHA", length=7)
     private Date fecha;
     
     @Column(name="HORA")
     private Serializable hora;
     
     @Column(name="DIRECCION", length=45)
     private String direccion;
     
     @Column(name="DEPARTAMENTO", length=15)
     private String departamento;
     
     @Column(name="PROVINCIA", length=15)
     private String provincia;

    public Ubicacionhist() {
    }

	
    public Ubicacionhist(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Ubicacionhist(Ubicacion ubicacion, Long idubicacion, Long idvehiculo, String longitud, String latitud, Date fecha, Serializable hora, String direccion, String departamento, String provincia) {
       this.ubicacion = ubicacion;
       
       this.idubicacion = idubicacion;
       this.idvehiculo = idvehiculo;
       this.longitud = longitud;
       this.latitud = latitud;
       this.fecha = fecha;
       this.hora = hora;
       this.direccion = direccion;
       this.departamento = departamento;
       this.provincia = provincia;
    }
   
    public long getIdubicacionhist() {
        return this.idubicacionhist;
    }
    
    public void setIdubicacionhist(long idubicacionhist) {
        this.idubicacionhist = idubicacionhist;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Long getIdubicacion() {
        return this.idubicacion;
    }
    
    public void setIdubicacion(Long idubicacion) {
        this.idubicacion = idubicacion;
    }

    public Long getIdvehiculo() {
        return this.idvehiculo;
    }
    
    public void setIdvehiculo(Long idvehiculo) {
        this.idvehiculo = idvehiculo;
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

    public String getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }




}


