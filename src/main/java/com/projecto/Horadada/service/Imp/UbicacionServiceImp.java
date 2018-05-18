package com.projecto.Horadada.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.UbicacionDao;
import com.projecto.Horadada.Entity.Ubicacion;
import com.projecto.Horadada.service.UbicacionService;

@Service("ubicacionserviceimp")
public class UbicacionServiceImp implements UbicacionService{

	@Autowired
	@Qualifier("ubicaciondao")
	UbicacionDao ubicaciondao;
	
	
	@Override
	public Ubicacion getUbicacion(int iddespacho,int idtransportista) {
		Ubicacion ubicacion = ubicaciondao.getUbicacion(iddespacho,idtransportista);
		return ubicacion;
	}


	@Override
	public Ubicacion getUbicacionOne() {
		Ubicacion ubicacion= ubicaciondao.getUbicacionOne();
		return ubicacion;
	}
}
