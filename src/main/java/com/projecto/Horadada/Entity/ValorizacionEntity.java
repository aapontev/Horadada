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
@Table(name = "valorizacion")
public class ValorizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvalorizacion")
    private int idValorizacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    private ClienteEntity cliente;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "idmoneda")
    private Short idMoneda;
    @Column(name = "igv")
    private BigDecimal igv;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "subtotal")
    private BigDecimal subTotal;
    @Column(name = "total")
    private BigDecimal total;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "valorizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValorizacionDetalleEntity> valorizacionDetalles;

}
