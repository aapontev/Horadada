package com.projecto.Horadada.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projecto.Horadada.Entity.Cotizacion;
import com.projecto.Horadada.Entity.Ordencompra;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.CotizacionService;
import com.projecto.Horadada.service.OrdenCompraService;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/ordencompra")
public class OrdenCompraController {
	
	@Autowired
	@Qualifier("ordencompraservice")
	private OrdenCompraService ordencompraservice;

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;

	@Autowired
	@Qualifier("cotizacionserviceimp")
	private CotizacionService cotizacionservice;
	
	@GetMapping("")
	public String OrdenCompra(@RequestParam(name = "page", defaultValue = "0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Ordencompra> ordenes = ordencompraservice.findAll(pageRequest);
		PageRender<Ordencompra> pagerender = new PageRender<Ordencompra>("/documentacion/ordenCompraDoc",ordenes);
		model.addAttribute("ordenes", ordenes);
		model.addAttribute("page", pagerender);
		return "documentacion/ordenCompraDoc";
	}
	
	@GetMapping("/ordencompraform")
	public String redirectOrdenCompraForm(@RequestParam(name = "id", required = false) int id, Model model) {
		List<Tablamaestra> moneda = utilitarioservice.findByIdtablamaestra("Hora002");
		List<Cotizacion> cotizacion = cotizacionservice.findByaprobado(0);
		Ordencompra ordencompra = new Ordencompra();
		int resu = 0;
		if (id != 0) {
			ordencompra = ordencompraservice.findbyid(id);
			resu = 1;
		}		
		model.addAttribute("resu", resu);
		model.addAttribute("ordencompra", ordencompra);
		model.addAttribute("moneda", moneda);
		model.addAttribute("cotizacion", cotizacion);
		return "crearEditar/ordencompra";
	}
	
	@PostMapping("/addordencompra")
	public String addOrdencompra(@ModelAttribute(name = "ordencompra") Ordencompra ordencompra, Model model) {
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
