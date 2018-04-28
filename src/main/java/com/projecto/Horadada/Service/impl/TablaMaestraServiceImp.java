package com.projecto.Horadada.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Repository.TablaMaestraDao;
import com.projecto.Horadada.Service.TablaMaestraService;

@Service
public class TablaMaestraServiceImp implements TablaMaestraService{

	@Autowired
	private TablaMaestraDao maestraDao;
	
	@Override
	public List<Tablamaestra> findAll() {
		
		return (List<Tablamaestra>) maestraDao.findAll();
	}

}
