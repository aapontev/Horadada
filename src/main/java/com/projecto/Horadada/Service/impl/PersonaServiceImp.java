package com.projecto.Horadada.Service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.Repository.PersonaDao;
import com.projecto.Horadada.Service.PersonaService;

@Service
public class PersonaServiceImp implements PersonaService{

@Autowired
private PersonaDao personaDao;

	@Override
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	public void inOnlyTest(int tipopersona) {
		personaDao.inOnlyTest(tipopersona);		
		
	}

		
	
	/*@Override
	@Transactional
	public void inPrueba(String tipPer) {
		
		try {
			this.em.createNativeQuery("begin mant_persona.mant_usuario (:tipPer); end;").
			setParameter("tipPer", tipPer)
			.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}*/

}
