package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	@Override
	public Despacho findByiddespacho(int id) {
		Despacho despacho = despachodao.findByiddespacho(id);
		return despacho;
	}
	@Override
	public Despacho save(Despacho despacho) {
		Despacho desp= despachodao.save(despacho);
		return desp;
	}
	@Override
	public Page<Despacho> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return despachodao.findAll(pageable);
	}

}
