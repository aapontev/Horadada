package com.projecto.Horadada.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.service.PersonaService;

@Controller
@RequestMapping("/control")
public class CrearController {
	
	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;

	@GetMapping("/personaform")
	public String redirectPersonaForm(@RequestParam(name="idpersona",required=false)int id,
			Model model) {
		Persona per = new Persona();
		if(id != 0) {
			 per = personaService.findByidPersona(id);		
		}
		model.addAttribute("persona",per);
		return "crearEditar/persona";
	}
	
	@GetMapping("/atras")
	public String redirectPersonaAtras(@RequestParam(name="tipopersona")int id) {
		String tipPer = null ;
		if(id == 1) {  ///transportista
			tipPer= "redirect:/mantenimiento/transportista";
		}else if (id == 2) {
			tipPer= "redirect:/mantenimiento/trabajador";
		}else if (id == 3) {
			tipPer= "redirect:/mantenimiento/trabajador";
		}
		return tipPer;
	}
}
