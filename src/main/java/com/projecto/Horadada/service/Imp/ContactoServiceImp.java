package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public int findbyidcliente(int id) {
		int con = contactoDao.getclienteIdCliente(id);
		return con;
	}

	@Override
	public Contacto save(Contacto contacto) {
		try {
			Contacto cont = contactoDao.save(contacto);
			return cont;			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void delete(int id) {
		contactoDao.deleteById(id);
	}

	@Override
	public Contacto findByidcontacto(int id) {
		Contacto contacto = contactoDao.findByidContacto(id);
		return contacto;
	}

	@Override
	public Page<Contacto> findAll(Pageable pageRequest) {
		// TODO Auto-generated method stub
		return contactoDao.findAll(pageRequest);
	}



}
