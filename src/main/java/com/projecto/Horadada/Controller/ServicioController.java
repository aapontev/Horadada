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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.projecto.Horadada.Entity.Tiposervicio;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;

	@GetMapping("")
	public String servicios(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Tiposervicio> servicio = utilitarioservice.findAllServ(pageRequest);
		PageRender<Tiposervicio> pagerender = new PageRender<Tiposervicio>("/servicios", servicio);
		model.addAttribute("servicio", servicio);
		model.addAttribute("page", pagerender);
		return "utilitarios/servicio";
	}

	@GetMapping("/servicioform")
	public String servicioForm(@RequestParam("id") int id, Model model) {
		Tiposervicio servicio = new Tiposervicio();
		if (id != 0) {
			servicio = utilitarioservice.findByIdservicio(id);
		}
		model.addAttribute("servicio", servicio);
		return "crearEditar/servicio";
	}

	@GetMapping("/deleteservicio")
	public String deleteServicio(@RequestParam("id") int id) {
		utilitarioservice.deleteServ(id);
		return "redirect:/servicios";
	}
	
	@GetMapping(value = "/cargar-servicio/{term}", produces = { "application/json" })
	public @ResponseBody List<Tiposervicio> cargarServicio(@PathVariable String term) {
		return utilitarioservice.findByNombre(term);
	}
	
	@PostMapping("/addservicio")
	public String addServicio(@ModelAttribute("servicio") Tiposervicio servicio, Model model) {
		if (null != utilitarioservice.save(servicio)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/servicios";
	}
}
