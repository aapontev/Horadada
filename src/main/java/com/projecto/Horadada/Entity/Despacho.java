package com.projecto.Horadada.Entity;

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

@Entity
@Table(name="DESPACHO")
public class Despacho{
	   
    @Id     
    @Column(name="IDDESPACHO", unique=true, nullable=false, precision=10, scale=0)
     private long iddespacho;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDCLIENTE")
     private Cliente cliente;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDORDENCOMPRA", nullable=false)
     private Ordencompra ordencompra;
    
    @Column(name="IDESTADODESPACHO", precision=10, scale=0)
     private Long idestadodespacho;
    
    @Column(name="DESCRIPCIONMATERIA", length=50)
     private String descripcionmateria;
    
    @Column(name="DIRECCIONPARTIDA", length=45)
     private String direccionpartida;
    
    @Column(name="DIRECCIONLLEGADA", length=45)
     private String direccionllegada;
    
    @Column(name="DIASESTIMADOS", precision=10, scale=0)
     private Long diasestimados;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHAINICIO", length=7)
     private Date fechainicio;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHAFIN", length=7)
     private Date fechafin;

    public Despacho() {
    }

	
    public Despacho(long iddespacho, Ordencompra ordencompra) {
        this.iddespacho = iddespacho;
        this.ordencompra = ordencompra;
    }
    public Despacho(long iddespacho, Cliente cliente, Ordencompra ordencompra, Long idestadodespacho, String descripcionmateria, String direccionpartida, String direccionllegada, Long diasestimados, Date fechainicio, Date fechafin) {
       this.iddespacho = iddespacho;
       this.cliente = cliente;
       this.ordencompra = ordencompra;
       this.idestadodespacho = idestadodespacho;
       this.descripcionmateria = descripcionmateria;
       this.direccionpartida = direccionpartida;
       this.direccionllegada = direccionllegada;
       this.diasestimados = diasestimados;
       this.fechainicio = fechainicio;
       this.fechafin = fechafin;
    }

    public long getIddespacho() {
        return this.iddespacho;
    }
    
    public void setIddespacho(long iddespacho) {
        this.iddespacho = iddespacho;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ordencompra getOrdencompra() {
        return this.ordencompra;
    }
    
    public void setOrdencompra(Ordencompra ordencompra) {
        this.ordencompra = ordencompra;
    }

    public Long getIdestadodespacho() {
        return this.idestadodespacho;
    }
    
    public void setIdestadodespacho(Long idestadodespacho) {
        this.idestadodespacho = idestadodespacho;
    }

    public String getDescripcionmateria() {
        return this.descripcionmateria;
    }
    
    public void setDescripcionmateria(String descripcionmateria) {
        this.descripcionmateria = descripcionmateria;
    }

    public String getDireccionpartida() {
        return this.direccionpartida;
    }
    
    public void setDireccionpartida(String direccionpartida) {
        this.direccionpartida = direccionpartida;
    }

    public String getDireccionllegada() {
        return this.direccionllegada;
    }
    
    public void setDireccionllegada(String direccionllegada) {
        this.direccionllegada = direccionllegada;
    }

    public Long getDiasestimados() {
        return this.diasestimados;
    }
    
    public void setDiasestimados(Long diasestimados) {
        this.diasestimados = diasestimados;
    }

    public Date getFechainicio() {
        return this.fechainicio;
    }
    
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return this.fechafin;
    }
    
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }




}


