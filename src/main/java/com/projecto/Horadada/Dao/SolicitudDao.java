package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.SolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("solicituddao")
public interface SolicitudDao extends JpaRepository<SolicitudEntity, Serializable> {

    public abstract SolicitudEntity findByidSolicitud(int idsolicitud);

    @Query(value = "select * from solicitud s where s.idsolicitud not in (select ch.idsolicitud from Cotizacionhist ch)", nativeQuery = true)///Solicitudes con Cotizacion sin aprobar
    public abstract List<SolicitudEntity> getidsolicitud();
}
