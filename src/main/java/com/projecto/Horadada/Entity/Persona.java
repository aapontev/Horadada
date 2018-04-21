package com.projecto.Horadada.Entity;
// Generated 02-mar-2018 16:56:03 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name="PERSONA"
    ,schema="HORADADA"
)
public class Persona  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private long idpersona;
     private String primernombre;
     private String segundonombre;
     private String primerapellido;
     private String segundoapellido;
     private int tipopersona;
     private Long codtipodocumento;
     private Long numerodocumento;
     private Date fechanacimiento;
     private String edad;
     private String direccion;
     private Date fechacreacion;
     private Date fechaupdate;
     private String telefono;
     private String correoelectronico;
     private Set<Transportista> transportistas = new HashSet<Transportista>(0);
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);
     private Set<Cliente> clientes = new HashSet<Cliente>(0);
     private Set<Telefonomonitoreo> telefonomonitoreos = new HashSet<Telefonomonitoreo>(0);

    public Persona() {
    }

	
    public Persona(long idpersona, int tipopersona) {
        this.idpersona = idpersona;
        this.tipopersona = tipopersona;
    }
    public Persona(long idpersona, String primernombre, String segundonombre, String primerapellido, String segundoapellido, int tipopersona, Long codtipodocumento, Long numerodocumento, Date fechanacimiento, String edad, String direccion, Date fechacreacion, Date fechaupdate, String telefono, String correoelectronico, Set<Transportista> transportistas, Set<Usuario> usuarios, Set<Cliente> clientes, Set<Telefonomonitoreo> telefonomonitoreos) {
       this.idpersona = idpersona;
       this.primernombre = primernombre;
       this.segundonombre = segundonombre;
       this.primerapellido = primerapellido;
       this.segundoapellido = segundoapellido;
       this.tipopersona = tipopersona;
       this.codtipodocumento = codtipodocumento;
       this.numerodocumento = numerodocumento;
       this.fechanacimiento = fechanacimiento;
       this.edad = edad;
       this.direccion = direccion;
       this.fechacreacion = fechacreacion;
       this.fechaupdate = fechaupdate;
       this.telefono = telefono;
       this.correoelectronico = correoelectronico;
       this.transportistas = transportistas;
       this.usuarios = usuarios;
       this.clientes = clientes;
       this.telefonomonitoreos = telefonomonitoreos;
    }
   
     @Id 

     @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="IDPERSONA", unique=true, nullable=false, precision=10, scale=0)
    public long getIdpersona() {
        return this.idpersona;
    }
    
    public void setIdpersona(long idpersona) {
        this.idpersona = idpersona;
    }

    
    @Column(name="PRIMERNOMBRE", length=25)
    public String getPrimernombre() {
        return this.primernombre;
    }
    
    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    
    @Column(name="SEGUNDONOMBRE", length=25)
    public String getSegundonombre() {
        return this.segundonombre;
    }
    
    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    
    @Column(name="PRIMERAPELLIDO", length=25)
    public String getPrimerapellido() {
        return this.primerapellido;
    }
    
    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    
    @Column(name="SEGUNDOAPELLIDO", length=25)
    public String getSegundoapellido() {
        return this.segundoapellido;
    }
    
    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    
    @Column(name="TIPOPERSONA", nullable=false, precision=5, scale=0)
    public int getTipopersona() {
        return this.tipopersona;
    }
    
    public void setTipopersona(int tipopersona) {
        this.tipopersona = tipopersona;
    }

    
    @Column(name="CODTIPODOCUMENTO", precision=10, scale=0)
    public Long getCodtipodocumento() {
        return this.codtipodocumento;
    }
    
    public void setCodtipodocumento(Long codtipodocumento) {
        this.codtipodocumento = codtipodocumento;
    }

    
    @Column(name="NUMERODOCUMENTO", precision=10, scale=0)
    public Long getNumerodocumento() {
        return this.numerodocumento;
    }
    
    public void setNumerodocumento(Long numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHANACIMIENTO", length=7)
    public Date getFechanacimiento() {
        return this.fechanacimiento;
    }
    
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    
    @Column(name="EDAD", length=2)
    public String getEdad() {
        return this.edad;
    }
    
    public void setEdad(String edad) {
        this.edad = edad;
    }

    
    @Column(name="DIRECCION", length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHACREACION", length=7)
    public Date getFechacreacion() {
        return this.fechacreacion;
    }
    
    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHAUPDATE", length=7)
    public Date getFechaupdate() {
        return this.fechaupdate;
    }
    
    public void setFechaupdate(Date fechaupdate) {
        this.fechaupdate = fechaupdate;
    }

    
    @Column(name="TELEFONO", length=20)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="CORREOELECTRONICO", length=60)
    public String getCorreoelectronico() {
        return this.correoelectronico;
    }
    
    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="persona")
    public Set<Transportista> getTransportistas() {
        return this.transportistas;
    }
    
    public void setTransportistas(Set<Transportista> transportistas) {
        this.transportistas = transportistas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="persona")
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="persona")
    public Set<Cliente> getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="persona")
    public Set<Telefonomonitoreo> getTelefonomonitoreos() {
        return this.telefonomonitoreos;
    }
    
    public void setTelefonomonitoreos(Set<Telefonomonitoreo> telefonomonitoreos) {
        this.telefonomonitoreos = telefonomonitoreos;
    }




}


