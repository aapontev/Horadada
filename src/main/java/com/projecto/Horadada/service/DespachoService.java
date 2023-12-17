package com.projecto.Horadada.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.DespachoEntity;

public interface DespachoService {

    public abstract List<DespachoEntity> findAll();

    public abstract DespachoEntity findByiddespacho(int id);

    public Page<DespachoEntity> findAll(Pageable pageable);

    public abstract DespachoEntity save(DespachoEntity despacho);

}
