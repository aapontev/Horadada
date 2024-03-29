package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.UbicacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("ubicaciondao")
public interface UbicacionDao extends JpaRepository<UbicacionEntity, Serializable> {

    @Query(value = "SELECT  ubi.idubicacion, ubi.direccion, ubi.fecha, ubi.hora, ubi.iddespacho, ubi.latitud, ubi.longitud, ubi.idvehiculo FROM Ubicacion ubi \r\n"
            + "  INNER JOIN Despacho desp ON desp.iddespacho = ubi.iddespacho INNER JOIN VEHICULO veh on veh.idvehiculo = ubi.idvehiculo\r\n"
            + "  WHERE desp.iddespacho = :iddespacho \r\n"
            + "  AND desp.idestadodespacho = 2 \r\n"
            + "  AND veh.idtransportista = :idtransportista \r\n"
            + "  AND rownum = 1 order by idubicacion desc", nativeQuery = true)
    public abstract UbicacionEntity getUbicacion(@Param("iddespacho") int iddespacho, @Param("idtransportista") int idtransportista);

    @Query(value = "select * from ubicacion where idubicacion =1", nativeQuery = true)
    public abstract UbicacionEntity getUbicacionOne();

}
