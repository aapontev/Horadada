package com.projecto.Horadada.service.Imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.TablaMaestraDao;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.service.TablaMaestraService;

@Service("tablaMaestraServiceImp")
public class TablaMaestraServiceImp implements TablaMaestraService{

	@Autowired
	@Qualifier("tablaMaestraDao")
	private TablaMaestraDao tablaMaestraDao;

	@Override
	public List<Tablamaestra> findByIdtablamaestra(String idTabla) {
		List<Tablamaestra> tabId = tablaMaestraDao.findByIdtablamaestra(idTabla);
		return tabId;
	}

	@Override
	public List<String> gettablamaestra() {
		List<String> des= tablaMaestraDao.gettablamaestra();
		return des;
	}
	
}
