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
import com.projecto.Horadada.Dao.VehiculoDao;
import com.projecto.Horadada.Entity.DireccionEntity;
import com.projecto.Horadada.Entity.PersonaEntity;
import com.projecto.Horadada.Entity.TablaMaestraEntity;
import com.projecto.Horadada.Entity.TelefonoMonitoreoEntity;
import com.projecto.Horadada.Entity.TipoServicioEntity;
import com.projecto.Horadada.Entity.UbicacionEntity;
import com.projecto.Horadada.Entity.VehiculoEntity;
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

    @Override
    public Page<TipoServicioEntity> findAllServ(Pageable pageable) {
        return serviciodao.findAll(pageable);
    }

    @Override
    public UbicacionEntity getUbicacion(int iddespacho, int idtransportista) {
        UbicacionEntity ubicacion = ubicaciondao.getUbicacion(iddespacho, idtransportista);
        return ubicacion;
    }

    @Override
    public UbicacionEntity getUbicacionOne() {
        UbicacionEntity ubicacion = ubicaciondao.getUbicacionOne();
        return ubicacion;
    }

    @Override
    public UbicacionEntity save(UbicacionEntity ubi) {
        return ubicaciondao.save(ubi);
    }

    @Override
    public List<TablaMaestraEntity> findByIdtablaMaestra(String idTabla) {
        List<TablaMaestraEntity> tabId = tablaMaestraDao.findByidTablaMaestra(idTabla);
        return tabId;
    }

    @Override
    public List<String> gettablamaestra() {
        List<String> des = tablaMaestraDao.gettablaMaestra();
        return des;
    }

    @Override
    public TablaMaestraEntity findByidTablaMaestraAndClave1(String idTabla, String clave1) {
        return tablaMaestraDao.findByidTablaMaestraAndClave1(idTabla, clave1);
    }

    @Override
    public TipoServicioEntity findByIdservicio(int id) {
        return serviciodao.findByIdServicio(id);
    }

    @Override
    public TipoServicioEntity save(TipoServicioEntity servicio) {
        return serviciodao.save(servicio);
    }

    @Override
    public void deleteServ(int id) {
        serviciodao.deleteById(id);
    }

    @Override
    public Page<DireccionEntity> findAllDir(Pageable pageRequest) {
        return direcciondao.findAll(pageRequest);
    }

    @Override
    public DireccionEntity findByIddireccion(int id) {
        return direcciondao.findByIdDireccion(id);
    }

    @Override
    public void deleteDire(int id) {
        direcciondao.deleteById(id);

    }

    @Override
    public DireccionEntity save(DireccionEntity direccion) {
        return direcciondao.save(direccion);
    }

    @Override
    public List<TipoServicioEntity> findByNombre(String term) {
        return serviciodao.findByNombreServicioLikeIgnoreCase("%" + term + "%");
    }

    @Override
    public List<DireccionEntity> findAll() {
        return (List<DireccionEntity>) direcciondao.findAll();
    }

    @Override
    public Page<VehiculoEntity> findAll(Pageable pageRequest) {
        return vehiculodao.findAll(pageRequest);
    }

    @Override
    public VehiculoEntity findByidvehiculo(int id) {
        return vehiculodao.findByidVehiculo(id);
    }

    @Override
    public void deleteVeh(int id) {
        vehiculodao.deleteById(id);

    }

    @Override
    public VehiculoEntity save(VehiculoEntity vehiculo) {
        return vehiculodao.save(vehiculo);
    }

    @Override
    public TelefonoMonitoreoEntity findByimei(String imei) {
        return telefonodao.findByimei(imei);
    }

    @Override
    public TelefonoMonitoreoEntity findBynumerotelefono(String numero) {
        return telefonodao.findBynumeroTelefono(numero);
    }

    @Override
    public void deleteTel(int id) {
        telefonodao.deleteById(id);
    }
        @Override
    public List<TelefonoMonitoreoEntity> findByAll() {
        List<TelefonoMonitoreoEntity> telefono = (List<TelefonoMonitoreoEntity>) telefonodao.findAll();
        return telefono;
    }

    @Override
    public TelefonoMonitoreoEntity save(TelefonoMonitoreoEntity telefono) {
        TelefonoMonitoreoEntity telef = telefonodao.save(telefono);
        return telef;
    }

    @Override
    public Page<TelefonoMonitoreoEntity> findAllTel(Pageable pageable) {
        return telefonodao.findAll(pageable);
    }

    @Override
    public TelefonoMonitoreoEntity findById(int id) {
        return telefonodao.findById(id).get();
    }

    @Override
    public TelefonoMonitoreoEntity findByPersona(PersonaEntity persona) {
        return telefonodao.findBypersona(persona);
    }
}
