package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projecto.Horadada.Dao.ClienteDao;
import com.projecto.Horadada.Entity.Cliente;
import com.projecto.Horadada.service.ClienteService;

@Service("clienteServiceImp")
public class ClienteServiceImp implements ClienteService{

	@Autowired
	@Qualifier("clienteDao")
	private ClienteDao clienteDao;

	@Override
	public List<Cliente> findByAll() {
		List<Cliente> cli = (List<Cliente>) clienteDao.findAll();
		return cli;
	}

	@Override
	public Cliente save(Cliente cliente) {
		Cliente clie = null;
		try {
			clie = clienteDao.save(cliente);
		} catch (Exception e) {
			clie = null;
		}
		return clie;
	}

	@Override
	public Cliente findByidcliente(int idcliente) {
		Cliente cliente = clienteDao.findByidcliente(idcliente);
		return cliente;
	}

	@Override
	public int delete(int idcliente) {
		int res ;
		try {
			clienteDao.deleteById(idcliente);
			res = 1 ;
		} catch (Exception e) {
			res=0;
		}
		
		return res;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	public Cliente findOne(Long clienteId) {
		// TODO Auto-generated method stub
		return clienteDao.findById(clienteId).orElse(null);
	}

}
