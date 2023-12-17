package com.projecto.Horadada.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.CotizacionDetalleDao;
import com.projecto.Horadada.Entity.CotizacionDetalleEntity;
import com.projecto.Horadada.service.CotizacionDetalleService;

@Service("cotizaciondetalleservice")
public class CotizacionDetalleServiceImp implements CotizacionDetalleService{
	
	@Autowired
	@Qualifier("cotizaciondetalledao")
	CotizacionDetalleDao cotizaciondetalledao;

	@Override
	public CotizacionDetalleEntity findByItem(int item) {
		CotizacionDetalleEntity cotDetalle = cotizaciondetalledao.findByItem(item);
		return cotDetalle;
	}

	@Override
	public CotizacionDetalleEntity save(CotizacionDetalleEntity cotizaciondetalle) {
		CotizacionDetalleEntity cotdetalle = cotizaciondetalledao.save(cotizaciondetalle);
		return cotdetalle;
	}

}
