package com.projecto.Horadada.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.service.TablaMaestraService;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	
	@Autowired
	@Qualifier("tablamaestraserviceimp")
	private TablaMaestraService tablamaestraservice;
	
	@GetMapping("")
	public String Reportes(Model model) {
		
		List<Tablamaestra> documentos = tablamaestraservice.findByIdtablamaestra("Hora009");
		model.addAttribute("documentos", documentos);
		return "reporte/reportes";
	}
}
