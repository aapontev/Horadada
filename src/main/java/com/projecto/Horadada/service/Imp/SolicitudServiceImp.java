package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Dao.SolicitudDao;
import com.projecto.Horadada.Entity.Solicitud;
import com.projecto.Horadada.service.SolicitudService;

@Service("solicitudServiceimp")
public class SolicitudServiceImp implements SolicitudService{

	@Autowired
	@Qualifier("solicituddao")
	private SolicitudDao solicitudDao;
	@Override
	public List<Solicitud> findByAll() {
		List<Solicitud> solic=(List<Solicitud>) solicitudDao.findAll();
		return solic;
	}
	@Override
	public Solicitud save(Solicitud solicitud) {
		Solicitud solic = solicitudDao.save(solicitud);
		return solic;
	}
	@Override
	public void delete(int idsolitud) {
		solicitudDao.deleteById(idsolitud);
		
	}
	@Override
	public Solicitud findByidsolicitud(int idsolicitud) {
		Solicitud solic = solicitudDao.findByidsolicitud(idsolicitud);
		return solic;
	}
	@Override
	public List<Solicitud> getidsolicitud() {
		List<Solicitud> iddes = solicitudDao.getidsolicitud();
		return iddes;
	}
	@Override
	public Page<Solicitud> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return solicitudDao.findAll(pageable);
	}

}
