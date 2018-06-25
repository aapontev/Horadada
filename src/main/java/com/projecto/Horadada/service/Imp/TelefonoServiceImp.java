package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.TelefonoDao;
import com.projecto.Horadada.Entity.Telefono;
import com.projecto.Horadada.service.TelefonoService;

@Service("telefonoserviceimp")
public class TelefonoServiceImp implements TelefonoService {

	@Autowired
	@Qualifier("telefonodao")
	private TelefonoDao telefonodao;
	
	@Override
	public List<Telefono> findByAll() {
		List<Telefono> telefono = (List<Telefono>) telefonodao.findAll();
		return telefono;
	}

}
