package com.projecto.Horadada.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.Entity.Usuarios;

@Controller
public class LoginController {
	
	//private LoginConstantes cons;

	@GetMapping("/")
	public String redirctLogin() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error",required=false)String error,@RequestParam(name="logout",required=false)String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("credencialUsuario", new Usuarios());
		return "login";
	}
	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name="credencialUsuario")Usuarios usuario) {
		if(usuario.getUsuario().equals("usu") && usuario.getPassword().equals("con")) {
		return "principal";
	}
	return "redirect:/login?error";	
	}
	@GetMapping("/principal")
	public String principal() {
		return "principal";
	}
	@GetMapping("/bienvenido")
	public String principalWeb() {
		return "pageWeb/bienvenido";
	}
}
