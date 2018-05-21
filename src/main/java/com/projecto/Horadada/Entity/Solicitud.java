package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Solicitud generated by hbm2java
 */
@Entity
@Table(name="SOLICITUD"
    ,schema="HORADADA"
)
public class Solicitud  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private int idsolicitud;
     private Cliente cliente;
     private Date fecharecepcion;
     private String requerimiento;
     private int estado;
     private Set<Cotizacion> cotizacions = new HashSet<Cotizacion>(0);

    public Solicitud() {
    }

	
    public Solicitud(int idsolicitud, Cliente cliente) {
        this.idsolicitud = idsolicitud;
        this.cliente = cliente;
    }
    public Solicitud(int idsolicitud, Cliente cliente, Date fecharecepcion, String requerimiento, int estado,Set<Cotizacion> cotizacions) {
       this.idsolicitud = idsolicitud;
       this.cliente = cliente;
       this.fecharecepcion = fecharecepcion;
       this.requerimiento = requerimiento;
       this.cotizacions = cotizacions;
       this.estado = estado;
    }
   
     @Id 
     @GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "solicitud_seq") @SequenceGenerator (	
             name = "solicitud_seq" ,	
             sequenceName = "solicitud_seq" ,	
             allocationSize = 1 )    
    @Column(name="IDSOLICITUD", unique=true, nullable=false, precision=10, scale=0)
    public int getIdsolicitud() {
        return this.idsolicitud;
    }
    
    public void setIdsolicitud(int idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDCLIENTE", nullable=false)
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name="FECHARECEPCION", length=7)
    public Date getFecharecepcion() {
        return this.fecharecepcion;
    }
    
    public void setFecharecepcion(Date fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    
    @Column(name="REQUERIMIENTO", length=200)
    public String getRequerimiento() {
        return this.requerimiento;
    }
    
    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="solicitud")
    public Set<Cotizacion> getCotizacions() {
        return this.cotizacions;
    }
    
    public void setCotizacions(Set<Cotizacion> cotizacions) {
        this.cotizacions = cotizacions;
    }

    @Column(name="ESTADO", length=200)
	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}




}


