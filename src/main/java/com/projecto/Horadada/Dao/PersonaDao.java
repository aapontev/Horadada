package com.projecto.Horadada.Dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Persona;


@Repository("personaDao")
public interface PersonaDao extends CrudRepository<Persona, Serializable>{
	
	public abstract List<Persona> findByTipopersona(int id);
	public abstract Persona findPersonaByidpersona(int id);
	
	@Procedure(name = "cambiaPersona")
	public abstract void cambiaPersona(@Param("v_tipopersona")int v_tipopersona,@Param("v_idpersona") int v_idpersona);	

	@Query(value="update persona set tipopersona = :tipo where idpersona = :id" ,nativeQuery=true)
	public abstract Persona updatetipopersona(@Param("tipo")int tipo,@Param("id")int id);

}
