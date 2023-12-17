package com.projecto.Horadada.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.SolicitudEntity;

public interface SolicitudService {

    public abstract List<SolicitudEntity> findByAll();

    public abstract SolicitudEntity save(SolicitudEntity solicitud);

    public abstract void delete(int idsolitud);

    public abstract SolicitudEntity findByidsolicitud(int idsolicitud);

    public abstract List<SolicitudEntity> getidsolicitud();

    public Page<SolicitudEntity> findAll(Pageable pageable);
}
