package com.projecto.Horadada.Entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DESPACHOXVEHICULO")
public class Despachoxvehiculo {

	@Id 
	@GeneratedValue
	 @Column(name = "id_despacho_x_vehiculo", unique = true, nullable = false)	
	private int iddespachoxvehiculo;
	
    @Column(name="IDTRANSPORTISTA", nullable=false, precision=10, scale=0)
     private long idtransportista;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHACARGA", length=7)
     private Date fechacarga;

    @Temporal(TemporalType.DATE)
    @Column(name="FECHADESCARGA", length=7)
     private Date fechadescarga;
    
    @Column(name="HORACARGA")
     private Serializable horacarga;
    
    @Column(name="HORADESCARGA")
     private Serializable horadescarga;

    public Despachoxvehiculo() {
    }

	
    public Despachoxvehiculo(int iddespachoxvehiculo, long idtransportista) {
        this.iddespachoxvehiculo = iddespachoxvehiculo;
        this.idtransportista = idtransportista;
    }
    public Despachoxvehiculo(int iddespachoxvehiculo, long idtransportista, Date fechacarga, Date fechadescarga, Serializable horacarga, Serializable horadescarga) {
       this.iddespachoxvehiculo = iddespachoxvehiculo;
       this.idtransportista = idtransportista;
       this.fechacarga = fechacarga;
       this.fechadescarga = fechadescarga;
       this.horacarga = horacarga;
       this.horadescarga = horadescarga;
    }
      public int getIddespachoxvehiculo() {
        return this.iddespachoxvehiculo;
    }
    
    public void setIddespachoxvehiculo(int iddespachoxvehiculo) {
        this.iddespachoxvehiculo = iddespachoxvehiculo;
    }
    
    public long getIdtransportista() {
        return this.idtransportista;
    }
    
    public void setIdtransportista(long idtransportista) {
        this.idtransportista = idtransportista;
    }

    public Date getFechacarga() {
        return this.fechacarga;
    }
    
    public void setFechacarga(Date fechacarga) {
        this.fechacarga = fechacarga;
    }

    public Date getFechadescarga() {
        return this.fechadescarga;
    }
    
    public void setFechadescarga(Date fechadescarga) {
        this.fechadescarga = fechadescarga;
    }

    public Serializable getHoracarga() {
        return this.horacarga;
    }
    
    public void setHoracarga(Serializable horacarga) {
        this.horacarga = horacarga;
    }

    public Serializable getHoradescarga() {
        return this.horadescarga;
    }
    
    public void setHoradescarga(Serializable horadescarga) {
        this.horadescarga = horadescarga;
    }




}


