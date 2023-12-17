package com.projecto.Horadada.Entity;

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
@Table(name = "despacho")
public class DespachoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddespacho")
    private int idDespacho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idordencompra", referencedColumnName = "idordencompra")
    private OrdenCompraEntity idOrdenCompra;

    @Column(name = "descripcionmateria")
    private String descripcionMateria;

    @Column(name = "diasestimados")
    private Integer diasEstimados;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechafin")
    private Date fechaFin;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechainicio")
    private Date fechaInicio;

    @Column(name = "iddireccionllegada")
    private Integer idDireccionLlegada;

    @Column(name = "iddireccionpartida")
    private Integer idDireccionPartida;

    @Column(name = "idestadodespacho")
    private Integer idEstadoDespacho;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "despacho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DespachoXvehiculoEntity> despachoXVehiculos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "despacho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValorizacionDetalleEntity> valorizacionDetalles;
}
