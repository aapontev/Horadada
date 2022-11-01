package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.Persona;

public interface PersonaService {

	public abstract List<Persona> findByTipopersona(int id);
	public abstract Persona findByidPersona(int id);
	public abstract Persona save(Persona persona);
	public abstract List<Persona> findByall();
	public abstract void delete(int id);
	public abstract void cambiaPersona(int tipopersona,int idpersona);
	public Page<Persona> findAll(Pageable pageable);
}
