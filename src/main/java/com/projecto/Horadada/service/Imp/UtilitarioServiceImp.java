package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Dao.DireccionDao;
import com.projecto.Horadada.Dao.ServicioDao;
import com.projecto.Horadada.Dao.TablaMaestraDao;
import com.projecto.Horadada.Dao.TelefonoDao;
import com.projecto.Horadada.Dao.UbicacionDao;
import com.projecto.Horadada.Entity.Direccion;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Entity.Telefono;
import com.projecto.Horadada.Entity.Tiposervicio;
import com.projecto.Horadada.Entity.Ubicacion;
import com.projecto.Horadada.service.UtilitarioService;

@Service("utilitarioservice")
public class UtilitarioServiceImp implements UtilitarioService {

	@Autowired
	@Qualifier("serviciodao")
	private ServicioDao serviciodao;
	
	@Autowired
	@Qualifier("ubicaciondao")
	UbicacionDao ubicaciondao;
	
	@Autowired
	@Qualifier("tablaMaestraDao")
	private TablaMaestraDao tablaMaestraDao;
	
	@Autowired
	@Qualifier("telefonodao")
	private TelefonoDao telefonodao;
	
	@Autowired
	@Qualifier("direcciondao")
	private DireccionDao direcciondao;
	
	@Override
	public Page<Tiposervicio> findAllServ(Pageable pageable) {
		// TODO Auto-generated method stub
		return serviciodao.findAll(pageable);
	}	
	
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


	@Override
	public Ubicacion save(Ubicacion ubi) {
		return ubicaciondao.save(ubi);
		
	}	
	
	@Override
	public List<Tablamaestra> findByIdtablamaestra(String idTabla) {
		List<Tablamaestra> tabId = tablaMaestraDao.findByidtablamaestra(idTabla);
		return tabId;
	}

	@Override
	public List<String> gettablamaestra() {
		List<String> des= tablaMaestraDao.gettablamaestra();
		return des;
	}
	
	@Override
	public List<Telefono> findByAll() {
		List<Telefono> telefono = (List<Telefono>) telefonodao.findAll();
		return telefono;
	}

	@Override
	public Telefono save(Telefono telefono) {
		Telefono telef = telefonodao.save(telefono);
		return telef;
	}

	@Override
	public Page<Telefono> findAllTel(Pageable pageable) {
		// TODO Auto-generated method stub
		return telefonodao.findAll(pageable);
	}

	@Override
	public Tiposervicio findByIdservicio(int id) {
		// TODO Auto-generated method stub
		return serviciodao.findByIdservicio(id);
	}

	@Override
	public Tiposervicio save(Tiposervicio servicio) {
		// TODO Auto-generated method stub
		return serviciodao.save(servicio);
	}

	@Override
	public void deleteServ(int id) {
		// TODO Auto-generated method stub
		serviciodao.deleteById(id);
	}

	@Override
	public Page<Direccion> findAllDir(Pageable pageRequest) {
		// TODO Auto-generated method stub
		return direcciondao.findAll(pageRequest);
	}

	@Override
	public Direccion findByIddireccion(int id) {
		// TODO Auto-generated method stub
		return direcciondao.findByIddireccion(id);
	}

	@Override
	public void deleteDire(int id) {
		// TODO Auto-generated method stub
		direcciondao.deleteById(id);
		
	}

	@Override
	public Direccion save(Direccion direccion) {
		// TODO Auto-generated method stub
		return direcciondao.save(direccion);
	}

	@Override
	public List<Tiposervicio> findByNombre(String term) {
		// TODO Auto-generated method stub
		return serviciodao.findByNombreservicioLikeIgnoreCase("%"+term+"%");
	}
}
