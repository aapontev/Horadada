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
		try {
			Persona per = personaDao.save(persona);
			return per;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Persona> findByall() {
		List<Persona> tipPer = (List<Persona>) personaDao.findAll();
		return tipPer;
	}

	@Override
	public void delete(int id) {
		personaDao.deleteById(id);
		
	}

	@Override
	public void cambiaPersona(int v_tipopersona,int v_idpersona) {
		personaDao.cambiaPersona(v_tipopersona, v_idpersona);
				
	}

	@Override
	public Persona updatetipopersona(int tipo, int id) {
		Persona persona = personaDao.updatetipopersona(tipo, id);
		return persona;
	}

}
