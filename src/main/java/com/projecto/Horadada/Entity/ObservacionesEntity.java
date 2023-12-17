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
@Table(name = "observaciones"
)
public class ObservacionesEntity {

    @Id
    @Column(name = "idobservaciones", unique = true, nullable = false)
    private int idObservaciones;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaingreso", length = 10)
    private Date fechaIngreso;
    @Column(name = "iddespacho", nullable = false)
    private int idDespacho;
    @Column(name = "observaciondetalle", length = 200)
    private String observacionDetalle;

}
