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
import com.projecto.Horadada.Entity.Contacto;
import com.projecto.Horadada.service.ContactoService;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

	
	@Autowired
	@Qualifier("contactoServiceImp")
	private ContactoService contactoService;

	@GetMapping("/contactoform")
	public String redirectContactoForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		Contacto contacto = new Contacto();
		if(id != 0) {
			contacto =contactoService.findByidcontacto(id);		
		}
		model.addAttribute("contacto",contacto);
		return "crearEditar/contacto";
	}
	
	@PostMapping("/addcontacto")
	public String addContacto (@ModelAttribute(name="contacto")Contacto contacto,Model model) {
		if(null != contactoService.save(contacto)) {
			model.addAttribute("result", 1);
		}else {			
		
		model.addAttribute("result", 0);
		}
		return "redirect:/mantenimiento/contacto";
	}
	
	@GetMapping("/borrarcontacto")
	public String borrarContacto(@RequestParam(name="id",required=true)int id,Model model) {
		
			contactoService.delete(id);
		
		return "redirect:/mantenimiento/contacto";
	}
}
