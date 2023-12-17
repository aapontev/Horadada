package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.DespachoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("despachodao")
public interface DespachoDao extends JpaRepository<DespachoEntity, Serializable> {

    public abstract DespachoEntity findByidDespacho(int id);

}
