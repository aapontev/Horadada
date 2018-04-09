package com.projecto.Horadada.Repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.projecto.Horadada.Entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Serializable>{
	
    @Procedure(name = "mant_usuario")
    void inOnlyTest(@Param("tip_per") String tip_per);

}
