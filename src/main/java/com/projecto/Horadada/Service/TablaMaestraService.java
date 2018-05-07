package com.projecto.Horadada.Service;

import java.util.List;

import com.projecto.Horadada.Entity.Tablamaestra;

public interface TablaMaestraService {
	
	public abstract List<Tablamaestra> findAll();
	public abstract Tablamaestra findByIdtablamaestra(String idtablamaestra);
	
}
