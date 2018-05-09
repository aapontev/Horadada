package com.projecto.Horadada.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {

	@GetMapping("/transportista")
	public String Transportista() {
		return "mantenimiento/transportista";
	}
}
