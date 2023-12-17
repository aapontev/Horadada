package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.TransportistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("transportistaDao")
public interface TransportistaDao extends JpaRepository<TransportistaEntity, Serializable> {

    public abstract TransportistaEntity findByidTransportista(int id);

    public abstract TransportistaEntity findByidSituacionTransportista(Integer id);
}
