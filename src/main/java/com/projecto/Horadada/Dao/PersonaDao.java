package com.projecto.Horadada.Dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Persona;


@Repository("personaDao")
public interface PersonaDao extends JpaRepository<Persona, Serializable>{
	
	public abstract List<Persona> findByTipopersona(int id);
	public abstract Persona findPersonaByidpersona(int id);
	
	@Query(value="{call mant_persona1 (1, 459)}" ,nativeQuery=true)
	public abstract void updatetipopersona(@Param("tipo")int tipo,@Param("id") int id);
	

    @Procedure(name = "cambiaPersona")
    public abstract void cambioPersona(@Param("v_tipopersona")int tipo, @Param("v_idpersona") int id);
}
