package com.projecto.Horadada.Entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "ubicacionHist")
public class UbicacionHistEntity {

    @Id
    @Column(name = "idubicacionhist", unique = true, nullable = false)
    private int idUbicacionHist;
    @Column(name = "departamento", length = 15)
    private String departamento;
    @Column(name = "direccion", length = 45)
    private String direccion;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", length = 10)
    private Date fecha;
    @Column(name = "hora")
    private String hora;
    @Column(name = "idubicacion")
    private Integer idUbicacion;
    @Column(name = "idvehiculo")
    private Integer idVehiculo;
    @Column(name = "latitud", length = 20)
    private String latitud;
    @Column(name = "longitud", length = 20)
    private String longitud;
    @Column(name = "provincia", length = 15)
    private String provincia;

}
