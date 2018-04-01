package com.projecto.Horadada.Entity;

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

@Entity
@Table(name="VEHICULO")
public class Vehiculo {


    @Id 
    @Column(name="IDVEHICULO", unique=true, nullable=false, precision=10, scale=0)
     private long idvehiculo;
    
    @ManyToOne(fetch=FetchType.EAGER)
     @JoinColumn(name="IDTRANSPORTISTA", nullable=false)     
     private Transportista transportista;
    
    @Column(name="PLACA", length=7)
     private String placa;
    
    @Column(name="COLOR", length=15)
     private String color;
    
    @Column(name="IDMARCA", precision=10, scale=0)
     private Long idmarca;
    
    @Column(name="IDMODELO", precision=10, scale=0)
     private Long idmodelo;
    
    @Column(name="IDASEGURADORA", precision=10, scale=0)
     private Long idaseguradora;
    
    @Column(name="DETALLES", length=45)
     private String detalles;
    
    @Column(name="TARJETACIRCULACION", length=15)
     private String tarjetacirculacion;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHAULTIMAREVISION", length=7)
     private Date fechaultimarevision;
    
    @Column(name="NROEJES", precision=10, scale=0)
     private Long nroejes;
    
    @Column(name="PESOMAXIMO", precision=6)
     private BigDecimal pesomaximo;
    
    @Column(name="PESOVEHICULO", precision=6)
     private BigDecimal pesovehiculo;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="vehiculo")
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
    public long getIdvehiculo() {
        return this.idvehiculo;
    }
    
    public void setIdvehiculo(long idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

   public Transportista getTransportista() {
        return this.transportista;
    }
    
    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    public Long getIdmarca() {
        return this.idmarca;
    }
    
    public void setIdmarca(Long idmarca) {
        this.idmarca = idmarca;
    }

    public Long getIdmodelo() {
        return this.idmodelo;
    }
    
    public void setIdmodelo(Long idmodelo) {
        this.idmodelo = idmodelo;
    }

    public Long getIdaseguradora() {
        return this.idaseguradora;
    }
    
    public void setIdaseguradora(Long idaseguradora) {
        this.idaseguradora = idaseguradora;
    }

    public String getDetalles() {
        return this.detalles;
    }
    
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getTarjetacirculacion() {
        return this.tarjetacirculacion;
    }
    
    public void setTarjetacirculacion(String tarjetacirculacion) {
        this.tarjetacirculacion = tarjetacirculacion;
    }

    public Date getFechaultimarevision() {
        return this.fechaultimarevision;
    }
    
    public void setFechaultimarevision(Date fechaultimarevision) {
        this.fechaultimarevision = fechaultimarevision;
    }

    public Long getNroejes() {
        return this.nroejes;
    }
    
    public void setNroejes(Long nroejes) {
        this.nroejes = nroejes;
    }

    public BigDecimal getPesomaximo() {
        return this.pesomaximo;
    }
    
    public void setPesomaximo(BigDecimal pesomaximo) {
        this.pesomaximo = pesomaximo;
    }

    public BigDecimal getPesovehiculo() {
        return this.pesovehiculo;
    }
    
    public void setPesovehiculo(BigDecimal pesovehiculo) {
        this.pesovehiculo = pesovehiculo;
    }

    public Set<Ubicacion> getUbicacions() {
        return this.ubicacions;
    }
    
    public void setUbicacions(Set<Ubicacion> ubicacions) {
        this.ubicacions = ubicacions;
    }


}


