package com.projecto.Horadada.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reporte")
public class ReporteController {

	@GetMapping("/")
	public String Reportes() {
		return "reporte/reportes";
	}
}
