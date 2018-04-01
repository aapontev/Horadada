package com.projecto.Horadada.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TELEFONO")
public class Telefono {

	 @Id
	 @GeneratedValue
	 @Column(name = "id_Telefono", unique = true, nullable = false)
	 private int idTelefono;
	 
	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="IDPERSONA", nullable=false)
     private Persona persona;

	 @Column(name="CODTIPOTELEFONO")
     private Long codtipotelefono;
	 
	 @Column(name="CODOPERADOR")
     private Integer codoperador;

	 @Column(name="NUMEROTELEFONO")
     private String numerotelefono;

	 @Column(name="IMEI")
     private String imei;

    public Telefono() {
    }
       
    public Telefono(int idTelefono, Persona persona, Long codtipotelefono, Integer codoperador, String numerotelefono,
			String imei) {
		this.idTelefono = idTelefono;
		this.persona = persona;
		this.codtipotelefono = codtipotelefono;
		this.codoperador = codoperador;
		this.numerotelefono = numerotelefono;
		this.imei = imei;
	}



	public int getIdTelefono() {
	return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
	this.idTelefono = idTelefono;
    }
	  
    public Long getCodtipotelefono() {
        return this.codtipotelefono;
    }
    
    public void setCodtipotelefono(Long codtipotelefono) {
        this.codtipotelefono = codtipotelefono;
    }
    
    public Integer getCodoperador() {
        return this.codoperador;
    }
    
    public void setCodoperador(Integer codoperador) {
        this.codoperador = codoperador;
    }
    
    public String getNumerotelefono() {
        return this.numerotelefono;
    }
    
    public void setNumerotelefono(String numerotelefono) {
        this.numerotelefono = numerotelefono;
    }
    
    public String getImei() {
        return this.imei;
    }
    
    public void setImei(String imei) {
        this.imei = imei;
    }
    
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
        this.persona = persona;
    }


}


