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
 * Contacto generated by hbm2java
 */
@Entity
@Table(name="contacto"
    ,schema="dbo"
    ,catalog="HORADADA"
)
public class Contacto  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idContacto;
     private Cliente cliente;
     private Persona persona;
     private Date fechaCreacion;

    public Contacto() {
    }

	
    public Contacto(int idContacto, Date fechaCreacion) {
        this.idContacto = idContacto;
        this.fechaCreacion = fechaCreacion;
    }
    public Contacto(int idContacto, Cliente cliente, Persona persona, Date fechaCreacion) {
       this.idContacto = idContacto;
       this.cliente = cliente;
       this.persona = persona;
       this.fechaCreacion = fechaCreacion;
    }
   
     @Id 

    
    @Column(name="idContacto", unique=true, nullable=false)
    public int getIdContacto() {
        return this.idContacto;
    }
    
    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCliente")
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaCreacion", nullable=false, length=10)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }




}


