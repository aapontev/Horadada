package com.projecto.Horadada.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.Model.Usuarios;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class LoginController {
    
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	@GetMapping("/")
	public String redirctLogin() {
		return "redirect:/index";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("credencialUsuario", new Usuarios());
		return "index";
	}

	@GetMapping("/index")
	public String index() {
		return "principal";
	}

}
