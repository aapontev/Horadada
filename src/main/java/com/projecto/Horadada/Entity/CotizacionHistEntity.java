package com.projecto.Horadada.Entity;

import java.math.BigDecimal;
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
@Table(name = "cotizacionHist")
public class CotizacionHistEntity implements java.io.Serializable {

    @Id
    @Column(name = "idcotizacionhist", unique = true, nullable = false)
    private int idCotizacionHist;
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
    @Column(name = "idsolicitud")
    private Integer idSolicitud;
    @Column(name = "subtotal", precision = 12)
    private BigDecimal subTotal;
    @Column(name = "total", precision = 12)
    private BigDecimal total;

}
