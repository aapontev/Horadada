package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TelefonomonitoreoId generated by hbm2java
 */
@Embeddable
public class TelefonomonitoreoId  implements java.io.Serializable {


     private long idtelefono;
     private long idpersona;

    public TelefonomonitoreoId() {
    }

    public TelefonomonitoreoId(long idtelefono, long idpersona) {
       this.idtelefono = idtelefono;
       this.idpersona = idpersona;
    }
   


    @Column(name="IDTELEFONO", nullable=false, precision=10, scale=0)
    public long getIdtelefono() {
        return this.idtelefono;
    }
    
    public void setIdtelefono(long idtelefono) {
        this.idtelefono = idtelefono;
    }


    @Column(name="IDPERSONA", nullable=false, precision=10, scale=0)
    public long getIdpersona() {
        return this.idpersona;
    }
    
    public void setIdpersona(long idpersona) {
        this.idpersona = idpersona;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TelefonomonitoreoId) ) return false;
		 TelefonomonitoreoId castOther = ( TelefonomonitoreoId ) other; 
         
		 return (this.getIdtelefono()==castOther.getIdtelefono())
 && (this.getIdpersona()==castOther.getIdpersona());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdtelefono();
         result = 37 * result + (int) this.getIdpersona();
         return result;
   }   


}


