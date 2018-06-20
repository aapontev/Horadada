package com.projecto.Horadada.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.projecto.Horadada.Entity.Despacho;
import com.projecto.Horadada.service.DespachoService;

@Controller
@RequestMapping("/despacho")
public class DespachoController {

	@Autowired
	@Qualifier("despachoservice")
	private DespachoService despachoservice;

	@GetMapping("")
	public ModelAndView Despachos() {
		ModelAndView mav = new ModelAndView("documentacion/despachoDoc");
		List<Despacho> despachos = despachoservice.findAll();
		mav.addObject("despachos", despachos);
		return mav;
	}
	@GetMapping("/despachoform")
	public String DespachoForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		Despacho despacho = new Despacho();
		//List<Persona> persona = personaService.findByTipopersona(0);
		//List<Despacho> despacho = clienteService.findByAll(); 
		if(id != 0) {
		//	contacto =contactoService.findByidcontacto(id);		
		}
		//model.addAttribute("cliente", cliente);
		model.addAttribute("contacto",despacho);
		//model.addAttribute("persona", persona);
		return "crearEditar/contacto";
	}
	
}
