package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.OrdenCompraDao;
import com.projecto.Horadada.Entity.Ordencompra;
import com.projecto.Horadada.service.OrdenCompraService;

@Service("ordencompraservice")
public class OrdenCompraServiceImp implements OrdenCompraService{

	@Autowired
	@Qualifier("ordencompra")
	private OrdenCompraDao ordencompradao;

	@Override
	public List<Ordencompra> findAll() {
		List<Ordencompra> ordencompra = (List<Ordencompra>) ordencompradao.findAll();
		return ordencompra;
	}

	@Override
	public Ordencompra findbyid(int id) {
		Ordencompra ordencompra = ordencompradao.findByIdordencompra(id);
		return ordencompra;
	}

	@Override
	public Ordencompra save(Ordencompra ordencompra) {
		Ordencompra orcom = ordencompradao.save(ordencompra);
		return orcom;
	}

	@Override
	public void delete(int id) {
		ordencompradao.deleteById(id);
		
	}


}
