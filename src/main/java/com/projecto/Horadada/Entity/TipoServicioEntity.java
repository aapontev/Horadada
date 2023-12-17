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
@Table(name = "tiposervicio")
public class TipoServicioEntity {

    @Id
    @Column(name = "idservicio", unique = true, nullable = false)
    private int idServicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaingreso", length = 10)
    private Date fechaIngreso;
    @Column(name = "nombreservicio", length = 50)
    private String nombreServicio;

}
