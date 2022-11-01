package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Dao.TransportistaDao;
import com.projecto.Horadada.Entity.Transportista;
import com.projecto.Horadada.service.TransportistaService;

@Service("transportistaServiceImp")
public class TransportistaServicImp implements TransportistaService {

	@Autowired
	@Qualifier("transportistaDao")
	private TransportistaDao transportistaDao;

	@Override
	public List<Transportista> findByAll() {
		List<Transportista> tra = (List<Transportista>) transportistaDao.findAll();
		return tra;
	}

	@Override
	public Transportista findByidtransportista(int id) {
		Transportista transportista = transportistaDao.findByidTransportista(id);
		return transportista;
	}

	@Override
	public Transportista save(Transportista transportista) {
		Transportista transpor = transportistaDao.save(transportista);
		return transpor;
	}

	@Override
	public void delete(int id) {
		transportistaDao.deleteById(id);
	}

	@Override
	public Page<Transportista> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return transportistaDao.findAll(pageable);
	}

	@Override
	public Transportista findByidsituaciontransportista(int i) {
		// TODO Auto-generated method stub
		return transportistaDao.findByidSituacionTransportista(i);
	}

}
