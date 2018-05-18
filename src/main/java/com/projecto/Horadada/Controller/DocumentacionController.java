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
import com.projecto.Horadada.Entity.Solicitud;
import com.projecto.Horadada.service.SolicitudService;

@Controller
@RequestMapping("/documentacion")
public class DocumentacionController {
	
	@Autowired
	@Qualifier("solicitudServiceimp")
	private SolicitudService solicitudService;

	@GetMapping("/cotizacion")
	public String Cotizacion() {
		return "documentacion/cotizacionDoc";
	}
	@GetMapping("/despacho")
	public String Despacho() {
		return "documentacion/despachoDoc";
	}
	@GetMapping("/factura")
	public String Factura() {
		return "documentacion/facturaDoc";
	}
	@GetMapping("/ordenCompra")
	public String OrdenCompra() {
		return "documentacion/ordenCompraDoc";
	}
	
	@GetMapping("/solicitud")
	public ModelAndView redirectSolicitud() {
		ModelAndView mav = new ModelAndView("documentacion/solicitudDoc");
		List<Solicitud> solici = solicitudService.findByAll();
		mav.addObject("solicitud", solici);
		return mav;
	}
	
	@GetMapping("/solicitudform")
	public String redirectClienteForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		Solicitud solicitud = new Solicitud();
		if(id != 0) {
			solicitud = solicitudService.findByidsolicitud(id);		
		}
		model.addAttribute("solicitud",solicitud);
		return "crearEditar/solicitud";
	}
	@PostMapping("/addsolicitud")
	public String addSolicitud (@ModelAttribute(name="solicitud")Solicitud solicitud,Model model) {
		if(null != solicitudService.save(solicitud)) {
			model.addAttribute("result", 1);
		}else {			
		
		model.addAttribute("result", 0);
		}
		return "redirect:/documentacion/solicitud";
	}
	
	@GetMapping("/borrarsolicitud")
	public String borrarSolicitud(@RequestParam(name="id",required=true)int id,Model model) {
		//int soli = contactoService.findbyidcliente(id);
		//if (cont == 0) {		
			solicitudService.delete(id);
		//}
		return "redirect:/documentacion/solicitud";
	}
	@GetMapping("/valorizacion")
	public String Valorizacion() {
		return "documentacion/valorizacionDoc";
	}
	
	
}
