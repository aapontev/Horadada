
package com.projecto.Horadada.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.projecto.Horadada.Entity.Ubicacion;
import com.projecto.Horadada.Entity.Ubicacionhist;
import com.projecto.Horadada.Entity.Vehiculo;
import com.projecto.Horadada.service.UbicacionService;

@Controller
@RestController
@RequestMapping("/monitoreo")
public class MonitoreoController {
	
	@Autowired
	@Qualifier("ubicacionserviceimp")
	private UbicacionService ubicacionservice;
	
	@GetMapping("")
	public ModelAndView monitoreo() {
		ModelAndView mav = new ModelAndView("monitoreo/monitoreo");
		Ubicacion ubi = ubicacionservice.getUbicacionOne();
		mav.addObject("ubi", ubi);
		return mav;
	}
	
	@PostMapping("/obtieneubicacion")
	public ModelAndView obtieneUbicacion(@RequestParam(name="iddespacho")int iddespacho,
			@RequestParam(name="idtransportista") int idtransportista) {
		Ubicacion ubi = ubicacionservice.getUbicacion(iddespacho, idtransportista);
		ModelAndView mav = new ModelAndView("monitoreo/monitoreo");
		mav.addObject("ubi", ubi);
		return mav;
	}
	
	@GetMapping("/web")
	public ResponseEntity<Ubicacion> monitoreoWeb(){
		Ubicacion ubi = ubicacionservice.getUbicacionOne();
		return new ResponseEntity<Ubicacion>(ubi,HttpStatus.OK);
	}
	@PostMapping("/obtieneubicacionmobil")
	public ResponseEntity<Ubicacion> obtieneMobil(@RequestParam(name="longitud")String longitud,@RequestParam(name="hora")String hora,
			@RequestParam(name="latitud") String latitud,@RequestParam(name="direccion")String direccion) {
		Vehiculo veh = new Vehiculo();
		Ubicacionhist uhist= new Ubicacionhist();
		uhist = null;
		veh = null;
		Date date = new Date();
		Ubicacion ubi = new Ubicacion(105,veh,1,longitud,latitud,date,hora,direccion,uhist);
				ubicacionservice.save(ubi);
				return new ResponseEntity<Ubicacion>(ubi,HttpStatus.OK);
	}

}
