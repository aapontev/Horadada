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
import com.projecto.Horadada.Entity.Despacho;
import com.projecto.Horadada.Entity.Direccion;
import com.projecto.Horadada.Entity.Ordencompra;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.DespachoService;
import com.projecto.Horadada.service.OrdenCompraService;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/despacho")
public class DespachoController {

	@Autowired
	@Qualifier("despachoservice")
	private DespachoService despachoservice;

	@Autowired
	@Qualifier("ordencompraservice")
	private OrdenCompraService ordencompraservice;

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;

	@GetMapping("")
	public String despachos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Despacho> despacho = despachoservice.findAll(pageRequest);
		PageRender<Despacho> pagerender = new PageRender<Despacho>("/despacho", despacho);
		model.addAttribute("despachos", despacho);
		model.addAttribute("page", pagerender);
		return "documentacion/despachoDoc";
	}

	@GetMapping("/despachoform")
	public String despachoForm(@RequestParam(name = "id", required = false) int id, Model model) {
		Despacho despacho = new Despacho();
		List<Ordencompra> ordencompra = ordencompraservice.findByestadoordencompra(1);
		List<Direccion> direccion = utilitarioservice.findAll();
		int resu = 0;
		if (id != 0) {
			despacho = despachoservice.findByiddespacho(id);
			resu = 1;
		}
		model.addAttribute("ordencompra", ordencompra);
		model.addAttribute("despacho", despacho);
		model.addAttribute("resu", resu);
		model.addAttribute("direccion", direccion);
		return "crearEditar/despacho";
	}

	@PostMapping("/adddespacho")
	public String addDespacho(@ModelAttribute(name = "despacho") Despacho despacho, Model model) {
		Ordencompra orcom = despacho.getOrdencompra();
		Ordencompra orden = ordencompraservice.findbyid(orcom.getIdordencompra());
		orden.setEstadoordencompra(2);
		despacho.setOrdencompra(orden);
		if (null != despachoservice.save(despacho)) {
			model.addAttribute("result", 1);
		} else {

			model.addAttribute("result", 0);
		}
		return "redirect:/despacho";
	}

}
