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
import com.projecto.Horadada.service.PersonaService;
import com.projecto.Horadada.service.TablaMaestraService;

@Controller
@RequestMapping("persona")
public class PersonaController {

	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;

	@Autowired
	@Qualifier("tablamaestraserviceimp")
	private TablaMaestraService tablaService;
	// private int v_tipopersona;
	// private int v_idpersona;

	@GetMapping
	public ModelAndView Persona() {
		ModelAndView mav = new ModelAndView("mantenimiento/persona");
		mav.addObject("persona", personaService.findByTipopersona(0));
		return mav;
	}

	@PostMapping("/addpersona")
	public String addPersona(@ModelAttribute(name = "persona") Persona persona, Model model) {
			if (null != personaService.save(persona)) {
					personaService.cambiaPersona(persona.getTipopersona(), persona.getIdpersona());				
				model.addAttribute("resu", 1);
			} else {
				model.addAttribute("resu", 0);
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
	@GetMapping("/personaform")
	public String redirectPersonaForm(@RequestParam(name="idpersona",required=false)int id,
			Model model) {
		Persona per = new Persona();
		int resu = 0;
		List<Tablamaestra> persotip = tablaService.findByIdtablamaestra("Hora006");   
		List<Tablamaestra> tipodoc = tablaService.findByIdtablamaestra("Hora013");
		if(id != 0) {
			 per = personaService.findByidPersona(id);	
			 resu =1;
		}
		model.addAttribute("resu", resu);
		model.addAttribute("tipopersona",persotip);
		model.addAttribute("tipodoc",tipodoc);
		model.addAttribute("persona",per);
		return "crearEditar/persona";
	}
	@GetMapping("/borrarpersona")
	public String borrarPersona(@RequestParam(name = "id", required = true) int id, Model model) {

		personaService.delete(id);

		return "redirect:/persona/";
	}
}
