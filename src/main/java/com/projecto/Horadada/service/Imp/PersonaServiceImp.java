package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Dao.PersonaDao;
import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.service.PersonaService;

@Service("personaServiceImp")
public class PersonaServiceImp implements PersonaService {

	@Autowired
	@Qualifier("personaDao")
	private PersonaDao personaDao;

	@Override
	public List<Persona> findByTipopersona(int id) {

		List<Persona> tipPer = personaDao.findByTipoPersona(id);
		return tipPer;
	}

	@Override
	public Persona findByidPersona(int id) {
		Persona per = personaDao.findPersonaByidPersona(id);
		return per;
	}

	@Override
	public Persona save(Persona persona) {
		Persona per = personaDao.save(persona);
		return per;
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
	public void cambiaPersona(int tipopersona, int idpersona) {
		personaDao.cambiaPersona(tipopersona, idpersona);

	}

	@Override
	public Page<Persona> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return personaDao.findAll(pageable);
	}

	

}
