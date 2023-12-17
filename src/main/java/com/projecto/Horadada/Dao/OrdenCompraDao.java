package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.OrdenCompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("ordencompra")
public interface OrdenCompraDao extends JpaRepository<OrdenCompraEntity, Serializable> {

    public abstract OrdenCompraEntity findByIdOrdenCompra(int id);

    public abstract List<OrdenCompraEntity> findByEstadoOrdenCompra(Integer i);
}
