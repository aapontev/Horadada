package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.OrdenCompraDao;
import com.projecto.Horadada.Entity.OrdenCompra;
import com.projecto.Horadada.service.OrdenCompraService;

@Service("ordencompraservice")
public class OrdenCompraServiceImp implements OrdenCompraService{

	@Autowired
	@Qualifier("ordencompra")
	private OrdenCompraDao ordencompradao;

	@Override
	public List<OrdenCompra> findAll() {
		List<OrdenCompra> ordencompra = (List<OrdenCompra>) ordencompradao.findAll();
		return ordencompra;
	}

	@Override
	public OrdenCompra findbyid(int id) {
		OrdenCompra ordencompra = ordencompradao.findByIdOrdenCompra(id);
		return ordencompra;
	}

	@Override
	public OrdenCompra save(OrdenCompra ordencompra) {
		OrdenCompra orcom = ordencompradao.save(ordencompra);
		return orcom;
	}

	@Override
	public void delete(int id) {
		ordencompradao.deleteById(id);
		
	}

	@Override
	public List<OrdenCompra> findByestadoordencompra(int i) {
		List<OrdenCompra> ordencompra = ordencompradao.findByestadoOrdenCompra(i);
		return ordencompra;
	}

	@Override
	public Page<OrdenCompra> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return ordencompradao.findAll(pageable);
	}


}
