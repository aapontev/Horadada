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
import com.projecto.Horadada.Entity.Ordencompra;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.service.OrdenCompraService;
import com.projecto.Horadada.service.TablaMaestraService;

@Controller
@RequestMapping("/ordencompra")
public class OrdenCompraController {
	
	@Autowired
	@Qualifier("ordencompraservice")
	private OrdenCompraService ordencompraservice;

	@Autowired
	@Qualifier("tablamaestraserviceimp")
	private TablaMaestraService tablamaestraservice;

	@GetMapping("")
	public ModelAndView OrdenCompra() {
		ModelAndView mav = new ModelAndView("documentacion/ordenCompraDoc");
		List<Ordencompra> ordenes = ordencompraservice.findAll();
		mav.addObject("ordenes", ordenes);
		return mav;
	}
	
	@GetMapping("/ordencompraform")
	public String redirectOrdenCompraForm(@RequestParam(name = "id", required = false) int id, Model model) {
		List<Tablamaestra> moneda = tablamaestraservice.findByIdtablamaestra("Hora002");
		//List<Solicitud> idsoli = solicitudService.getidsolicitud();
		Ordencompra ordencompra = new Ordencompra();
		int resu = 0;
		if (id != 0) {
			ordencompra = ordencompraservice.findbyid(id);
			resu = 1;
		}		
		model.addAttribute("resu", resu);
		//model.addAttribute("solici", idsoli);
		model.addAttribute("ordencompra", ordencompra);
		model.addAttribute("moneda", moneda);
		return "crearEditar/ordencompra";
	}
	
	@PostMapping("/addordencompra")
	public String addOrdencompra(@ModelAttribute(name = "cotizacion") Ordencompra ordencompra, Model model) {
		if (null != ordencompraservice.save(ordencompra)) {
			model.addAttribute("result", 1);
		} else {

			model.addAttribute("result", 0);
		}
		return "redirect:/ordencompra";
	}
	@GetMapping("/borrarordencompra")
	public String borrarCotizacion(@RequestParam(name = "id", required = true) int id, Model model) {
		ordencompraservice.delete(id);
		return "redirect:/ordencompra";
	}
}
