package com.projecto.Horadada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.constantes.ConstantView;

@Controller
public class LoginController {

	/*@GetMapping("/")
	public String redirecionaLogin() {
		return "redirect:/login";
	}*/
	
	@GetMapping("/login")
	public String vistaLogin(Model model,
			@RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout) {
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		//model.addAttribute("credencialUsuario", new CredencialUsuario());
		return ConstantView.LOGIN;
	}
	@GetMapping({"/loginsuccess","/"})
	public String loginCheck() {
		return "redirect:/contacto/showcontactos";
		
	}
	
	/*@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute("credencialUsuario")CredencialUsuario usuario) {
		if(usuario.getUsuario().equals("usu") && usuario.getContrasena().equals("con")) {
			return "redirect:/contacto/showcontactos";
		}
		return "redirect:/login?error";
	}*/
	
}
