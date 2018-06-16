package com.projecto.Horadada.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Entity.Transportista;
import com.projecto.Horadada.service.PersonaService;
import com.projecto.Horadada.service.TablaMaestraService;
import com.projecto.Horadada.service.TransportistaService;

@Controller
@RequestMapping("/transportista")
public class TranportistaController {

	@Autowired
	@Qualifier("transportistaServiceImp")
	private TransportistaService transportistaservice;
	
	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;
	
	@Autowired
	@Qualifier("tablamaestraserviceimp")
	private TablaMaestraService tablaService;
	
	private int tipoproceso; 
	
	@GetMapping("")
	public ModelAndView Transportista() {
		ModelAndView mav = new ModelAndView("mantenimiento/transportista");
		mav.addObject("transport", transportistaservice.findByAll());
		return mav;
	}

	@GetMapping("/transportistaform")
	public String redirectTransportistaForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		Transportista transportista = new Transportista();
		List<Persona> persona = personaService.findByTipopersona(0);
		List<Tablamaestra> licencia = tablaService.findByIdtablamaestra("Hora011");
		List<Tablamaestra> estado = tablaService.findByIdtablamaestra("Hora007");
		tipoproceso = 0;
		if(id != 0) {
			transportista = transportistaservice.findByidtransportista(id);	
			tipoproceso = 1;			
		}
		model.addAttribute("tipoproceso",tipoproceso);
		model.addAttribute("transportista",transportista);
		model.addAttribute("licencia",licencia);
		model.addAttribute("estado",estado);
		model.addAttribute("persona", persona);
		return "crearEditar/transportista";
	}
	
	@PostMapping("/addtransportista")
	public String addTransportista (@ModelAttribute(name="transportista")Transportista transportista,Model model) {
		if(null != transportistaservice.save(transportista)) {
			model.addAttribute("result", 1);
		}else {			
		
		model.addAttribute("result", 0);
		}
		return "redirect:/transportista/";
	}
	
	@GetMapping("/borrartransportista")
	public String borrarTransportista(@RequestParam(name="id",required=true)int id,Model model) {
		
			transportistaservice.delete(id);
		
		return "redirect:/transportista/";
	}
}
