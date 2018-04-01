package com.projecto.Horadada.Entity;

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
@Table(name="SOLICITUD")
public class Solicitud {

	@Id     
    @Column(name="IDSOLICITUD", unique=true, nullable=false, precision=10, scale=0)
     private long idsolicitud;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDCLIENTE", nullable=false)
     private Cliente cliente;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHARECEPCION", length=7)
     private Date fecharecepcion;
    
    @Column(name="REQUERIMIENTO", length=200)
     private String requerimiento;
     
     @OneToMany(fetch=FetchType.EAGER, mappedBy="solicitud")
     private Set<Cotizacion> cotizacions = new HashSet<Cotizacion>(0);

    public Solicitud() {
    }
	
    public Solicitud(long idsolicitud, Cliente cliente) {
        this.idsolicitud = idsolicitud;
        this.cliente = cliente;
    }
    public Solicitud(long idsolicitud, Cliente cliente, Date fecharecepcion, String requerimiento, Set<Cotizacion> cotizacions) {
       this.idsolicitud = idsolicitud;
       this.cliente = cliente;
       this.fecharecepcion = fecharecepcion;
       this.requerimiento = requerimiento;
       this.cotizacions = cotizacions;
    }
        
    public long getIdsolicitud() {
        return this.idsolicitud;
    }
    
    public void setIdsolicitud(long idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecharecepcion() {
        return this.fecharecepcion;
    }
    
    public void setFecharecepcion(Date fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    public String getRequerimiento() {
        return this.requerimiento;
    }
    
    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
    }

    public Set<Cotizacion> getCotizacions() {
        return this.cotizacions;
    }
    
    public void setCotizacions(Set<Cotizacion> cotizacions) {
        this.cotizacions = cotizacions;
    }

}


