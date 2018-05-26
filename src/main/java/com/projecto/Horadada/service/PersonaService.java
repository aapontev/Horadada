package com.projecto.Horadada.service;

import java.util.List;

import com.projecto.Horadada.Entity.Persona;

public interface PersonaService {

	public abstract List<Persona> findByTipopersona(int id);
	public abstract Persona findByidPersona(int id);
	public abstract Persona save(Persona persona);
	public abstract List<Persona> findByall();
}
