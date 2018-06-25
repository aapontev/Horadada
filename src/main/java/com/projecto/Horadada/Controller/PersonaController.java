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
	//private int v_tipopersona;
	//private int v_idpersona;

	@GetMapping
	public ModelAndView Persona() {
		ModelAndView mav = new ModelAndView("mantenimiento/persona");
		mav.addObject("persona", personaService.findByTipopersona(0));
		return mav;
	}

	@PostMapping("/addpersona")
	public String addPersona(@ModelAttribute(name = "persona") Persona persona, Model model) {
		
		Persona per = personaService.findByidPersona(persona.getIdpersona());
		int tipo = per.getTipopersona();
		if (null != personaService.save(persona)) {		
			if (persona.getTipopersona() != tipo) {
				personaService.cambiaPersona(persona.getTipopersona(), per.getIdpersona());
			}
		//} else {
		//	if (null != personaService.save(persona)) {
		//	} 
		}

		if (persona.getTipopersona() == 1) {
			return "redirect:/transportista";
		} else if (persona.getTipopersona() == 2) {
			return "redirect:/contacto";
		} else if (persona.getTipopersona() == 3) {
			return "redirect:/trabajador";
		} else {
			return "redirect:/persona";
		}
	}

	@GetMapping("/borrarpersona")
	public String borrarPersona(@RequestParam(name = "id", required = true) int id, Model model) {

		personaService.delete(id);

		return "redirect:/persona/";
	}
}
