package com.projecto.Horadada.Entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @Column(name = "nombreusuario")
    private String nombreUsuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpersona", nullable = false)
    private PersonaEntity persona;
    @Column(name = "contrasena", length = 60)
    private String contrasena;
    @Column(name = "estado")
    private Boolean estado;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaupdate", length = 10)
    private Date fechaUpdate;
    @OneToOne
    @JoinColumn(name = "IDROLEUSUARIO", updatable = false, nullable = false)
    private RoleUsuarioEntity idroleusuario;

}
