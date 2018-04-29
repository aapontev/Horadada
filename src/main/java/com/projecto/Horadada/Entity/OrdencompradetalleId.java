package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrdencompradetalleId generated by hbm2java
 */
@Embeddable
public class OrdencompradetalleId  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private long idordencompradetalle;
     private long idordencompra;

    public OrdencompradetalleId() {
    }

    public OrdencompradetalleId(long idordencompradetalle, long idordencompra) {
       this.idordencompradetalle = idordencompradetalle;
       this.idordencompra = idordencompra;
    }
   


    @Column(name="IDORDENCOMPRADETALLE", nullable=false, precision=10, scale=0)
    public long getIdordencompradetalle() {
        return this.idordencompradetalle;
    }
    
    public void setIdordencompradetalle(long idordencompradetalle) {
        this.idordencompradetalle = idordencompradetalle;
    }


    @Column(name="IDORDENCOMPRA", nullable=false, precision=10, scale=0)
    public long getIdordencompra() {
        return this.idordencompra;
    }
    
    public void setIdordencompra(long idordencompra) {
        this.idordencompra = idordencompra;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OrdencompradetalleId) ) return false;
		 OrdencompradetalleId castOther = ( OrdencompradetalleId ) other; 
         
		 return (this.getIdordencompradetalle()==castOther.getIdordencompradetalle())
 && (this.getIdordencompra()==castOther.getIdordencompra());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdordencompradetalle();
         result = 37 * result + (int) this.getIdordencompra();
         return result;
   }   


}

