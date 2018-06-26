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
import com.projecto.Horadada.service.TablaMaestraService;

@Controller
@RequestMapping("/tablamaestra")
public class TablaMaestraController {

	@Autowired
	@Qualifier("tablamaestraserviceimp")
	private TablaMaestraService tablaService;

	int resu =0;
	@GetMapping("")
	public ModelAndView TablaMaestra(@RequestParam(name="tipotabla",required=false)String tipotabla) {
		resu=0;
		List<Tablamaestra> tablas = tablaService.findByIdtablamaestra(tipotabla);
		List<String> valMa = tablaService.gettablamaestra();
		ModelAndView mav = new ModelAndView("mantenimiento/tablaMaestra");
		if(tipotabla != null) {
			resu = 1 ;
		}
		mav.addObject("resu", resu);
		mav.addObject("valMa", valMa);
		mav.addObject("tablas", tablas);
		return mav;
	}
}
