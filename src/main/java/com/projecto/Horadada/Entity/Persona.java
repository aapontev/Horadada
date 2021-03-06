package com.projecto.Horadada.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PERSONA", schema = "HORADADA")
@NamedStoredProcedureQuery(name = "cambiaPersona", procedureName = "mant_persona.mant_usuario", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "v_tipopersona", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "v_idpersona", type = Integer.class) })
public class Persona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
	@SequenceGenerator(name = "persona_seq", sequenceName = "persona_sequence", allocationSize = 1)
	@Column(name = "IDPERSONA", unique = true, nullable = false, precision = 3)
	private int idpersona;

	@Column(name = "NOMBRECOMPLETO", length = 80)
	private String nombrecompleto;

	@Column(name = "PRIMERNOMBRE", length = 20)
	private String primernombre;

	@Column(name = "SEGUNDONOMBRE", length = 20)
	private String segundonombre;

	@Column(name = "PRIMERAPELLIDO", length = 20)
	private String primerapellido;

	@Column(name = "SEGUNDOAPELLIDO", length = 20)
	private String segundoapellido;

	@Column(name = "TIPOPERSONA", nullable = false, precision = 3)
	private int tipopersona;

	@Column(name = "CODTIPODOCUMENTO", precision = 3)
	private int codtipodocumento;

	@Column(name = "NUMERODOCUMENTO", precision = 3)
	private int numerodocumento;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHANACIMIENTO")
	private Date fechanacimiento;

	@Column(name = "EDAD", length = 2)
	private String edad;

	@Column(name = "DIRECCION", length = 60)
	private String direccion;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHACREACION")
	private Date fechacreacion;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAUPDATE")
	private Date fechaupdate;

	@Column(name = "CORREOELECTRONICO", length = 60)
	private String correoelectronico;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Transportista> transportistas;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Usuario> usuarios;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Contacto> contacto;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDPERSONA")
	private List<Telefono> telefonomonitoreos;

	@PrePersist
	private void prepersist() {
		fechacreacion = new Date();
	}

	public Persona() {
	}

	public Persona(int idpersona, int tipopersona) {
		this.idpersona = idpersona;
		this.tipopersona = tipopersona;
	}

	public Persona(int idpersona, String nombrecompleto, String primernombre, String segundonombre,
			String primerapellido, String segundoapellido, int tipopersona, int codtipodocumento, int numerodocumento,
			Date fechanacimiento, String edad, String direccion, Date fechacreacion, Date fechaupdate,
			String correoelectronico, List<Transportista> transportistas, List<Usuario> usuarios,
			List<Contacto> contacto, List<Telefono> telefonomonitoreos) {
		this.idpersona = idpersona;
		this.nombrecompleto = nombrecompleto;
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
		this.transportistas = transportistas;
		this.usuarios = usuarios;
		this.contacto = contacto;
		this.telefonomonitoreos = telefonomonitoreos;
	}

	public int getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
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

	public int getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(int tipopersona) {
		this.tipopersona = tipopersona;
	}

	public int getCodtipodocumento() {
		return this.codtipodocumento;
	}

	public void setCodtipodocumento(int codtipodocumento) {
		this.codtipodocumento = codtipodocumento;
	}

	public int getNumerodocumento() {
		return this.numerodocumento;
	}

	public void setNumerodocumento(int numerodocumento) {
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

	public List<Transportista> getTransportistas() {
		return this.transportistas;
	}

	public void setTransportistas(List<Transportista> transportistas) {
		this.transportistas = transportistas;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Contacto> getContacto() {
		return this.contacto;
	}

	public void setContacto(List<Contacto> contacto) {
		this.contacto = contacto;
	}

	public List<Telefono> getTelefonomonitoreos() {
		return this.telefonomonitoreos;
	}

	public void setTelefonomonitoreos(List<Telefono> telefonomonitoreos) {
		this.telefonomonitoreos = telefonomonitoreos;
	}

	private static final long serialVersionUID = 1L;
}