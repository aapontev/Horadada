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
@Table(name = "cotizacion")
public class CotizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcotizacion", unique = true, nullable = false)
    private int idCotizacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsolicitud")
    private SolicitudEntity solicitud;
    @Column(name = "aprobado")
    private Integer aprobado;
    @Column(name = "cargos", precision = 12)
    private BigDecimal cargos;
    @Column(name = "descuentos", precision = 12)
    private BigDecimal descuentos;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaenvio", length = 10)
    private Date fechaEnvio;
    @Column(name = "idmoneda")
    private Integer idMoneda;
    @Column(name = "igv", precision = 12)
    private BigDecimal igv;
    @Column(name = "neto", precision = 12)
    private BigDecimal neto;
    @Column(name = "observaciones", length = 250)
    private String observaciones;
    @Column(name = "percepcion", precision = 12)
    private BigDecimal percepcion;
    @Column(name = "subtotal", precision = 12)
    private BigDecimal subTotal;
    @Column(name = "total", precision = 12)
    private BigDecimal total;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cotizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CotizacionDetalleEntity> cotizacionDetalles;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cotizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenCompraEntity> ordenCompras;

}
