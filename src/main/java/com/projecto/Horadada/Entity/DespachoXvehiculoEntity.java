package com.projecto.Horadada.Entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "despachoXVehiculo")
public class DespachoXvehiculoEntity {

    @Id
    @Column(name = "iddespachoxvehiculo", unique = true, nullable = false)
    private int idDespachoXVehiculo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddespacho")
    private DespachoEntity despacho;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechacarga", length = 10)
    private Date fechaCarga;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechadescarga", length = 10)
    private Date fechaDescarga;
    @Column(name = "horacarga")
    private String horaCarga;
    @Column(name = "horadescarga")
    private String horaDescarga;
    @Column(name = "idtransportista", nullable = false)
    private int idTransportista;

}
