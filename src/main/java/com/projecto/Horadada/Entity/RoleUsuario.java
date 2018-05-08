package com.projecto.Horadada.Entity;
// Generated 07-may-2018 22:17:41 by Hibernate Tools 4.3.1


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
 * Roleusuario generated by hbm2java
 */
@Entity
@Table(name="ROLEUSUARIO"
    ,schema="HORADADA"
)
public class RoleUsuario  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idroleusuario;
     private Usuario usuario;
     private String nombrerol;
     private Date fechacreacion;

    public RoleUsuario() {
    }

	
    public RoleUsuario(long idroleusuario) {
        this.idroleusuario = idroleusuario;
    }
    public RoleUsuario(long idroleusuario, Usuario usuario, String nombrerol, Date fechacreacion) {
       this.idroleusuario = idroleusuario;
       this.usuario = usuario;
       this.nombrerol = nombrerol;
       this.fechacreacion = fechacreacion;
    }
   
     @Id 

    
    @Column(name="IDROLEUSUARIO", unique=true, nullable=false, precision=10, scale=0)
    public long getIdroleusuario() {
        return this.idroleusuario;
    }
    
    public void setIdroleusuario(long idroleusuario) {
        this.idroleusuario = idroleusuario;
    }

    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", nullable = false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="NOMBREROL", length=25)
    public String getNombrerol() {
        return this.nombrerol;
    }
    
    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHACREACION", length=7)
    public Date getFechacreacion() {
        return this.fechacreacion;
    }
    
    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }




}


