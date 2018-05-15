package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Dao.TransportistaDao;
import com.projecto.Horadada.Entity.Transportista;
import com.projecto.Horadada.service.TransportistaService;

@Service("transportistaServicImp")
public class TransportistaServicImp implements TransportistaService {

	@Autowired
	@Qualifier("transportistaDao")
	private TransportistaDao transportistaDao;

	
	@Override
	public List<Transportista> findByAll() {
		// TODO Auto-generated method stub
		List<Transportista> tra = (List<Transportista>) transportistaDao.findAll();
		return tra;
	}

}
