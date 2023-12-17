package com.projecto.Horadada.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.DireccionEntity;
import com.projecto.Horadada.Entity.PersonaEntity;
import com.projecto.Horadada.Entity.TablaMaestraEntity;
import com.projecto.Horadada.Entity.TelefonoMonitoreoEntity;
import com.projecto.Horadada.Entity.TipoServicioEntity;
import com.projecto.Horadada.Entity.UbicacionEntity;
import com.projecto.Horadada.Entity.VehiculoEntity;

public interface UtilitarioService {

    public abstract Page<TipoServicioEntity> findAllServ(Pageable pageable);

    public abstract TipoServicioEntity findByIdservicio(int id);

    public abstract TipoServicioEntity save(TipoServicioEntity servicio);

    public abstract void deleteServ(int id);

    public abstract List<TipoServicioEntity> findByNombre(String term);

    public abstract UbicacionEntity getUbicacion(int iddespacho, int idtransportista);

    public abstract UbicacionEntity getUbicacionOne();

    public abstract UbicacionEntity save(UbicacionEntity ubi);

    public abstract List<TablaMaestraEntity> findByIdtablaMaestra(String idTabla);

    public abstract List<String> gettablamaestra();

    public abstract TablaMaestraEntity findByidTablaMaestraAndClave1(String idTabla, String clave1);

    public abstract TelefonoMonitoreoEntity findById(int id);

    public abstract TelefonoMonitoreoEntity findByPersona(PersonaEntity persona);
    
    public abstract List<TelefonoMonitoreoEntity> findByAll();
    
    public abstract TelefonoMonitoreoEntity save(TelefonoMonitoreoEntity telefono);

    public abstract Page<TelefonoMonitoreoEntity> findAllTel(Pageable pageable);

    public abstract TelefonoMonitoreoEntity findByimei(String imei);

    public abstract TelefonoMonitoreoEntity findBynumerotelefono(String numero);    

    public abstract void deleteTel(int id);

    public abstract Page<DireccionEntity> findAllDir(Pageable pageRequest);

    public abstract DireccionEntity findByIddireccion(int id);

    public abstract void deleteDire(int id);

    public abstract DireccionEntity save(DireccionEntity direccion);

    public abstract List<DireccionEntity> findAll();

    public abstract Page<VehiculoEntity> findAll(Pageable pageRequest);

    public abstract VehiculoEntity findByidvehiculo(int id);

    public abstract void deleteVeh(int id);

    public abstract VehiculoEntity save(VehiculoEntity vehiculo);
}
