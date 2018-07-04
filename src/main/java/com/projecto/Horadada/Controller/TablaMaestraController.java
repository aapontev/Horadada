package com.projecto.Horadada.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/tablamaestra")
public class TablaMaestraController {

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;

	int resu =0;
	@GetMapping("")
	public ModelAndView TablaMaestra(@RequestParam(name="tipotabla",required=false)String tipotabla) {
		resu=0;
		List<Tablamaestra> tablas = utilitarioservice.findByIdtablamaestra(tipotabla);
		List<String> valMa = utilitarioservice.gettablamaestra();
		ModelAndView mav = new ModelAndView("utilitarios/tablaMaestra");
		if(tipotabla != null) {
			resu = 1 ;
		}
		mav.addObject("resu", resu);
		mav.addObject("valMa", valMa);
		mav.addObject("tablas", tablas);
		return mav;
	}
}
