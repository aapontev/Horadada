package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.PersonaDao;
import com.projecto.Horadada.Entity.PersonaEntity;
import com.projecto.Horadada.service.PersonaService;

@Service("personaServiceImp")
public class PersonaServiceImp implements PersonaService {

    @Autowired
    @Qualifier("personaDao")
    private PersonaDao personaDao;

    @Override
    public List<PersonaEntity> findByTipopersona(int id) {
        List<PersonaEntity> tipPer = personaDao.findByTipoPersona(id);
        return tipPer;
    }

    @Override
    public PersonaEntity findByidPersona(int id) {
        PersonaEntity per = personaDao.findById(id).get();
        return per;
    }

    @Override
    public PersonaEntity save(PersonaEntity persona) {
        PersonaEntity per = personaDao.save(persona);
        return per;
    }

    @Override
    public List<PersonaEntity> findByall() {
        List<PersonaEntity> tipPer = (List<PersonaEntity>) personaDao.findAll();
        return tipPer;
    }

    @Override
    public void delete(PersonaEntity personaEntity) {
        personaDao.delete(personaEntity);
    }

    @Override
    public void cambiaPersona(int tipopersona, int idpersona) {
        personaDao.cambiaPersona(tipopersona, idpersona);
    }

    @Override
    public Page<PersonaEntity> findAll(Pageable pageable) {
        return personaDao.findAll(pageable);
    }

}
