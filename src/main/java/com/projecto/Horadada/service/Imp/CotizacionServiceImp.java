package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.CotizacionDao;
import com.projecto.Horadada.Entity.Cotizacion;
import com.projecto.Horadada.service.CotizacionService;

@Service("cotizacionserviceimp")
public class CotizacionServiceImp implements CotizacionService{
	
	@Autowired
	@Qualifier("Cotizaciondao")
	private CotizacionDao cotizaciondao;

	@Override
	public List<Cotizacion> findAll() {
		List<Cotizacion> cotizacion = cotizaciondao.findAll();
		return cotizacion;
	}

	@Override
	public Cotizacion findbyid(int id) {
		Cotizacion coti= cotizaciondao.findByidcotizacion(id);
		return coti;
	}

	@Override
	public Cotizacion save(Cotizacion cotizacion) {
		Cotizacion cotiza = cotizaciondao.save(cotizacion);
		return cotiza;
	}

	@Override
	public void delete(int id) {
		cotizaciondao.deleteById(id);
		
	}

}
