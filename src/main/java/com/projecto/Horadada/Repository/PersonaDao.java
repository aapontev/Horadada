package com.projecto.Horadada.Repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.projecto.Horadada.Entity.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long>{
	//public void savePersona(String tipPer);
	@Procedure(name = "mant_usuario")
    public void inOnlyTest(@Param("tipopersona") String tipopersona);
}
