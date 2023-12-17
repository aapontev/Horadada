package com.projecto.Horadada.Entity;

import java.math.BigDecimal;
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
@Table(name = "facturaDetalle")
public class FacturaDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfacturadetalle")
    private int idFacturaDetalle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfactura")
    private FacturaEntity factura;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "preciounitario")
    private BigDecimal precioUnitario;
    @Column(name = "valorventa")
    private BigDecimal valorVenta;

}
