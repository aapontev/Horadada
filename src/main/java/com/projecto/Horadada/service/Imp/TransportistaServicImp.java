package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Dao.TransportistaDao;
import com.projecto.Horadada.Entity.TransportistaEntity;
import com.projecto.Horadada.service.TransportistaService;

@Service("transportistaServiceImp")
public class TransportistaServicImp implements TransportistaService {

    @Autowired
    @Qualifier("transportistaDao")
    private TransportistaDao transportistaDao;

    @Override
    public List<TransportistaEntity> findByAll() {
        List<TransportistaEntity> tra = (List<TransportistaEntity>) transportistaDao.findAll();
        return tra;
    }

    @Override
    public TransportistaEntity findByidtransportista(int id) {
        TransportistaEntity transportista = transportistaDao.findByidTransportista(id);
        return transportista;
    }

    @Override
    public TransportistaEntity save(TransportistaEntity transportista) {
        TransportistaEntity transpor = transportistaDao.save(transportista);
        return transpor;
    }

    @Override
    public void delete(int id) {
        transportistaDao.deleteById(id);
    }

    @Override
    public Page<TransportistaEntity> findAll(Pageable pageable) {
        return transportistaDao.findAll(pageable);
    }

    @Override
    public TransportistaEntity findByidsituaciontransportista(int i) {
        return transportistaDao.findByidSituacionTransportista(i);
    }

}
