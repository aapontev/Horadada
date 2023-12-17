package com.projecto.Horadada.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.PersonaEntity;

public interface PersonaService {

    public abstract List<PersonaEntity> findByTipopersona(int id);

    public abstract PersonaEntity findByidPersona(int id);

    public abstract PersonaEntity save(PersonaEntity persona);

    public abstract List<PersonaEntity> findByall();

    public abstract void delete(PersonaEntity persona);

    public abstract void cambiaPersona(int tipopersona, int idpersona);

    public Page<PersonaEntity> findAll(Pageable pageable);
}
