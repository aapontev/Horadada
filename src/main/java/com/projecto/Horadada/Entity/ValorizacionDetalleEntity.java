package com.projecto.Horadada.Entity;

import java.math.BigDecimal;
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
@Table(name = "valorizacionDetalle")
public class ValorizacionDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvalorizaciondetalle")
    private int idValorizacionDetalle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddespacho")
    private DespachoEntity despacho;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfactura")
    private FacturaEntity factura;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idvalorizacion")
    private ValorizacionEntity valorizacion;
    @Column(name = "costostamby")
    private BigDecimal costoStamBy;
    @Column(name = "diasstamby")
    private Short diasStamby;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechacarga")
    private Date fechaCarga;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechadescarga")
    private Date fechaDescarga;
    @Column(name = "guiaanexada")
    private String guiaAnexada;
    @Column(name = "igv")
    private BigDecimal igv;
    @Column(name = "item")
    private Integer item;
    @Column(name = "neto")
    private BigDecimal neto;
    @Column(name = "nroguiatransporte")
    private String nroGuiaTransporte;
    @Column(name = "subTotal")
    private BigDecimal subTotal;
    @Column(name = "total")
    private BigDecimal total;

}
