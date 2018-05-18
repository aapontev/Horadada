package com.projecto.Horadada.service;

import com.projecto.Horadada.Entity.Ubicacion;

public interface UbicacionService {

	public abstract Ubicacion getUbicacion(int iddespacho,int idtransportista);
	public abstract Ubicacion getUbicacionOne();
}
