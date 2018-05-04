package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


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

/**
 * Ubicacionhist generated by hbm2java
 */
@Entity
@Table(name="UBICACIONHIST"
    ,schema="HORADADA"
)
public class Ubicacionhist  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private int idubicacionhist;
     private Ubicacion ubicacion;
     private int idubicacion;
     private int idvehiculo;
     private String longitud;
     private String latitud;
     private Date fecha;
     private Serializable hora;
     private String direccion;
     private String departamento;
     private String provincia;

    public Ubicacionhist() {
    }

	
    public Ubicacionhist(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Ubicacionhist(Ubicacion ubicacion, int idubicacion, int idvehiculo, String longitud, String latitud, Date fecha, Serializable hora, String direccion, String departamento, String provincia) {
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
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="ubicacion"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="IDUBICACIONHIST", unique=true, nullable=false, precision=10, scale=0)
    public int getIdubicacionhist() {
        return this.idubicacionhist;
    }
    
    public void setIdubicacionhist(int idubicacionhist) {
        this.idubicacionhist = idubicacionhist;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    @Column(name="IDUBICACION", precision=10, scale=0)
    public int getIdubicacion() {
        return this.idubicacion;
    }
    
    public void setIdubicacion(int idubicacion) {
        this.idubicacion = idubicacion;
    }

    
    @Column(name="IDVEHICULO", precision=10, scale=0)
    public int getIdvehiculo() {
        return this.idvehiculo;
    }
    
    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    
    @Column(name="LONGITUD", length=20)
    public String getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    
    @Column(name="LATITUD", length=20)
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

    
    @Column(name="DEPARTAMENTO", length=15)
    public String getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    
    @Column(name="PROVINCIA", length=15)
    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }




}


