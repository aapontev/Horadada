package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Persona;


@Repository("personaDao")
public interface PersonaDao extends JpaRepository<Persona, Serializable>{
	
	public abstract List<Persona> findByTipopersona(int id);
	public abstract Persona findByidPersona(int id);
}
