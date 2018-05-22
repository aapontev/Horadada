package com.projecto.Horadada.service;

import java.util.List;

import com.projecto.Horadada.Entity.Solicitud;

public interface SolicitudService {

	public abstract List<Solicitud> findByAll();
	public abstract Solicitud save(Solicitud solicitud);
	public abstract void delete(int idsolitud);
	public abstract Solicitud findByidsolicitud(int idsolicitud);
	public abstract List<Solicitud> getidsolicitud();
}
