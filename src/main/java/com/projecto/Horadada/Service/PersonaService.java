package com.projecto.Horadada.Service;

import java.util.List;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import com.projecto.Horadada.Entity.Persona;

public interface PersonaService {
	//public void savePersona(String tipPer);
	public List<Persona> findAll();
	
	@Procedure(name = "mant_usuario")
    public void inOnlyTest(@Param("tipopersona")int tipopersona);
}
