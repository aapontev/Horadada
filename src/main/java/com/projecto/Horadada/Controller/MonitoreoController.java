
package com.projecto.Horadada.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.Horadada.Entity.Ubicacion;
import com.projecto.Horadada.service.UbicacionService;

@Controller
@RequestMapping("/monitoreo")
public class MonitoreoController {
	
	@Autowired
	@Qualifier("ubicacionserviceimp")
	private UbicacionService ubicacionservice;
	
	@GetMapping("/")
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

}
