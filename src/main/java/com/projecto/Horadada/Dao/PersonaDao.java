package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Persona;

@Repository("personaDao")
public interface PersonaDao extends PagingAndSortingRepository<Persona, Serializable>{
	
	public abstract List<Persona> findByTipoPersona(int id);
	
	public abstract Persona findPersonaByidPersona(int id);
	
	@Procedure(name = "cambiaPersona")
	public abstract void cambiaPersona(@Param("tipopersona")int v_tipopersona,@Param("id_persona") int v_idpersona);	

	//@Query(value="update persona set tipopersona = :tipo where idpersona = :id" ,nativeQuery=true)
	//public abstract Persona updatetipopersona(@Param("tipo")int tipo,@Param("id")int id);
	
}