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

import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.service.PersonaService;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;
	
	@GetMapping("/")
	public ModelAndView Trabajador() {
		ModelAndView mav = new ModelAndView("mantenimiento/trabajador");
		mav.addObject("traba", personaService.findByTipopersona(3));
		return mav;
	}
	
	@GetMapping("/trabajadorform")
	public String redirectContactoForm(@RequestParam(name="id",required=false)int id,
			Model model) {
		Persona persona = new Persona();
		List<Persona> person = personaService.findByTipopersona(0);
		if(id != 0) {
			persona =personaService.findByidPersona(id);		
		}
		model.addAttribute("person", person);
		model.addAttribute("persona",persona);
		return "crearEditar/trabajador";
	}
}
