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
@Table(name = "cotizaciondetalle")
public class CotizacionDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcotizaciondetalle")
    private int idCotizacionDetalle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcotizacion")
    private CotizacionEntity cotizacion;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "ccostos")
    private String ccostos;
    @Column(name = "codrecurso")
    private String codRecurso;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "descuento")
    private Double descuento;
    @Column(name = "idunidadmedida")
    private Integer idUnidadMedida;
    @Column(name = "item")
    private Integer item;
    @Column(name = "preciounitario")
    private Double precioUnitario;
    @Column(name = "totaldetalle")
    private Double totalDetalle;

}
