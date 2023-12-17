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
@Table(name = "tablamaestra")
public class TablaMaestraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idregistro")
    private int idRegistro;
    @Column(name = "clave1")
    private String clave1;
    @Column(name = "clave2")
    private String clave2;
    @Column(name = "clave3")
    private String clave3;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechacreacion")
    private Date fechaCreacion;
    @Column(name = "idtablamaestra")
    private String idTablaMaestra;
    @Column(name = "valor1")
    private String valor1;
    @Column(name = "valor2")
    private String valor2;
    @Column(name = "valor3")
    private String valor3;
    @Column(name = "descripcion")
    private String descripcion;
    
}
