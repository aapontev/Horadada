package com.projecto.Horadada.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "telefonomonitoreo")
public class TelefonoMonitoreoEntity {

    @Id
    @Column(name = "idtelefono")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTelefono;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpersona")
    private PersonaEntity persona;
    @Column(name = "idoperador")
    private Integer idOperador;
    @Column(name = "idtipotelefono")
    private Integer idTipoTelefono;
    @Column(name = "imei")
    private String imei;
    @Column(name = "numerotelefono")
    private String numeroTelefono;

}
