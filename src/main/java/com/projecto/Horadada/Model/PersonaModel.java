package com.projecto.Horadada.Model;

import java.util.Date;
import lombok.Data;

@Data
public class PersonaModel {
    
    private int idPersona;
    private Integer codTipoDocumento;
    private String correoElectronico;
    private String direccion;
    private Integer edad;
    private Date fechaCreacion;
    private Date fechaUpdate;
    private String nombreCompleto;
    private Integer numeroDocumento;
    private String primerApellido;
    private String primerNombre;
    private String segundoApellido;
    private String segundoNombre;
    private int tipoPersona;
    private String fechaNacimiento;
    private int idTelefono;
    private String numeroTelefono;
    private int operador;
    private int tipoTelefono;
    private int catLicencia;
    private String nroLicencia;
    private int idSituacionTransportista;
    private int idCliente;
}
