package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Dao.PersonaDao;
import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.service.PersonaService;

@Service("personaServiceImp")
public class PersonaServiceImp implements PersonaService{
	
	@Autowired
	@Qualifier("personaDao")
	private PersonaDao personaDao;

	@Override
	public List<Persona> findByTipopersona(int id) {
		
		List<Persona> tipPer = personaDao.findByTipopersona(id);
		return tipPer;
	}

}
