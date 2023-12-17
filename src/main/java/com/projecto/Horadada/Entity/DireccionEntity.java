package com.projecto.Horadada.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "direccion")
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddireccion", unique = true, nullable = false)
    private int idDireccion;
    @Column(name = "calle", length = 100)
    private String calle;
    @Column(name = "latitud", nullable = false, length = 20)
    private String latitud;
    @Column(name = "longitud", nullable = false, length = 20)
    private String longitud;
    @Column(name = "nombredireccion", nullable = false, length = 20)
    private String nombreDireccion;

}
