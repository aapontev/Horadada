package com.projecto.Horadada.Dao;


import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Persona;


@Repository("personaDao")
public interface PersonaDao extends CrudRepository<Persona, Serializable>{
	
	public abstract List<Persona> findByTipopersona(int id);
	public abstract Persona findPersonaByidpersona(int id);
	
	//@Query(value="{call mant_persona.mant_usuario(:tipo, :id)}" ,nativeQuery=true)
	@Procedure(name = "cambiaPersona")
	public abstract void cambiaPersona(@Param("v_tipopersona")int v_tipopersona,@Param("v_idpersona") int v_idpersona);
	

   // @Procedure(name = "mant_persona1")
    //public abstract void mant_persona1(Integer tipo, Integer id);
}
