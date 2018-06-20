package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Dao.DespachoDao;
import com.projecto.Horadada.Entity.Despacho;
import com.projecto.Horadada.service.DespachoService;

@Service("despachoservice")
public class DespachoServiceImp implements DespachoService{

	@Autowired
	@Qualifier("despachodao")
	private DespachoDao despachodao;
	@Override
	public List<Despacho> findAll() {
		List<Despacho> despachos = (List<Despacho>) despachodao.findAll();
		return despachos;
	}

}
