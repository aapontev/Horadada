package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ROLEUSUARIO",schema="HORADADA")
public class RoleUsuario implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idrole;
    private Usuario usuario;
    private String nombrerol;

   public RoleUsuario() {
   }

	
   public RoleUsuario(BigDecimal idrole, Usuario usuario) {
       this.idrole = idrole;
       this.usuario = usuario;
   }
   public RoleUsuario(BigDecimal idrole, Usuario usuario, String nombrerol) {
      this.idrole = idrole;
      this.usuario = usuario;
      this.nombrerol = nombrerol;
   }
  
  
   
   @Column(name="IDROLE", unique=true, nullable=false, scale=0)
   public BigDecimal getIdrole() {
       return this.idrole;
   }
   
   public void setIdrole(BigDecimal idrole) {
       this.idrole = idrole;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumns( { 
       @JoinColumn(name="IDUSUARIO", referencedColumnName="IDPERSONA", nullable=false), 
       @JoinColumn(name="IDPERSONA", referencedColumnName="IDUSUARIO", nullable=false) } )
   public Usuario getUsuario() {
       return this.usuario;
   }
   
   public void setUsuario(Usuario usuario) {
       this.usuario = usuario;
   }
   
   @Id 

   
   @Column(name="NOMBREROL", length=15)
   public String getNombrerol() {
       return this.nombrerol;
   }
   
   public void setNombrerol(String nombrerol) {
       this.nombrerol = nombrerol;
   }




	
	
}
