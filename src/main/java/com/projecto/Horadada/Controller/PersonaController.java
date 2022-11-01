package com.projecto.Horadada.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.Entity.TablaMaestra;
import com.projecto.Horadada.Entity.TelefonoMonitoreo;
import com.projecto.Horadada.Util.Constantes;
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
		Pageable pageRequest = PageRequest.of(page, 5);
		
		//Persona per = new Persona();
		model.addAttribute("persona", personaService.findAll(pageRequest));
		return "mantenimiento/persona";
	}

	@PostMapping("/addpersona")
	public String addPersona(@ModelAttribute(name = "persona") Persona persona,
			 Model model,	
	@RequestParam(name = "numerotelefono", required = false) String
	  numeroTelefono,	  
	  @RequestParam(name = "operador", required = false) int operador,	  
	  @RequestParam(name = "tipotelefono", required = false) int tipotelefono
	 
	) {
		System.out.println("fechaNac :" + persona.getFechaNacimiento());
		String[] nombreCompleto = persona.getNombreCompleto().split(" ");
		if (nombreCompleto.length == 4) {
			persona.setPrimerApellido(nombreCompleto[0]);
			persona.setSegundoApellido(nombreCompleto[1]);
			persona.setPrimerNombre(nombreCompleto[2]);
			persona.setSegundoNombre(nombreCompleto[3]);
			}
		else if(nombreCompleto.length == 3) {
			persona.setPrimerApellido(nombreCompleto[0]);
			persona.setSegundoApellido(nombreCompleto[1]);
			persona.setPrimerNombre(nombreCompleto[2]);
		}
		else if(nombreCompleto.length == 2) {
			persona.setPrimerApellido(nombreCompleto[0]);
			persona.setSegundoApellido(nombreCompleto[1]);
		}else {
			persona.setPrimerApellido(nombreCompleto[0]);			
		}
		if (null != personaService.save(persona)) {
			//personaService.cambiaPersona(persona.getTipoPersona(), persona.getIdPersona());
			model.addAttribute("resu", 1);
		} else {
			model.addAttribute("resu", 0);
		}
		

		List<TelefonoMonitoreo> telefonomonitoreos = new ArrayList<TelefonoMonitoreo>();
		TelefonoMonitoreo telefono = new TelefonoMonitoreo();		
		persona.setTelefonoMonitoreos(telefonomonitoreos);
		if (utilitarioservice.findBynumerotelefono(telefono.getNumeroTelefono()) == null) {
			  telefono.setIdOperador(operador);
			  telefono.setIdTipoTelefono(tipotelefono);
			  telefono.setNumeroTelefono(numeroTelefono);
			 utilitarioservice.save(telefono);
}
		return "redirect:/persona";

		/*if (persona.getTipoPersona() == 1) {
			return "redirect:/transportista";
		} else if (persona.getTipoPersona() == 2) {
			return "redirect:/contacto";
		} else if (persona.getTipoPersona() == 3) {
			return "redirect:/trabajador";
		} else {
			return "redirect:/persona";
		}*/
	}

	@GetMapping("/personaform")
	public String redirectPersonaForm(@RequestParam(name = "idpersona", required = false) int id, Model model) {
		Persona per = new Persona();
		int resu = 0;
		List<TablaMaestra> persotip = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_TIPO_PERSONA);
		List<TablaMaestra> tipodoc = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_TIPO_DOC);
		List<TablaMaestra> operador = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_OPERADOR_TEL);
		List<TablaMaestra> tipotelefono = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_TIPO_TEL);
		if (id != 0) {
			per = personaService.findByidPersona(id);
			System.out.print("esto muestra" + per.getFechaNacimiento());
			resu = 1;
		}
		model.addAttribute("resu", resu);
		model.addAttribute("tipopersona", persotip);
		model.addAttribute("operador", operador);
		model.addAttribute("tipotelefono", tipotelefono);
		model.addAttribute("tipodoc", tipodoc);
		model.addAttribute("persona", per);
		//model.addAttribute("telefono", utilitarioservice.findBynumerotelefono(""));
		return "crearEditar/persona";
	}

	@GetMapping("/borrarpersona")
	public String borrarPersona(@RequestParam(name = "id", required = true) int id, Model model) {

		personaService.delete(id);

		return "redirect:/persona/";
	}
}
