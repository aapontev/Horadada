package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.OrdenCompraDao;
import com.projecto.Horadada.Entity.OrdenCompraEntity;
import com.projecto.Horadada.service.OrdenCompraService;

@Service("ordencompraservice")
public class OrdenCompraServiceImp implements OrdenCompraService {

    @Autowired
    @Qualifier("ordencompra")
    private OrdenCompraDao ordencompradao;

    @Override
    public List<OrdenCompraEntity> findAll() {
        List<OrdenCompraEntity> ordencompra = (List<OrdenCompraEntity>) ordencompradao.findAll();
        return ordencompra;
    }

    @Override
    public OrdenCompraEntity findbyid(int id) {
        OrdenCompraEntity ordencompra = ordencompradao.findByIdOrdenCompra(id);
        return ordencompra;
    }

    @Override
    public OrdenCompraEntity save(OrdenCompraEntity ordencompra) {
        OrdenCompraEntity orcom = ordencompradao.save(ordencompra);
        return orcom;
    }

    @Override
    public void delete(int id) {
        ordencompradao.deleteById(id);
    }

    @Override
    public List<OrdenCompraEntity> findByEstadoordencompra(int i) {
        List<OrdenCompraEntity> ordencompra = ordencompradao.findByEstadoOrdenCompra(i);
        return ordencompra;
    }

    @Override
    public Page<OrdenCompraEntity> findAll(Pageable pageable) {
        return ordencompradao.findAll(pageable);
    }

}
