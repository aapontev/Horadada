package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Direccion;

@Repository("direcciondao")
public interface DireccionDao extends PagingAndSortingRepository<Direccion, Serializable> {

	public abstract Direccion findByIdDireccion(int id);

}
