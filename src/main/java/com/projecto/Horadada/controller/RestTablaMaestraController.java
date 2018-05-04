package com.projecto.Horadada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Service.PersonaService;
import com.projecto.Horadada.Service.TablaMaestraService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RestTablaMaestraController {
	
	@Autowired
	private TablaMaestraService tmService;
	
	@Autowired
	private PersonaService perServ;
	
		
	@GetMapping("/tablaMaestra")
	public List<Tablamaestra> Index() {
		return tmService.findAll();
	}
	
	@GetMapping("/tablaMaestraId")
	public Tablamaestra porId() {
		
		return tmService.findByTablamaestraId(101);
	}
	
	@PostMapping("/perso")
	public void addPerson() {
		perServ.inOnlyTest(1);
	}


/*@PostMapping("/addcontacto")
public String addContact (@ModelAttribute(name="contactoModel") ContactoModel contactModel,Model model) {
	if(null != contactoService.addContacto(contactModel)) {
		model.addAttribute("result", 1);
	}else {			
	
	model.addAttribute("result", 0);
	}
	return "redirect:/contacto/showcontactos";
}*/
}
