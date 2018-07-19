package com.projecto.Horadada.Controller;

import java.util.ArrayList;
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
import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Entity.Telefono;
import com.projecto.Horadada.service.PersonaService;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("persona")
public class PersonaController {

	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;

	@GetMapping
	public String Persona(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		model.addAttribute("persona", personaService.findByTipopersona(0));
		return "mantenimiento/persona";
	}

	@PostMapping("/addpersona")
	public String addPersona(@ModelAttribute(name = "persona") Persona persona, Model model,
			@RequestParam(name = "numerotelefono", required = false) String numeroTelefono,
			@RequestParam(name = "operador", required = false) int operador,
			@RequestParam(name = "tipotelefono", required = false) int tipotelefono) {

		List<Telefono> telefonomonitoreos = new ArrayList<Telefono>();
		Telefono telefono = new Telefono();
		if (null == utilitarioservice.findBynumerotelefono(numeroTelefono)) {
			telefono.setIdoperador(operador);
			telefono.setIdtipotelefono(tipotelefono);
			telefono.setNumerotelefono(numeroTelefono);
			telefonomonitoreos.add(telefono);
		}
		persona.setTelefonomonitoreos(telefonomonitoreos);
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
	public String redirectPersonaForm(@RequestParam(name = "idpersona", required = false) int id, Model model) {
		Persona per = new Persona();
		int resu = 0;
		List<Tablamaestra> persotip = utilitarioservice.findByIdtablamaestra("Hora006");
		List<Tablamaestra> tipodoc = utilitarioservice.findByIdtablamaestra("Hora013");
		List<Tablamaestra> operador = utilitarioservice.findByIdtablamaestra("Hora004");
		List<Tablamaestra> tipotelefono = utilitarioservice.findByIdtablamaestra("Hora005");
		if (id != 0) {
			per = personaService.findByidPersona(id);
			resu = 1;
		}
		model.addAttribute("resu", resu);
		model.addAttribute("tipopersona", persotip);
		model.addAttribute("operador", operador);
		model.addAttribute("tipotelefono", tipotelefono);
		model.addAttribute("tipodoc", tipodoc);
		model.addAttribute("persona", per);
		return "crearEditar/persona";
	}

	@GetMapping("/borrarpersona")
	public String borrarPersona(@RequestParam(name = "id", required = true) int id, Model model) {

		personaService.delete(id);

		return "redirect:/persona/";
	}
}
