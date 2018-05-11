package com.projecto.Horadada.service;

import java.util.List;

import com.projecto.Horadada.Entity.Tablamaestra;

public interface TablaMaestraService {

	public abstract List<Tablamaestra> findByIdtablamaestra(String idTabla);
	public abstract List<String> getdescripcion();
}
