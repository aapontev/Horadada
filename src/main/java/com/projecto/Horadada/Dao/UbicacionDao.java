package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Ubicacion;

@Repository("ubicaciondao")
public interface UbicacionDao extends CrudRepository<Ubicacion, Serializable>{

	@Query(value="SELECT  ubi.idubicacion, ubi.direccion, ubi.fecha, ubi.hora, ubi.iddespacho, ubi.latitud, ubi.longitud, ubi.idvehiculo FROM Ubicacion ubi \r\n" + 
			"  INNER JOIN Despacho desp ON desp.idDespacho = ubi.idDespacho INNER JOIN VEHICULO veh on veh.idvehiculo = ubi.idvehiculo\r\n" + 
			"  WHERE desp.idDespacho = :iddespacho \r\n" + 
			"  AND desp.idEstadoDespacho = 2 \r\n" + 
			"  AND veh.idtransportista = :idtransportista \r\n" + 
			"  AND rownum = 1 order by idUbicacion desc" ,nativeQuery=true)
	public abstract Ubicacion getUbicacion(@Param("iddespacho") int iddespacho,@Param("idtransportista")int idtransportista);
	
	@Query(value="select * from ubicacion where idUbicacion =1", nativeQuery = true)
	public abstract Ubicacion getUbicacionOne();
	
}
