package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="TRANSPORTISTA", uniqueConstraints = @UniqueConstraint(columnNames="IDPERSONA"))
public class Transportista {

    @Id 
    @Column(name="IDTRANSPORTISTA", unique=true, nullable=false)
     private long idtransportista;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDPERSONA", nullable=false)
     private Persona persona;
     
     @Column(name="NROLICENCIA")
     private String nrolicencia;
     
     @Column(name="CATLICENCIA")
     private String catlicencia;
     
     @Column(name="IDSITUACIONTRANSPORTISTA")
     private Integer idsituaciontransportista;
     
     @OneToMany(fetch=FetchType.EAGER, mappedBy="transportista")
     private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>(0);

    public Transportista() {
    }

	
    public Transportista(long idtransportista, Persona persona, String nrolicencia) {
        this.idtransportista = idtransportista;
        this.persona = persona;
        this.nrolicencia = nrolicencia;
    }
    public Transportista(long idtransportista, Persona persona, String nrolicencia, String catlicencia, Integer idsituaciontransportista, Set<Vehiculo> vehiculos) {
       this.idtransportista = idtransportista;
       this.persona = persona;
       this.nrolicencia = nrolicencia;
       this.catlicencia = catlicencia;
       this.idsituaciontransportista = idsituaciontransportista;
       this.vehiculos = vehiculos;
    }
   
    public long getIdtransportista() {
        return this.idtransportista;
    }
    
    public void setIdtransportista(long idtransportista) {
        this.idtransportista = idtransportista;
    }

    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNrolicencia() {
        return this.nrolicencia;
    }
    
    public void setNrolicencia(String nrolicencia) {
        this.nrolicencia = nrolicencia;
    }

    public String getCatlicencia() {
        return this.catlicencia;
    }
    
    public void setCatlicencia(String catlicencia) {
        this.catlicencia = catlicencia;
    }

    public Integer getIdsituaciontransportista() {
        return this.idsituaciontransportista;
    }
    
    public void setIdsituaciontransportista(Integer idsituaciontransportista) {
        this.idsituaciontransportista = idsituaciontransportista;
    }

    public Set<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }
    
    public void setVehiculos(Set<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }




}


