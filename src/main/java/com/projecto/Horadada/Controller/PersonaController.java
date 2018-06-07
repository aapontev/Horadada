package com.projecto.Horadada.Controller;

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
import com.projecto.Horadada.service.PersonaService;

@Controller
@RequestMapping("persona")
public class PersonaController {
	
	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;
	private int tipo;
	private int id;

	@GetMapping("/")
	public ModelAndView Persona() {
		ModelAndView mav = new ModelAndView("mantenimiento/persona");
		mav.addObject("persona", personaService.findByTipopersona(0));
		return mav;
	}
	
	@PostMapping("/addpersona")
	public String addPersona (@ModelAttribute(name="persona")Persona persona,Model model) {
		
		tipo = persona.getTipopersona();
		id = persona.getIdpersona();
		Persona per = personaService.findByidPersona(id);
		if(tipo != per.getTipopersona()) {
			personaService.cambiaPersona(tipo, id);
		}
		if(null != personaService.save(persona)) {
			model.addAttribute("result", 1);
		}else {			
		model.addAttribute("result", 0);
		}
		if(tipo == 1) {
			
			return "redirect:/transportista/";
		}else if (tipo == 2) {
			return "redirect:/contacto/";
		}else if (tipo == 3){
			return "redirect:/trabajador/";
		}else {
			return "redirect:/persona/";
		}
	}
	
	@GetMapping("/borrarpersona")
	public String borrarPersona(@RequestParam(name="id",required=true)int id,Model model) {
		
			personaService.delete(id);
		
		return "redirect:/persona/";
	}
}
