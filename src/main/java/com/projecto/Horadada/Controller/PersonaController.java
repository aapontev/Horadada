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
	private int v_tipopersona;
	private int v_idpersona;

	@GetMapping("/")
	public ModelAndView Persona() {
		ModelAndView mav = new ModelAndView("mantenimiento/persona");
		mav.addObject("persona", personaService.findByTipopersona(0));
		return mav;
	}

	@PostMapping("/addpersona")
	public String addPersona(@ModelAttribute(name = "persona") Persona persona, Model model) {

		v_tipopersona = persona.getTipopersona();
		v_idpersona = persona.getIdpersona();
		if (v_idpersona != 0) {
			Persona per = personaService.findByidPersona(v_idpersona);
			if (v_tipopersona != per.getTipopersona()) {
				personaService.update(v_tipopersona, v_idpersona);
			}
		}else {
			if (null != personaService.save(persona)) {
				model.addAttribute("result", 1);
			} else {
				model.addAttribute("result", 0);
			}
		}
		
		if (v_tipopersona == 1) {
			return "redirect:/transportista/";
		} else if (v_tipopersona == 2) {
			return "redirect:/contacto/";
		} else if (v_tipopersona == 3) {
			return "redirect:/trabajador/";
		} else {
			return "redirect:/persona/";
		}
	}

	@GetMapping("/borrarpersona")
	public String borrarPersona(@RequestParam(name = "id", required = true) int id, Model model) {

		personaService.delete(id);

		return "redirect:/persona/";
	}
}
