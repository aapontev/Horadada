package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.DireccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("direcciondao")
public interface DireccionDao extends JpaRepository<DireccionEntity, Serializable> {

	public abstract DireccionEntity findByIdDireccion(int id);

}
