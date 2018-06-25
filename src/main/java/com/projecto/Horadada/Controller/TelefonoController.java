package com.projecto.Horadada.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.Horadada.service.TelefonoService;

@Controller
@RequestMapping("telefono")
public class TelefonoController {

	@Autowired
	@Qualifier("telefonoserviceimp")
	private TelefonoService telefonoservice;
	@GetMapping
	public ModelAndView listaTelefono() {
		ModelAndView mav = new ModelAndView("mantenimiento/telefono");
		mav.addObject("telefono", telefonoservice.findByAll());
		return mav;
	}
}
