package com.projecto.Horadada.service;

import java.util.List;

import com.projecto.Horadada.Entity.Persona;

public interface PersonaService {

	public abstract List<Persona> findByTipopersona(int id);
	public abstract Persona findByidPersona(int id);
	public abstract Persona save(Persona persona);
	public abstract List<Persona> findByall();
	public abstract void delete(int id);
	public abstract void cambiaPersona(int v_tipopersona,int v_idpersona);
	public abstract Persona updatetipopersona(int tipo,int id);
}
