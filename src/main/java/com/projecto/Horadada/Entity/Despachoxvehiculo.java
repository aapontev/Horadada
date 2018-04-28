package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Despachoxvehiculo generated by hbm2java
 */
@Entity
@Table(name="DESPACHOXVEHICULO"
    ,schema="HORADADA"
)
public class Despachoxvehiculo  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private DespachoxvehiculoId id;
     private long idtransportista;
     private Date fechacarga;
     private Date fechadescarga;
     private Serializable horacarga;
     private Serializable horadescarga;

    public Despachoxvehiculo() {
    }

	
    public Despachoxvehiculo(DespachoxvehiculoId id, long idtransportista) {
        this.id = id;
        this.idtransportista = idtransportista;
    }
    public Despachoxvehiculo(DespachoxvehiculoId id, long idtransportista, Date fechacarga, Date fechadescarga, Serializable horacarga, Serializable horadescarga) {
       this.id = id;
       this.idtransportista = idtransportista;
       this.fechacarga = fechacarga;
       this.fechadescarga = fechadescarga;
       this.horacarga = horacarga;
       this.horadescarga = horadescarga;
    }
   
     @EmbeddedId

     @GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "despacho_vehiculo_seq") @SequenceGenerator ( 
 		    name = "despacho_vehiculo_seq" , 
 		    sequenceName = "despacho_vehiculo_sequence" , 
 		    allocationSize = 1 )
    @AttributeOverrides( {
        @AttributeOverride(name="iddespachoxvehiculo", column=@Column(name="IDDESPACHOXVEHICULO", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="iddespacho", column=@Column(name="IDDESPACHO", nullable=false, precision=10, scale=0) ) } )
    public DespachoxvehiculoId getId() {
        return this.id;
    }
    
    public void setId(DespachoxvehiculoId id) {
        this.id = id;
    }

    
    @Column(name="IDTRANSPORTISTA", nullable=false, precision=10, scale=0)
    public long getIdtransportista() {
        return this.idtransportista;
    }
    
    public void setIdtransportista(long idtransportista) {
        this.idtransportista = idtransportista;
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

    
    @Column(name="HORACARGA")
    public Serializable getHoracarga() {
        return this.horacarga;
    }
    
    public void setHoracarga(Serializable horacarga) {
        this.horacarga = horacarga;
    }

    
    @Column(name="HORADESCARGA")
    public Serializable getHoradescarga() {
        return this.horadescarga;
    }
    
    public void setHoradescarga(Serializable horadescarga) {
        this.horadescarga = horadescarga;
    }




}


