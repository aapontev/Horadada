package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ValorizaciondetalleId generated by hbm2java
 */
@Embeddable
public class ValorizaciondetalleId  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private int idvalorizaciondetalle;
     private int idvalorizacion;

    public ValorizaciondetalleId() {
    }

    public ValorizaciondetalleId(int idvalorizaciondetalle, int idvalorizacion) {
       this.idvalorizaciondetalle = idvalorizaciondetalle;
       this.idvalorizacion = idvalorizacion;
    }
   


    @Column(name="IDVALORIZACIONDETALLE", nullable=false, precision=5, scale=0)
    public int getIdvalorizaciondetalle() {
        return this.idvalorizaciondetalle;
    }
    
    public void setIdvalorizaciondetalle(int idvalorizaciondetalle) {
        this.idvalorizaciondetalle = idvalorizaciondetalle;
    }


    @Column(name="IDVALORIZACION", nullable=false, precision=5, scale=0)
    public int getIdvalorizacion() {
        return this.idvalorizacion;
    }
    
    public void setIdvalorizacion(int idvalorizacion) {
        this.idvalorizacion = idvalorizacion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ValorizaciondetalleId) ) return false;
		 ValorizaciondetalleId castOther = ( ValorizaciondetalleId ) other; 
         
		 return (this.getIdvalorizaciondetalle()==castOther.getIdvalorizaciondetalle())
 && (this.getIdvalorizacion()==castOther.getIdvalorizacion());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdvalorizaciondetalle();
         result = 37 * result + this.getIdvalorizacion();
         return result;
   }   


}


