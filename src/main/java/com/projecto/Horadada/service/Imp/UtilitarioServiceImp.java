package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.DireccionDao;
import com.projecto.Horadada.Dao.PersonaDao;
import com.projecto.Horadada.Dao.ServicioDao;
import com.projecto.Horadada.Dao.TablaMaestraDao;
import com.projecto.Horadada.Dao.TelefonoDao;
import com.projecto.Horadada.Dao.UbicacionDao;
import com.projecto.Horadada.Dao.VehiculoDao;
import com.projecto.Horadada.Entity.Direccion;
import com.projecto.Horadada.Entity.TablaMaestra;
import com.projecto.Horadada.Entity.TelefonoMonitoreo;
import com.projecto.Horadada.Entity.TipoServicio;
import com.projecto.Horadada.Entity.Ubicacion;
import com.projecto.Horadada.Entity.Vehiculo;
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

	@Autowired
	@Qualifier("vehiculodao")
	private VehiculoDao vehiculodao;

	@Autowired
	@Qualifier("personaDao")
	private PersonaDao personaDao;
	
	@Override
	public Page<TipoServicio> findAllServ(Pageable pageable) {
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
	public List<TablaMaestra> findByIdtablaMaestra(String idTabla) {
		List<TablaMaestra> tabId = tablaMaestraDao.findByidTablaMaestra(idTabla);
		return tabId;
	}

	@Override
	public List<String> gettablamaestra() {
		List<String> des= tablaMaestraDao.gettablaMaestra();
		return des;
	}
	
	@Override
	public List<TelefonoMonitoreo> findByAll() {
		List<TelefonoMonitoreo> telefono = (List<TelefonoMonitoreo>) telefonodao.findAll();
		return telefono;
	}

	@Override
	public TelefonoMonitoreo save(TelefonoMonitoreo telefono) {
		TelefonoMonitoreo telef = telefonodao.save(telefono);
		return telef;
	}

	@Override
	public Page<TelefonoMonitoreo> findAllTel(Pageable pageable) {
		// TODO Auto-generated method stub
		return telefonodao.findAll(pageable);
	}

	@Override
	public TipoServicio findByIdservicio(int id) {
		// TODO Auto-generated method stub
		return serviciodao.findByIdServicio(id);
	}

	@Override
	public TipoServicio save(TipoServicio servicio) {
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
		return direcciondao.findByIdDireccion(id);
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
	public List<TipoServicio> findByNombre(String term) {
		// TODO Auto-generated method stub
		return serviciodao.findByNombreServicioLikeIgnoreCase("%"+term+"%");
	}

	@Override
	public List<Direccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Direccion>) direcciondao.findAll();
	}

	@Override
	public Page<Vehiculo> findAll(Pageable pageRequest) {
		// TODO Auto-generated method stub
		return vehiculodao.findAll(pageRequest);
	}

	@Override
	public Vehiculo findByidvehiculo(int id) {
		// TODO Auto-generated method stub
		return vehiculodao.findByidVehiculo(id);
	}

	@Override
	public void deleteVeh(int id) {
		// TODO Auto-generated method stub
		vehiculodao.deleteById(id);
		
	}

	@Override
	public Vehiculo save(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return vehiculodao.save(vehiculo);
	}

	/*@Override
	public List<Telefono> findBypersona(Te) {
		// TODO Auto-generated method stub
		int idPer = id.getIdpersona();
		List<Telefono> tel = new Telefono();
		return telefonodao.fin;
	}*/

	@Override
	public TelefonoMonitoreo findByimei(String imei) {
		// TODO Auto-generated method stub
		return telefonodao.findByimei(imei);
	}

	@Override
	public TelefonoMonitoreo findBynumerotelefono(String numero) {
		// TODO Auto-generated method stub
		return telefonodao.findBynumeroTelefono(numero);
	}


	@Override
	public TablaMaestra findByidTablaMaestraAndClave1(String idTabla, String clave1) {
		// TODO Auto-generated method stub
		return tablaMaestraDao.findByidTablaMaestraAndClave1(idTabla, clave1);
	}

/*	@Override
	public List<Telefono> findTelefonoByidPersona(int id) {
		//int idPer = id.getIdpersona();
		//List<Telefono> tel = (List<Telefono>) new Telefono();
		return telefonodao.findTelefonoByidPersona(id);
	}*/
}
