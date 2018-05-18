package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Solicitud;

@Repository("solicituddao")
public interface SolicitudDao extends JpaRepository<Solicitud, Serializable>{

	public abstract Solicitud findByidsolicitud(int idsolicitud);
}
