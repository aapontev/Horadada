package com.projecto.Horadada.Entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "ubicacion")
public class UbicacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idubicacion")
    private int idUbicacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idvehiculo")
    private VehiculoEntity vehiculo;
    @Column(name = "direccion")
    private String direccion;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "hora")
    private String hora;
    @Column(name = "iddespacho")
    private Integer idDespacho;
    @Column(name = "latitud")
    private String latitud;
    @Column(name = "longitud")
    private String longitud;

}
