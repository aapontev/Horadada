package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.TipoServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("serviciodao")
public interface ServicioDao extends JpaRepository<TipoServicioEntity, Serializable> {

	public abstract TipoServicioEntity findByIdServicio(int id);

	public abstract List<TipoServicioEntity> findByNombreServicioLikeIgnoreCase(String string);
}
