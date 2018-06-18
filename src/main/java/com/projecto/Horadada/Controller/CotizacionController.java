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
import com.projecto.Horadada.Entity.Cotizacion;
import com.projecto.Horadada.Entity.Cotizaciondetalle;
import com.projecto.Horadada.Entity.Solicitud;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.service.CotizacionDetalleService;
import com.projecto.Horadada.service.CotizacionService;
import com.projecto.Horadada.service.SolicitudService;
import com.projecto.Horadada.service.TablaMaestraService;

@Controller
@RequestMapping("/cotizacion")
public class CotizacionController {	

	@Autowired
	@Qualifier("cotizacionserviceimp")
	private CotizacionService cotizacionservice;

	@Autowired
	@Qualifier("cotizaciondetalleservice")
	private CotizacionDetalleService cotizaciondetalleservice;

	@Autowired
	@Qualifier("tablamaestraserviceimp")
	private TablaMaestraService tablamaestraservice;

	@Autowired
	@Qualifier("solicitudServiceimp")
	private SolicitudService solicitudService;
	
	@GetMapping("")
	public ModelAndView redirectCotizacion() {
		ModelAndView mav = new ModelAndView("documentacion/cotizacionDoc");
		List<Cotizacion> cotiza = cotizacionservice.findAll();
		mav.addObject("cotiza", cotiza);
		return mav;
	}

	@GetMapping("/cotizacionform")
	public String redirectCotizacionForm(@RequestParam(name = "id", required = false) int id, Model model) {
		List<Tablamaestra> moneda = tablamaestraservice.findByIdtablamaestra("Hora002");
		List<Solicitud> idsoli = solicitudService.getidsolicitud();
		Cotizacion cotizacion = new Cotizacion();
		int resu = 0;
		if (id != 0) {
			cotizacion = cotizacionservice.findbyid(id);
			resu = 1;
		}		
		model.addAttribute("resu", resu);
		model.addAttribute("solici", idsoli);
		model.addAttribute("cotizacion", cotizacion);
		model.addAttribute("moneda", moneda);
		return "crearEditar/cotizacion";
	}

	@PostMapping("/addcotizacion")
	public String addCotizacion(@ModelAttribute(name = "cotizacion") Cotizacion cotizacion, Model model) {
		if (null != cotizacionservice.save(cotizacion)) {
			model.addAttribute("result", 1);
		} else {

			model.addAttribute("result", 0);
		}
		return "redirect:/cotizacion";
	}

	@GetMapping("/borrarcotizacion")
	public String borrarCotizacion(@RequestParam(name = "id", required = true) int id, Model model) {
		cotizacionservice.delete(id);
		return "redirect:/cotizacion";
	}

	@GetMapping("/cotizaciondetalle")
	public String redirectCotizacionDetalle(@RequestParam(name = "id", required = false) int id, Model model) {
		Cotizacion cotizacion = cotizacionservice.findbyid(id);
		List<Cotizaciondetalle> cotizaDeta = cotizaciondetalleservice.findBycotizacion(cotizacion);

		model.addAttribute("cotizadeta", cotizaDeta);
		model.addAttribute("cotizaid", id);
		return "documentacion/cotizacionDetalle";
	}
	
	@GetMapping("/cotizaciondetalleform")
	public String redirectCotizacionDetalleform(@RequestParam(name = "id", required = false) int id,
			@RequestParam(name = "item", required = false) int item, Model model) {
		
		List<Tablamaestra> medida = tablamaestraservice.findByIdtablamaestra("Hora014");		
		Cotizaciondetalle cotizaciondetalle = new Cotizaciondetalle();
		Cotizacion cotizacion = cotizacionservice.findbyid(id);
		
		if(item != 0) {
		 cotizaciondetalle = cotizaciondetalleservice.findByItem(item);
		}
		model.addAttribute("medida", medida);
		model.addAttribute("cotizacion", cotizacion);
		model.addAttribute("cotizadeta", cotizaciondetalle);
		return "crearEditar/cotizacionDetalle";
	}
	
	@PostMapping("/addcotizaciondetalle")
	public String addCotizacionDetalle(@ModelAttribute(name = "cotizaciondetalle") Cotizaciondetalle cotidetalle, Model model) {

		if (null != cotizaciondetalleservice.save(cotidetalle)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/cotizacion";
	}
}
