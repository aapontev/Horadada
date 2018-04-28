package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name="CLIENTE"
    ,schema="HORADADA"
)
public class Cliente  implements Serializable {


   
	private long idcliente;
     private Persona persona;
     private String ruc;
     private String razonsocial;
     private String direccion;
     @OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
     private Set<Despacho> despachos = new HashSet<Despacho>(0);
     private Set<Factura> facturas = new HashSet<Factura>(0);
     private Set<Valorizacion> valorizacions = new HashSet<Valorizacion>(0);
     private Set<Solicitud> solicituds = new HashSet<Solicitud>(0);

    public Cliente() {
    }

	
    public Cliente(long idcliente, Persona persona) {
        this.idcliente = idcliente;
        this.persona = persona;
    }
    public Cliente(long idcliente, Persona persona, String ruc, String razonsocial, String direccion, Set<Despacho> despachos, Set<Factura> facturas, Set<Valorizacion> valorizacions, Set<Solicitud> solicituds) {
       this.idcliente = idcliente;
       this.persona = persona;
       this.ruc = ruc;
       this.razonsocial = razonsocial;
       this.direccion = direccion;
       this.despachos = despachos;
       this.facturas = facturas;
       this.valorizacions = valorizacions;
       this.solicituds = solicituds;
    }
   
     @Id     
    @Column(name="IDCLIENTE", unique=true, nullable=false, precision=10, scale=0)
     @GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "cliente_seq") @SequenceGenerator ( 
 		    name = "cliente_seq" , 
 		    sequenceName = "cliente_sequence" , 
 		    allocationSize = 1 )
    public long getIdcliente() {
        return this.idcliente;
    }
    
    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDPERSONA", nullable=false)
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    @Column(name="RUC", length=11)
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    
    @Column(name="RAZONSOCIAL", length=25)
    public String getRazonsocial() {
        return this.razonsocial;
    }
    
    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    
    @Column(name="DIRECCION", length=50)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")   
    public Set<Despacho> getDespachos() {
        return this.despachos;
    }
    
    public void setDespachos(Set<Despacho> despachos) {
        this.despachos = despachos;
    }
   
@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<Valorizacion> getValorizacions() {
        return this.valorizacions;
    }
    
    public void setValorizacions(Set<Valorizacion> valorizacions) {
        this.valorizacions = valorizacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<Solicitud> getSolicituds() {
        return this.solicituds;
    }
    
    public void setSolicituds(Set<Solicitud> solicituds) {
        this.solicituds = solicituds;
    }


  	private static final long serialVersionUID = 1L;

}


