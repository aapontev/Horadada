package com.projecto.Horadada.Entity;

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
import lombok.Data;

@Data
@Entity
@Table(name = "transportista")
public class TransportistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransportista")
    private int idTransportista;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpersona")
    private PersonaEntity persona;
    @Column(name = "catlicencia")
    private String catLicencia;
    @Column(name = "idsituaciontransportista")
    private Integer idSituacionTransportista;
    @Column(name = "nrolicencia")
    private String nroLicencia;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transportista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehiculoEntity> vehiculos;

}
