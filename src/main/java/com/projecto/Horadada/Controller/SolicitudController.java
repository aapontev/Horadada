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
import com.projecto.Horadada.Entity.Cliente;
import com.projecto.Horadada.Entity.Solicitud;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.ClienteService;
import com.projecto.Horadada.service.SolicitudService;

@Controller
@RequestMapping("/solicitud")
public class SolicitudController {

	@Autowired
	@Qualifier("solicitudServiceimp")
	private SolicitudService solicitudService;

	@Autowired
	@Qualifier("clienteServiceImp")
	private ClienteService clienteService;

	@GetMapping("")
	public String redirectSolicitud(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Solicitud> solicitud = solicitudService.findAll(pageRequest);
		PageRender<Solicitud> pagerender = new PageRender<Solicitud>("/solicitud", solicitud);
		model.addAttribute("solicitud", solicitud);
		model.addAttribute("page", pagerender);
		return "documentacion/solicitudDoc";
	}

	@GetMapping("/solicitudform")
	public String redirectSolicitudForm(@RequestParam(name = "id", required = false) int id, Model model) {
		Solicitud solicitud = new Solicitud();
		int resu = 1;
		List<Cliente> cliente = clienteService.findByAll();
		if (id != 0) {
			solicitud = solicitudService.findByidsolicitud(id);
			resu = 0;
		}
		model.addAttribute("res", resu);
		model.addAttribute("solicitud", solicitud);
		model.addAttribute("cliente", cliente);
		return "crearEditar/solicitud";
	}

	@PostMapping("/addsolicitud")
	public String addSolicitud(@ModelAttribute(name = "solicitud") Solicitud solicitud, Model model) {
		if (null != solicitudService.save(solicitud)) {
			model.addAttribute("result", 1);
		} else {

			model.addAttribute("result", 0);
		}
		return "redirect:/solicitud";
	}

	@GetMapping("/borrarsolicitud")
	public String borrarSolicitud(@RequestParam(name = "id", required = true) int id, Model model) {
		solicitudService.delete(id);
		return "redirect:/documentacion/solicitud";
	}

	
}
