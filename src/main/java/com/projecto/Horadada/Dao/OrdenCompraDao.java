package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Ordencompra;

@Repository("ordencompra")
public interface OrdenCompraDao extends PagingAndSortingRepository<Ordencompra, Serializable>{

	public abstract Ordencompra findByIdordencompra(int id);

	public abstract List<Ordencompra> findByestadoordencompra(Integer i);
}
