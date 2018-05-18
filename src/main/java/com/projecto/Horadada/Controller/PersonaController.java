package com.projecto.Horadada.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.service.PersonaService;

@Controller
@RequestMapping("persona")
public class PersonaController {
	
	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;
	private int tipo;

	@PostMapping("/addpersona")
	public String addPersona (@ModelAttribute(name="persona")Persona persona,Model model) {
		tipo = persona.getTipopersona();
		
		if(null != personaService.save(persona)) {
			model.addAttribute("result", 1);
		}else {			
		model.addAttribute("result", 0);
		}
		if(tipo== 1) {
			return "redirect:/mantenimiento/transportista";
		}else if (tipo == 2) {
			return "redirect:/mantenimiento/contacto";
		}else {
			return "redirect:/mantenimiento/trabajador";
		}
	}
}
