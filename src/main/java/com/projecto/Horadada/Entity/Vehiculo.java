package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Vehiculo generated by hbm2java
 */
@Entity
@Table(name="VEHICULO"
    ,schema="HORADADA"
)
public class Vehiculo  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private long idvehiculo;
     private Transportista transportista;
     private String placa;
     private String color;
     private Long idmarca;
     private Long idmodelo;
     private Long idaseguradora;
     private String detalles;
     private String tarjetacirculacion;
     private Date fechaultimarevision;
     private Long nroejes;
     private BigDecimal pesomaximo;
     private BigDecimal pesovehiculo;
     private Set<Ubicacion> ubicacions = new HashSet<Ubicacion>(0);

    public Vehiculo() {
    }

	
    public Vehiculo(long idvehiculo, Transportista transportista) {
        this.idvehiculo = idvehiculo;
        this.transportista = transportista;
    }
    public Vehiculo(long idvehiculo, Transportista transportista, String placa, String color, Long idmarca, Long idmodelo, Long idaseguradora, String detalles, String tarjetacirculacion, Date fechaultimarevision, Long nroejes, BigDecimal pesomaximo, BigDecimal pesovehiculo, Set<Ubicacion> ubicacions) {
       this.idvehiculo = idvehiculo;
       this.transportista = transportista;
       this.placa = placa;
       this.color = color;
       this.idmarca = idmarca;
       this.idmodelo = idmodelo;
       this.idaseguradora = idaseguradora;
       this.detalles = detalles;
       this.tarjetacirculacion = tarjetacirculacion;
       this.fechaultimarevision = fechaultimarevision;
       this.nroejes = nroejes;
       this.pesomaximo = pesomaximo;
       this.pesovehiculo = pesovehiculo;
       this.ubicacions = ubicacions;
    }
   
     @Id 

    
    @Column(name="IDVEHICULO", unique=true, nullable=false, precision=10, scale=0)
    public long getIdvehiculo() {
        return this.idvehiculo;
    }
    
    public void setIdvehiculo(long idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDTRANSPORTISTA", nullable=false)
    public Transportista getTransportista() {
        return this.transportista;
    }
    
    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    
    @Column(name="PLACA", length=7)
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
    @Column(name="COLOR", length=15)
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    
    @Column(name="IDMARCA", precision=10, scale=0)
    public Long getIdmarca() {
        return this.idmarca;
    }
    
    public void setIdmarca(Long idmarca) {
        this.idmarca = idmarca;
    }

    
    @Column(name="IDMODELO", precision=10, scale=0)
    public Long getIdmodelo() {
        return this.idmodelo;
    }
    
    public void setIdmodelo(Long idmodelo) {
        this.idmodelo = idmodelo;
    }

    
    @Column(name="IDASEGURADORA", precision=10, scale=0)
    public Long getIdaseguradora() {
        return this.idaseguradora;
    }
    
    public void setIdaseguradora(Long idaseguradora) {
        this.idaseguradora = idaseguradora;
    }

    
    @Column(name="DETALLES", length=45)
    public String getDetalles() {
        return this.detalles;
    }
    
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    
    @Column(name="TARJETACIRCULACION", length=15)
    public String getTarjetacirculacion() {
        return this.tarjetacirculacion;
    }
    
    public void setTarjetacirculacion(String tarjetacirculacion) {
        this.tarjetacirculacion = tarjetacirculacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHAULTIMAREVISION", length=7)
    public Date getFechaultimarevision() {
        return this.fechaultimarevision;
    }
    
    public void setFechaultimarevision(Date fechaultimarevision) {
        this.fechaultimarevision = fechaultimarevision;
    }

    
    @Column(name="NROEJES", precision=10, scale=0)
    public Long getNroejes() {
        return this.nroejes;
    }
    
    public void setNroejes(Long nroejes) {
        this.nroejes = nroejes;
    }

    
    @Column(name="PESOMAXIMO", precision=6)
    public BigDecimal getPesomaximo() {
        return this.pesomaximo;
    }
    
    public void setPesomaximo(BigDecimal pesomaximo) {
        this.pesomaximo = pesomaximo;
    }

    
    @Column(name="PESOVEHICULO", precision=6)
    public BigDecimal getPesovehiculo() {
        return this.pesovehiculo;
    }
    
    public void setPesovehiculo(BigDecimal pesovehiculo) {
        this.pesovehiculo = pesovehiculo;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="vehiculo")
    public Set<Ubicacion> getUbicacions() {
        return this.ubicacions;
    }
    
    public void setUbicacions(Set<Ubicacion> ubicacions) {
        this.ubicacions = ubicacions;
    }

}


