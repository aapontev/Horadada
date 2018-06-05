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

import com.projecto.Horadada.Entity.Cliente;
import com.projecto.Horadada.Entity.Contacto;
import com.projecto.Horadada.Entity.Persona;
import com.projecto.Horadada.service.ClienteService;
import com.projecto.Horadada.service.ContactoService;
import com.projecto.Horadada.service.PersonaService;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

	
	@Autowired
	@Qualifier("contactoServiceImp")
	private ContactoService contactoService;
	
	@Autowired
	@Qualifier("clienteServiceImp")
	private ClienteService clienteService;
	
	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;
	
	@GetMapping("/")
	public ModelAndView Contacto() {
		ModelAndView mav = new ModelAndView("mantenimiento/contacto");
		// mav.addObject("cont",personaService.findByTipopersona(cm.TIPOPERCLIEN));
		mav.addObject("cont", contactoService.findByAll());
		return mav;
	}

	@GetMapping("/contactoform")
	public String redirectContactoForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		Contacto contacto = new Contacto();
		List<Persona> persona = personaService.findByTipopersona(0);
		List<Cliente> cliente = clienteService.findByAll(); 
		if(id != 0) {
			contacto =contactoService.findByidcontacto(id);		
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("contacto",contacto);
		model.addAttribute("persona", persona);
		return "crearEditar/contacto";
	}
	
	@PostMapping("/addcontacto")
	public String addContacto (@ModelAttribute(name="contacto")Contacto contacto,Model model) {
		if(null != contactoService.save(contacto)) {
			model.addAttribute("result", 1);
		}else {			
		
		model.addAttribute("result", 0);
		}
		return "redirect:/contacto/";
	}
	
	@GetMapping("/borrarcontacto")
	public String borrarContacto(@RequestParam(name="id",required=true)int id,Model model) {
		
			contactoService.delete(id);
		
		return "redirect:/contacto/";
	}
}
