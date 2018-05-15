package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.ContactoDao;
import com.projecto.Horadada.Entity.Contacto;
import com.projecto.Horadada.service.ContactoService;

@Service("contactoServiceImp")
public class ContactoServiceImp implements ContactoService{
	
	@Autowired
	@Qualifier("contactoDao")
	private ContactoDao contactoDao;

	@Override
	public List<Contacto> findByAll() {
		List<Contacto> con = (List<Contacto>) contactoDao.findAll();
		return con;
	}

	

}
