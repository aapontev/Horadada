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
@Table(name = "despachoHist"
)
public class DespachoHistEntity {

    @Id
    @Column(name = "iddespachohist", unique = true, nullable = false)
    private int idDespachoHist;
    @Column(name = "descripcionmateria", length = 50)
    private String descripcionMateria;
    @Column(name = "diasstandby")
    private Integer diasStandBy;
    @Column(name = "direccionllegada", length = 65)
    private String direccionLlegada;
    @Column(name = "direccionpartida", length = 65)
    private String direccionPartida;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechacarga", length = 10)
    private Date fechaCarga;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechadescarga", length = 10)
    private Date fechaDescarga;
    @Column(name = "iddespacho", nullable = false)
    private int idDespacho;
    @Column(name = "idordencompra", nullable = false)
    private int idOrdenCompra;
    @Column(name = "idtransportista", nullable = false)
    private int idTransportista;

}
