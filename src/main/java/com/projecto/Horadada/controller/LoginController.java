package com.projecto.Horadada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	@GetMapping("/login")
	public String vistaLogin(Model model,
			@RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout) {
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		//model.addAttribute("credencialUsuario", new CredencialUsuario());
		return "login";
	}
	@GetMapping({"/loginsuccess","/"})
	public String loginCheck() {
		return "index";
		
	}
}
