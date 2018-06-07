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

	@Override
	public Persona findByidPersona(int id) {
		Persona per = personaDao.findPersonaByidpersona(id);
		return per;
	}

	@Override
	public Persona save(Persona persona) {
		Persona per = personaDao.save(persona);
		return per;
	}

	@Override
	public List<Persona> findByall() {
		List<Persona> tipPer = personaDao.findAll();
		return tipPer;
	}

	@Override
	public void delete(int id) {
		personaDao.deleteById(id);
		
	}

	@Override
	public void update(int tipo,int id) {
		personaDao.updatetipopersona(tipo, id);
				
	}

	@Override
	public void cambiaPersona(Integer tipo, Integer id) {
		personaDao.mant_persona1(tipo, id);
		
	}


}
