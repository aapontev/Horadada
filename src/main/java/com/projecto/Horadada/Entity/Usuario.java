package com.projecto.Horadada.Entity;
// Generated 07-may-2018 22:17:41 by Hibernate Tools 4.3.1


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
import javax.persistence.UniqueConstraint;


/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="USUARIO"
    ,schema="HORADADA"
    , uniqueConstraints = @UniqueConstraint(columnNames="USUARIO") 
)
public class Usuario  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
   /*  @Id    
    @Column(name="IDUSUARIO", unique=true, nullable=false, precision=10, scale=0)
	private long idusuario;*/

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDPERSONA", nullable=false)
     private Persona persona;	 
    @Id
    @Column(name="NOMBREUSUARIO", unique=true, nullable=false, precision=10, scale=0, length=45)
     private String nombreUsuario;	 
    
    @Column(name="CONTRASENA")
     private String contrasena;
    
    @Column(name="FECHAUPDATE", length=45)
     private String fechaupdate;

    @Column(name="ESTADO", precision=5, scale=0)
     private Boolean estado;
	 
	@OneToMany(fetch = FetchType.EAGER, mappedBy="usuario")
     private Set<RoleUsuario> roleUsuario = new HashSet<RoleUsuario>();

    public Usuario() {
    }

	
    public Usuario(Persona persona) {
        this.persona = persona;
    }
    public Usuario(Set<RoleUsuario> roleUsuario, Persona persona, String nombreUsuario, String contrasena, String fechaupdate, Boolean estado) {
     
       this.persona = persona;
       this.nombreUsuario = nombreUsuario;
       this.contrasena = contrasena;
       this.fechaupdate = fechaupdate;
       this.estado = estado;
       this.roleUsuario = roleUsuario;
    }
   
    /*public long getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }
*/

    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaupdate() {
        return this.fechaupdate;
    }
    
    public void setFechaupdate(String fechaupdate) {
        this.fechaupdate = fechaupdate;
    }
	
	public Boolean isEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<RoleUsuario> getRoleUsuario() {
		return roleUsuario;
	}


	public void setRoleUsuario(Set<RoleUsuario> roleUsuario) {
		this.roleUsuario = roleUsuario;
	}




    






}


