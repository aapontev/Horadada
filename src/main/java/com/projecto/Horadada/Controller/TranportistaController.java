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

import com.projecto.Horadada.Entity.Transportista;
import com.projecto.Horadada.service.TransportistaService;

@Controller
@RequestMapping("/transportista")
public class TranportistaController {

	@Autowired
	@Qualifier("transportistaServiceImp")
	private TransportistaService transportistaservice;
	

	@GetMapping("/transportistaform")
	public String redirectTransportistaForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		Transportista transportista = new Transportista();
		if(id != 0) {
			transportista = transportistaservice.findByidtransportista(id);		
		}
		model.addAttribute("transportista",transportista);
		return "crearEditar/transportista";
	}
	
	@PostMapping("/addtransportista")
	public String addTransportista (@ModelAttribute(name="transportista")Transportista transportista,Model model) {
		if(null != transportistaservice.save(transportista)) {
			model.addAttribute("result", 1);
		}else {			
		
		model.addAttribute("result", 0);
		}
		return "redirect:/mantenimiento/transportista";
	}
	
	@GetMapping("/borrartrasnportista")
	public String borrarTransportista(@RequestParam(name="id",required=true)int id,Model model) {
		
			transportistaservice.delete(id);
		
		return "redirect:/mantenimiento/transportista";
	}
}
