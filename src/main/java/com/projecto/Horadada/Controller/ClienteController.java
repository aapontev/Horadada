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
import com.projecto.Horadada.Entity.Cliente;
import com.projecto.Horadada.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	@Qualifier("clienteServiceImp")
	private ClienteService clienteService;

	@GetMapping("/clienteform")
	public String redirectClienteForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		Cliente cliente = new Cliente();
		if(id != 0) {
			cliente = clienteService.findByidcliente(id);		
		}
		model.addAttribute("cliente",cliente);
		return "crearEditar/cliente";
	}
	
	@PostMapping("/addcliente")
	public String addCliente (@ModelAttribute(name="cliente") Cliente cliente,Model model) {
		if(null != clienteService.save(cliente)) {
			model.addAttribute("result", 1);
		}else {			
		
		model.addAttribute("result", 0);
		}
		return "redirect:/mantenimiento/cliente";
	}
	
	@GetMapping("/borrarcliente")
	public String borrarCliente(@RequestParam(name="id",required=true)int id) {
		clienteService.delete(id);
		return "redirect:/mantenimiento/cliente";
	}
}
