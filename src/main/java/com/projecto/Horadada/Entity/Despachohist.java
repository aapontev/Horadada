package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Despachohist generated by hbm2java
 */
@Entity
@Table(name="DESPACHOHIST"
    ,schema="HORADADA"
)
public class Despachohist  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private long iddespachohist;
     private long iddespacho;
     private long idordencompra;
     private long idtransportista;
     private String descripcionmateria;
     private String direccionpartida;
     private String direccionllegada;
     private Date fechacarga;
     private Date fechadescarga;
     private Long diasstandby;

    public Despachohist() {
    }

	
    public Despachohist(long iddespachohist, long iddespacho, long idordencompra, long idtransportista) {
        this.iddespachohist = iddespachohist;
        this.iddespacho = iddespacho;
        this.idordencompra = idordencompra;
        this.idtransportista = idtransportista;
    }
    public Despachohist(long iddespachohist, long iddespacho, long idordencompra, long idtransportista, String descripcionmateria, String direccionpartida, String direccionllegada, Date fechacarga, Date fechadescarga, Long diasstandby) {
       this.iddespachohist = iddespachohist;
       this.iddespacho = iddespacho;
       this.idordencompra = idordencompra;
       this.idtransportista = idtransportista;
       this.descripcionmateria = descripcionmateria;
       this.direccionpartida = direccionpartida;
       this.direccionllegada = direccionllegada;
       this.fechacarga = fechacarga;
       this.fechadescarga = fechadescarga;
       this.diasstandby = diasstandby;
    }
   
     @Id 

     @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="IDDESPACHOHIST", unique=true, nullable=false, precision=10, scale=0)
    public long getIddespachohist() {
        return this.iddespachohist;
    }
    
    public void setIddespachohist(long iddespachohist) {
        this.iddespachohist = iddespachohist;
    }

    
    @Column(name="IDDESPACHO", nullable=false, precision=10, scale=0)
    public long getIddespacho() {
        return this.iddespacho;
    }
    
    public void setIddespacho(long iddespacho) {
        this.iddespacho = iddespacho;
    }

    
    @Column(name="IDORDENCOMPRA", nullable=false, precision=10, scale=0)
    public long getIdordencompra() {
        return this.idordencompra;
    }
    
    public void setIdordencompra(long idordencompra) {
        this.idordencompra = idordencompra;
    }

    
    @Column(name="IDTRANSPORTISTA", nullable=false, precision=10, scale=0)
    public long getIdtransportista() {
        return this.idtransportista;
    }
    
    public void setIdtransportista(long idtransportista) {
        this.idtransportista = idtransportista;
    }

    
    @Column(name="DESCRIPCIONMATERIA", length=50)
    public String getDescripcionmateria() {
        return this.descripcionmateria;
    }
    
    public void setDescripcionmateria(String descripcionmateria) {
        this.descripcionmateria = descripcionmateria;
    }

    
    @Column(name="DIRECCIONPARTIDA", length=45)
    public String getDireccionpartida() {
        return this.direccionpartida;
    }
    
    public void setDireccionpartida(String direccionpartida) {
        this.direccionpartida = direccionpartida;
    }

    
    @Column(name="DIRECCIONLLEGADA", length=45)
    public String getDireccionllegada() {
        return this.direccionllegada;
    }
    
    public void setDireccionllegada(String direccionllegada) {
        this.direccionllegada = direccionllegada;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHACARGA", length=7)
    public Date getFechacarga() {
        return this.fechacarga;
    }
    
    public void setFechacarga(Date fechacarga) {
        this.fechacarga = fechacarga;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHADESCARGA", length=7)
    public Date getFechadescarga() {
        return this.fechadescarga;
    }
    
    public void setFechadescarga(Date fechadescarga) {
        this.fechadescarga = fechadescarga;
    }

    
    @Column(name="DIASSTANDBY", precision=10, scale=0)
    public Long getDiasstandby() {
        return this.diasstandby;
    }
    
    public void setDiasstandby(Long diasstandby) {
        this.diasstandby = diasstandby;
    }




}


