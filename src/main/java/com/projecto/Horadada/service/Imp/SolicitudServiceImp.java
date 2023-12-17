package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.SolicitudDao;
import com.projecto.Horadada.Entity.SolicitudEntity;
import com.projecto.Horadada.service.SolicitudService;

@Service("solicitudServiceimp")
public class SolicitudServiceImp implements SolicitudService {

    @Autowired
    @Qualifier("solicituddao")
    private SolicitudDao solicitudDao;

    @Override
    public List<SolicitudEntity> findByAll() {
        List<SolicitudEntity> solic = (List<SolicitudEntity>) solicitudDao.findAll();
        return solic;
    }

    @Override
    public SolicitudEntity save(SolicitudEntity solicitud) {
        SolicitudEntity solic = solicitudDao.save(solicitud);
        return solic;
    }

    @Override
    public void delete(int idsolitud) {
        solicitudDao.deleteById(idsolitud);

    }

    @Override
    public SolicitudEntity findByidsolicitud(int idsolicitud) {
        SolicitudEntity solic = solicitudDao.findByidSolicitud(idsolicitud);
        return solic;
    }

    @Override
    public List<SolicitudEntity> getidsolicitud() {
        List<SolicitudEntity> iddes = solicitudDao.getidsolicitud();
        return iddes;
    }

    @Override
    public Page<SolicitudEntity> findAll(Pageable pageable) {
        return solicitudDao.findAll(pageable);
    }

}
