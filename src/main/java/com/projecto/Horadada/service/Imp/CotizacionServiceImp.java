package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.CotizacionDao;
import com.projecto.Horadada.Entity.CotizacionEntity;
import com.projecto.Horadada.service.CotizacionService;

@Service("cotizacionserviceimp")
public class CotizacionServiceImp implements CotizacionService{
	
	@Autowired
	@Qualifier("Cotizaciondao")
	private CotizacionDao cotizaciondao;

	@Override
	public List<CotizacionEntity> findAll() {
		List<CotizacionEntity> cotizacion = (List<CotizacionEntity>) cotizaciondao.findAll();
		return cotizacion;
	}

	@Override
	public CotizacionEntity findbyid(int id) {
		CotizacionEntity coti= cotizaciondao.findByidCotizacion(id);
		return coti;
	}

	@Override
	public CotizacionEntity save(CotizacionEntity cotizacion) {
		CotizacionEntity cotiza = cotizaciondao.save(cotizacion);
		return cotiza;
	}

	@Override
	public void delete(int id) {
		cotizaciondao.deleteById(id);
		
	}

	@Override
	public Page<CotizacionEntity> findAll(Pageable pageable) {
		return cotizaciondao.findAll(pageable);
	}

	@Override
	public List<CotizacionEntity> findByaprobado(int estado) {
		return cotizaciondao.findByaprobado(estado);
	}

}
