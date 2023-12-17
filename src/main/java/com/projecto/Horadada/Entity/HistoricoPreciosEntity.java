package com.projecto.Horadada.Entity;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "historicoPrecios")
public class HistoricoPreciosEntity {

    @Id
    @Column(name = "idhistoricoprecios", unique = true, nullable = false)
    private int idHistoricoPrecios;
    @Column(name = "destino", length = 50)
    private String destino;
    @Column(name = "longitudmetros")
    private Integer longitudMetros;
    @Column(name = "origen", length = 50)
    private String origen;
    @Column(name = "medida")
    private Integer medida;
    @Column(name = "precioigv", precision = 12)
    private BigDecimal precioIgv;
    @Column(name = "preciosubtotal", precision = 12)
    private BigDecimal precioSubTotal;
    @Column(name = "preciototal", precision = 12)
    private BigDecimal precioTotal;
    @Column(name = "idunidadmedida")
    private Integer idUnidadMedida;

}
