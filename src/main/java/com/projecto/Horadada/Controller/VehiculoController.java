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
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Entity.Transportista;
import com.projecto.Horadada.Entity.Vehiculo;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.TransportistaService;
import com.projecto.Horadada.service.UtilitarioService;


@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;
	
	@Autowired
	@Qualifier("transportistaServiceImp")
	private TransportistaService transportistaservice;

	@GetMapping("")
	public String vehiculos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Vehiculo> vehiculo = utilitarioservice.findAll(pageRequest);
		PageRender<Vehiculo> pagerender = new PageRender<Vehiculo>("/Vehiculo", vehiculo);
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("page", pagerender);
		return "utilitarios/vehiculo";
	}

	@GetMapping("/vehiculoform")
	public String redirectPersonaForm(@RequestParam(name = "id", required = false) int id, Model model) {
		Vehiculo veh = new Vehiculo();
		List<Tablamaestra> marca = utilitarioservice.findByIdtablamaestra("");
		List<Tablamaestra> modelo = utilitarioservice.findByIdtablamaestra("");
		List<Tablamaestra> aseguradora = utilitarioservice.findByIdtablamaestra("");
		List<Transportista> transportista = transportistaservice.findByAll();
		if (id != 0) {
			veh = utilitarioservice.findByidvehiculo(id);

		}
		model.addAttribute("vehiculo", veh);
		model.addAttribute("trasnportista", transportista);
		model.addAttribute("marca", marca);
		model.addAttribute("modelo", modelo);
		model.addAttribute("aseguradora", aseguradora);
		return "crearEditar/vehiculo";
	}

	@GetMapping("/deletevehiculo")
	public String borrarPersona(@RequestParam(name = "id", required = true) int id, Model model) {
		utilitarioservice.deleteVeh(id);
		return "redirect:/persona/";
	}

	@PostMapping("/addpersona")
	public String addPersona(@ModelAttribute(name = "vehiculo") Vehiculo vehiculo, Model model) {
		if (null != utilitarioservice.save(vehiculo)) {
			model.addAttribute("resu", 1);
		} else {
			model.addAttribute("resu", 0);
		}
		return "redirect:/vehiculo";
	}
}
