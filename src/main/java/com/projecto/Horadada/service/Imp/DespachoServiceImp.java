package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.DespachoDao;
import com.projecto.Horadada.Entity.DespachoEntity;
import com.projecto.Horadada.service.DespachoService;

@Service("despachoservice")
public class DespachoServiceImp implements DespachoService {

    @Autowired
    @Qualifier("despachodao")
    private DespachoDao despachodao;

    @Override
    public List<DespachoEntity> findAll() {
        List<DespachoEntity> despachos = (List<DespachoEntity>) despachodao.findAll();
        return despachos;
    }

    @Override
    public DespachoEntity findByiddespacho(int id) {
        DespachoEntity despacho = despachodao.findByidDespacho(id);
        return despacho;
    }

    @Override
    public DespachoEntity save(DespachoEntity despacho) {
        DespachoEntity desp = despachodao.save(despacho);
        return desp;
    }

    @Override
    public Page<DespachoEntity> findAll(Pageable pageable) {
        return despachodao.findAll(pageable);
    }

}
