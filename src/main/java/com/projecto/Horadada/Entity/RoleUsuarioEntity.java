package com.projecto.Horadada.Entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "roleusuario")
public class RoleUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idroleusuario", unique = true, nullable = false)
    private int idRoleUsuario;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechacreacion", length = 10)
    private Date fechaCreacion;
    @Column(name = "nombrerol", length = 25)
    private String nombreRol;

}
