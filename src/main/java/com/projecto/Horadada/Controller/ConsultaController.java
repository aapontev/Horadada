package com.projecto.Horadada.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;
	
	@GetMapping("")
	public String consulta(Model model) {
		List<Tablamaestra> documentos = utilitarioservice.findByIdtablamaestra("Hora009");
		model.addAttribute("documentos", documentos);
		return "consulta/consultar";
	}
}
