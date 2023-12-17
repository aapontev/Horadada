package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("personaDao")
public interface PersonaDao extends JpaRepository<PersonaEntity, Serializable> {

    public abstract List<PersonaEntity> findByTipoPersona(int id);

    public abstract PersonaEntity findPersonaByidPersona(int id);

    @Procedure(name = "cambiaPersona")
    public abstract void cambiaPersona(@Param("tipopersona") int v_tipopersona, @Param("id_persona") int v_idpersona);

}
