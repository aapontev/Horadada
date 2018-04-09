package com.projecto.Horadada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.constantes.ConstantView;
import com.projecto.Horadada.model.UsuarioPrueba;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String Redireccionamiento() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String vistaLogin(Model model,
			@RequestParam(name="error",required=false)String error,
			@RequestParam(name="error",required=false)String logout	) {
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		model.addAttribute("usuarioPrueba", new UsuarioPrueba());
		return ConstantView.LOGIN;
	}

	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="usuarioPrueba")UsuarioPrueba usu ) {
		
		if(usu.getUsername().equals("user") && usu.getContrase().equals("user")) {
			return ConstantView.INDEX;
		}
		return "redirect:/login?error";
		
	}	
}
