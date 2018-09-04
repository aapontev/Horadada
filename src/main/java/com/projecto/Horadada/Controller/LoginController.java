package com.projecto.Horadada.Controller;


import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projecto.Horadada.Model.Usuarios;

@Controller
public class LoginController {

	@GetMapping("/")
	public String redirctLogin() {
		return "redirect:/login";
	}

	@GetMapping("/login")
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

	/*@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name = "credencialUsuario") Usuarios usuario) {
		if (usuario.getUsuario().equals("usu") && usuario.getPassword().equals("con")) {
			return "index";
		}
		return "redirect:/login?error";
	}*/

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/bienvenido")
	public String principalWeb() {
		return "pageWeb/bienvenido";
	}
}
