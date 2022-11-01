package com.projecto.Horadada.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projecto.Horadada.Entity.TablaMaestra;
import com.projecto.Horadada.Util.Constantes;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	
	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;
	
	@GetMapping("")
	public String Reportes(Model model) {
		
		List<TablaMaestra> documentos = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_DOCUMENTOS);
		model.addAttribute("documentos", documentos);
		return "reporte/reportes";
	}
}
