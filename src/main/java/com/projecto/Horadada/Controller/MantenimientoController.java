package com.projecto.Horadada.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {

	@GetMapping("/cliente")
	public String Cliente() {
		return "mantenimiento/cliente";
	}
	
	@GetMapping("/contacto")
	public String Contacto() {
		return "mantenimiento/contacto";
	}
	
	@GetMapping("/trabajador")
	public String Trabajador() {
		return "mantenimiento/trabajador";
	}
	
	@GetMapping("/transportista")
	public String Transportista() {
		return "mantenimiento/transportista";
	}
}
