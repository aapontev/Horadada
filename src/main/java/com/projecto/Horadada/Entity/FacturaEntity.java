package com.projecto.Horadada.Entity;

import java.math.BigDecimal;
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
@Table(name = "factura")
public class FacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactura")
    private int idFactura;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    private ClienteEntity cliente;
    @Column(name = "correlativo")
    private Integer correlativo;
    @Column(name = "costostandby")
    private BigDecimal costoStandBy;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaemision")
    private Date fechaEmision;
    @Column(name = "guiaremision")
    private String guiaRemision;
    @Column(name = "iddespacho")
    private Integer idDespacho;
    @Column(name = "idmoneda")
    private Integer idMoneda;
    @Column(name = "igv")
    private Integer igv;
    @Column(name = "subtotal")
    private BigDecimal subTotal;
    @Column(name = "total")
    private Integer total;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaDetalleEntity> facturaDetalles;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValorizacionDetalleEntity> valorizacionDetalles;

}
