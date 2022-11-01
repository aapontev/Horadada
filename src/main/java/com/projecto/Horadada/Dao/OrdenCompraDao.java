package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.OrdenCompra;

@Repository("ordencompra")
public interface OrdenCompraDao extends PagingAndSortingRepository<OrdenCompra, Serializable>{

	public abstract OrdenCompra findByIdOrdenCompra(int id);

	public abstract List<OrdenCompra> findByestadoOrdenCompra(Integer i);
}
