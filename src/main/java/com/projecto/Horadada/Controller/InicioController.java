package com.projecto.Horadada.Controller;


import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projecto.Horadada.Model.Usuarios;

@Controller
public class InicioController {


	@GetMapping("/logint")
	public String showLoginForm(Model model, Principal principal, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout, RedirectAttributes flas) {
		
		model.addAttribute("logout", logout);
		model.addAttribute("credencialUsuario", new Usuarios());
		if (principal != null) {
			flas.addFlashAttribute("info", "ya inicio sesion anteriormente");
		}
		if (error != null) {
			model.addAttribute("error", "tiene problemas de autentificacion por favor vuelva a intentarlo");
		}
			
		return "login";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
