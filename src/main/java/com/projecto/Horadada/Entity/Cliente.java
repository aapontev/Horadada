package com.projecto.Horadada.Entity;

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

@Entity
@Table(name="CLIENTE"
    ,schema="HORADADA"
)
public class Cliente {


    @Id     
    @Column(name="IDCLIENTE", unique=true, nullable=false, precision=10, scale=0)
     private long idcliente;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDPERSONA", nullable=false)
     private Persona persona;
    
    @Column(name="RUC", length=11)
     private String ruc;
    
    @Column(name="RAZONSOCIAL", length=25)
     private String razonsocial;
    
    @Column(name="DIRECCION", length=50)
     private String direccion;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="cliente")
     private Set<Despacho> despachos = new HashSet<Despacho>();
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="cliente")
     private Set<Factura> facturas = new HashSet<Factura>(0);
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="cliente")
     private Set<Valorizacion> valorizacions = new HashSet<Valorizacion>(0);
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="cliente")
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
   
    public long getIdcliente() {
        return this.idcliente;
    }
    
    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonsocial() {
        return this.razonsocial;
    }
    
    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Despacho> getDespachos() {
        return this.despachos;
    }
    
    public void setDespachos(Set<Despacho> despachos) {
        this.despachos = despachos;
    }
    
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

    public Set<Valorizacion> getValorizacions() {
        return this.valorizacions;
    }
    
    public void setValorizacions(Set<Valorizacion> valorizacions) {
        this.valorizacions = valorizacions;
    }

    public Set<Solicitud> getSolicituds() {
        return this.solicituds;
    }
    
    public void setSolicituds(Set<Solicitud> solicituds) {
        this.solicituds = solicituds;
    }

}


