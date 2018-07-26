
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
import com.projecto.Horadada.service.PersonaService;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RestController
@RequestMapping("/monitoreo")
public class MonitoreoController {

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;
	
	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;
	
	private int resul = 0;

	@GetMapping("")
	public ModelAndView monitoreo() {
		ModelAndView mav = new ModelAndView("monitoreo/monitoreo");
		Ubicacion ubi = utilitarioservice.getUbicacionOne();
		if (ubi != null) {
			resul = 1;
		}
		mav.addObject("resu", resul);
		mav.addObject("ubi", ubi);
		return mav;
	}

	@PostMapping("/obtieneubicacion")
	public ModelAndView obtieneUbicacion(@RequestParam(name = "iddespacho") int iddespacho,
			@RequestParam(name = "idtransportista") int idtransportista) {
		Ubicacion ubi = utilitarioservice.getUbicacion(iddespacho, idtransportista);
		ModelAndView mav = new ModelAndView("monitoreo/monitoreo");
		mav.addObject("ubi", ubi);
		return mav;
	}

	@GetMapping("/web")
	public ResponseEntity<Ubicacion> monitoreoWeb() {
		Ubicacion ubi = utilitarioservice.getUbicacionOne();
		return new ResponseEntity<Ubicacion>(ubi, HttpStatus.OK);
	}

	@PostMapping("/obtieneubicacionmobil")
	public ResponseEntity<Ubicacion> obtieneMobil(@RequestParam(name = "longitud") String longitud,
			@RequestParam(name = "hora") String hora, @RequestParam(name = "latitud") String latitud,
			@RequestParam(name = "direccion") String direccion,@RequestParam(name = "imei") String imei) {
		//Telefono tel = new Telefono();
		Vehiculo veh = new Vehiculo();
		Ubicacionhist uhist = new Ubicacionhist();
		uhist = null;
		veh = null;
		Date date = new Date();
		Ubicacion ubi = new Ubicacion(105, veh, 1, longitud, latitud, date, hora, direccion, uhist);
		utilitarioservice.save(ubi);
		return new ResponseEntity<Ubicacion>(ubi, HttpStatus.OK);
	}
	
	@GetMapping("/enviacoordenadas")
	public void enviacoordenadas(@RequestParam(name = "imei") String mobil) {
		
		//Telefono telefono = utilitarioservice.findByimei(mobil);
		//Persona persona = personaService.findByidPersona(telefono.getPersona().getIdpersona());
		//System.out.println(persona.getNombrecompleto());
	}

}
