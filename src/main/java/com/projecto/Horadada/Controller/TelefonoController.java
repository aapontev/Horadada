package com.projecto.Horadada.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.service.TelefonoService;

@Controller
@RequestMapping("telefono")
public class TelefonoController {

	@Autowired
	@Qualifier("telefonoserviceimp")
	private TelefonoService telefonoservice;

	@GetMapping
	public ModelAndView listaTelefono() {
		ModelAndView mav = new ModelAndView("mantenimiento/telefono");
		mav.addObject("telefono", telefonoservice.findByAll());
		return mav;
	}

	@GetMapping("/personaform")
	public String redirectPersonaForm(@RequestParam(name = "idpersona", required = false) int id, Model model) {
		Persona per = new Persona();
		int resu = 0;
		//List<Tablamaestra> persotip = tablaService.findByIdtablamaestra("Hora006");
		//List<Tablamaestra> tipodoc = tablaService.findByIdtablamaestra("Hora013");
		if (id != 0) {
		//	per = personaService.findByidPersona(id);
			resu = 1;
		}
		model.addAttribute("resu", resu);
		//model.addAttribute("tipopersona", persotip);
		//model.addAttribute("tipodoc", tipodoc);
		model.addAttribute("persona", per);
		return "crearEditar/persona";
	}
}
/*
 * Telefono telefono = new Telefono();
 * telefono.setNumerotelefono(persona.getTelefono());
 * telefono.setPersona(persona); if(null != telefonoservice.save(telefono)) {
 * model.addAttribute("resu", 1); }
 */