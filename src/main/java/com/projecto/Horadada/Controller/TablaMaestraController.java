package com.projecto.Horadada.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.Horadada.service.TablaMaestraService;

@Controller
@RequestMapping("/tablaMaestra")
public class TablaMaestraController {

	@Autowired
	@Qualifier("tablamaestraserviceimp")
	private TablaMaestraService tablaService;


	@GetMapping("/")
	public ModelAndView TablaMaestra() {
		List<String> valMa = tablaService.gettablamaestra();
		ModelAndView mav = new ModelAndView("mantenimiento/tablaMaestra");
		mav.addObject("valMa", valMa);
		return mav;
	}

}
