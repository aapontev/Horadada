package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Telefonomonitoreo generated by hbm2java
 */
@Entity
@Table(name="TELEFONOMONITOREO"
    ,schema="HORADADA"
)
public class Telefonomonitoreo  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private TelefonomonitoreoId id;
     private Persona persona;
     private Long idtipotelefono;
     private Integer idoperador;
     private String numerotelefono;
     private String imei;

    public Telefonomonitoreo() {
    }

	
    public Telefonomonitoreo(TelefonomonitoreoId id, Persona persona) {
        this.id = id;
        this.persona = persona;
    }
    public Telefonomonitoreo(TelefonomonitoreoId id, Persona persona, Long idtipotelefono, Integer idoperador, String numerotelefono, String imei) {
       this.id = id;
       this.persona = persona;
       this.idtipotelefono = idtipotelefono;
       this.idoperador = idoperador;
       this.numerotelefono = numerotelefono;
       this.imei = imei;
    }
   
     @EmbeddedId

     @GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "telefono_monitoreo_seq") @SequenceGenerator ( 
 		    name = "telefono_monitoreo_seq" , 
 		    sequenceName = "telefono_monitoreo_sequence" , 
 		    allocationSize = 1 )
    @AttributeOverrides( {
        @AttributeOverride(name="idtelefono", column=@Column(name="IDTELEFONO", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="idpersona", column=@Column(name="IDPERSONA", nullable=false, precision=10, scale=0) ) } )
    public TelefonomonitoreoId getId() {
        return this.id;
    }
    
    public void setId(TelefonomonitoreoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDPERSONA", nullable=false, insertable=false, updatable=false)
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    @Column(name="IDTIPOTELEFONO", precision=10, scale=0)
    public Long getIdtipotelefono() {
        return this.idtipotelefono;
    }
    
    public void setIdtipotelefono(Long idtipotelefono) {
        this.idtipotelefono = idtipotelefono;
    }

    
    @Column(name="IDOPERADOR", precision=5, scale=0)
    public Integer getIdoperador() {
        return this.idoperador;
    }
    
    public void setIdoperador(Integer idoperador) {
        this.idoperador = idoperador;
    }

    
    @Column(name="NUMEROTELEFONO", length=18)
    public String getNumerotelefono() {
        return this.numerotelefono;
    }
    
    public void setNumerotelefono(String numerotelefono) {
        this.numerotelefono = numerotelefono;
    }

    
    @Column(name="IMEI", length=20)
    public String getImei() {
        return this.imei;
    }
    
    public void setImei(String imei) {
        this.imei = imei;
    }




}


