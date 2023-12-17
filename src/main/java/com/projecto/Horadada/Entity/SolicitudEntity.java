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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "solicitud")
public class SolicitudEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsolicitud")
    private int idSolicitud;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    private ClienteEntity cliente;
    @Column(name = "estado")
    private Integer estado;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecharecepcion")
    private Date fechaRecepcion;
    @Column(name = "requerimiento")
    private String requerimiento;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CotizacionEntity> cotizacions;

}
