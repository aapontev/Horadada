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
@Table(name = "vehiculo")
public class VehiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehiculo")
    private int idVehiculo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtransportista")
    private TransportistaEntity transportista;
    @Column(name = "color")
    private String color;
    @Column(name = "detalles")
    private String detalles;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaultimarevision")
    private Date fechaUltimaRevision;
    @Column(name = "idaseguradora")
    private Integer idAseguradora;
    @Column(name = "idmarca")
    private Integer idMarca;
    @Column(name = "idmodelo")
    private Integer idModelo;
    @Column(name = "nroejes")
    private Integer nroEjes;
    @Column(name = "pesomaximo")
    private BigDecimal pesoMaximo;
    @Column(name = "pesovehiculo")
    private BigDecimal pesoVehiculo;
    @Column(name = "placa")
    private String placa;
    @Column(name = "tarjetacirculacion")
    private String tarjetaCirculacion;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UbicacionEntity> ubicacions;

}
