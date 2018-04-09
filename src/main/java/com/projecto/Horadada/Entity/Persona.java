package com.projecto.Horadada.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PERSONA")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "mant_usuario",
								procedureName = "mant_persona.mant_usuario",
								parameters = {
										@StoredProcedureParameter(mode = ParameterMode.IN, name = "tip_per",type = String.class)
								})
})
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPERSONA", unique = true, nullable = false, precision = 10, scale = 0)
	private long idpersona;

	@Column(name = "PRIMERNOMBRE", length = 25)
	private String primernombre;

	@Column(name = "SEGUNDONOMBRE", length = 25)
	private String segundonombre;

	@Column(name = "PRIMERAPELLIDO", length = 25)
	private String primerapellido;

	@Column(name = "SEGUNDOAPELLIDO", length = 25)
	private String segundoapellido;

	@Column(name = "TIPOPERSONA", nullable = false, precision = 5, scale = 0)
	private String tipopersona;

	@Column(name = "CODTIPODOCUMENTO", precision = 10, scale = 0)
	private Long codtipodocumento;

	@Column(name = "NUMERODOCUMENTO", precision = 10, scale = 0)
	private Long numerodocumento;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHANACIMIENTO", length = 7)
	private Date fechanacimiento;

	@Column(name = "EDAD", length = 2)
	private String edad;

	@Column(name = "DIRECCION", length = 45)
	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHACREACION", length = 7)
	private Date fechacreacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAUPDATE", length = 7)
	private Date fechaupdate;

	@Column(name = "CORREOELECTRONICO", length = 60)
	private String correoelectronico;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "persona")
	private Set<Telefono> telefono = new HashSet<Telefono>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "persona")
	private Set<Usuario> usuario = new HashSet<Usuario>();
		
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "persona")
	private Set<Transportista> transportista = new HashSet<Transportista>(0);
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "persona")
	private Set<Cliente> cliente = new HashSet<Cliente>(0);
	 

	public Persona() {
	}
	

	public Persona(long idpersona, String primernombre, String segundonombre, String primerapellido,
			String segundoapellido, String tipopersona, Long codtipodocumento, Long numerodocumento, Date fechanacimiento,
			String edad, String direccion, Date fechacreacion, Date fechaupdate, String correoelectronico,
			Set<Telefono> telefono, Set<Usuario> usuario, Set<Transportista> transportista, Set<Cliente> cliente) {
		super();
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
		this.correoelectronico = correoelectronico;
		this.telefono = telefono;
		this.usuario = usuario;
		this.transportista = transportista;
		this.cliente = cliente;
	}


	public Persona(long idpersona, String primernombre, String segundonombre, String primerapellido,
			String segundoapellido, String tipopersona, Long codtipodocumento, Long numerodocumento, Date fechanacimiento,
			String edad, String direccion, Date fechacreacion, Date fechaupdate, String correoelectronico) {
		super();
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
		this.correoelectronico = correoelectronico;
	}

	public long getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}

	public String getPrimernombre() {
		return this.primernombre;
	}

	public void setPrimernombre(String primernombre) {
		this.primernombre = primernombre;
	}

	public String getSegundonombre() {
		return this.segundonombre;
	}

	public void setSegundonombre(String segundonombre) {
		this.segundonombre = segundonombre;
	}

	public String getPrimerapellido() {
		return this.primerapellido;
	}

	public void setPrimerapellido(String primerapellido) {
		this.primerapellido = primerapellido;
	}

	public String getSegundoapellido() {
		return this.segundoapellido;
	}

	public void setSegundoapellido(String segundoapellido) {
		this.segundoapellido = segundoapellido;
	}

	public String getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

	public Long getCodtipodocumento() {
		return this.codtipodocumento;
	}

	public void setCodtipodocumento(Long codtipodocumento) {
		this.codtipodocumento = codtipodocumento;
	}

	public Long getNumerodocumento() {
		return this.numerodocumento;
	}

	public void setNumerodocumento(Long numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getEdad() {
		return this.edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechaupdate() {
		return this.fechaupdate;
	}

	public void setFechaupdate(Date fechaupdate) {
		this.fechaupdate = fechaupdate;
	}

	public String getCorreoelectronico() {
		return this.correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	public Set<Telefono> getTelefono() {
		return telefono;
	}

	public void setTelefono(Set<Telefono> telefono) {
		this.telefono = telefono;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}


	public Set<Transportista> getTransportista() {
		return transportista;
	}


	public void setTransportista(Set<Transportista> transportista) {
		this.transportista = transportista;
	}

	public Set<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Set<Cliente> cliente) {
		this.cliente = cliente;
	}

}
