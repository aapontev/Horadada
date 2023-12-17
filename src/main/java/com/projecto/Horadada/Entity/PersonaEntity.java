package com.projecto.Horadada.Entity;

import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private int idPersona;
    @Column(name = "codtipodocumento")
    private Integer codTipoDocumento;
    @Column(name = "correoelectronico")
    private String correoElectronico;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "edad")
    private Integer edad;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechacreacion")
    private Date fechaCreacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechanacimiento")
    private Date fechaNacimiento;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaupdate")
    private Date fechaUpdate;
    @Column(name = "nombrecompleto")
    private String nombreCompleto;
    @Column(name = "numerodocumento")
    private Integer numeroDocumento;
    @Column(name = "primerapellido")
    private String primerApellido;
    @Column(name = "primernombre")
    private String primerNombre;
    @Column(name = "segundoapellido")
    private String segundoApellido;
    @Column(name = "segundonombre")
    private String segundoNombre;
    @Column(name = "tipopersona")
    private int tipoPersona;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private List<TelefonoMonitoreoEntity> telefonoMonitoreos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private List<TransportistaEntity> transportistas;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private List<ContactoEntity> contactos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private List<UsuarioEntity> usuarios;

}
