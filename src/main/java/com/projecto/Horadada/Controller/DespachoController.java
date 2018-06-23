package com.projecto.Horadada.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.projecto.Horadada.Entity.Despacho;
import com.projecto.Horadada.Entity.Ordencompra;
import com.projecto.Horadada.service.DespachoService;
import com.projecto.Horadada.service.OrdenCompraService;

@Controller
@RequestMapping("/despacho")
public class DespachoController {

	@Autowired
	@Qualifier("despachoservice")
	private DespachoService despachoservice;
	
	@Autowired
	@Qualifier("ordencompraservice")
	private OrdenCompraService ordencompraservice;

	@GetMapping("")
	public ModelAndView despachos() {
		ModelAndView mav = new ModelAndView("documentacion/despachoDoc");
		List<Despacho> despachos = despachoservice.findAll();
		mav.addObject("despachos", despachos);
		return mav;
	}
	
	@GetMapping("/despachoform")
	public String despachoForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		Despacho despacho = new Despacho();
		List<Ordencompra> ordencompra = ordencompraservice.findByestadoordencompra(1);
		int resu= 0;
		if(id != 0) {
			despacho =despachoservice.findByiddespacho(id);	
			resu = 1;
		}
		
		model.addAttribute("ordencompra", ordencompra);
		model.addAttribute("despacho",despacho);
		model.addAttribute("resu",resu);
		return "crearEditar/despacho";
	}
	
	@PostMapping("/adddespacho")
	public String addDespacho(@ModelAttribute(name = "despacho") Despacho despacho, Model model) {
		if (null != despachoservice.save(despacho)) {
			model.addAttribute("result", 1);
		} else {

			model.addAttribute("result", 0);
		}
		return "redirect:/despacho";
	}
	
}
