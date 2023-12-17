package com.projecto.Horadada.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.OrdenCompraEntity;

public interface OrdenCompraService {

    public abstract List<OrdenCompraEntity> findAll();

    public abstract OrdenCompraEntity findbyid(int id);

    public abstract Object save(OrdenCompraEntity ordencompra);

    public abstract void delete(int id);

    public abstract List<OrdenCompraEntity> findByEstadoordencompra(int i);

    public Page<OrdenCompraEntity> findAll(Pageable pageable);
}
