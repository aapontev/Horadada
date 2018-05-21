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

import com.projecto.Horadada.Entity.Cliente;
import com.projecto.Horadada.Entity.Cotizacion;
import com.projecto.Horadada.Entity.Solicitud;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.service.ClienteService;
import com.projecto.Horadada.service.CotizacionService;
import com.projecto.Horadada.service.SolicitudService;
import com.projecto.Horadada.service.TablaMaestraService;

@Controller
@RequestMapping("/documentacion")
public class DocumentacionController {
	
	@Autowired
	@Qualifier("solicitudServiceimp")
	private SolicitudService solicitudService;
	
	@Autowired
	@Qualifier("clienteServiceImp")
	private ClienteService clienteService;
	
	@Autowired
	@Qualifier("cotizacionserviceimp")
	private CotizacionService cotizacionservice;
	
	@Autowired
	@Qualifier("tablamaestraserviceimp")
	private TablaMaestraService tablamaestraservice;
	
//*****************************COTIZACION***********************************
	@GetMapping("/cotizacion")
	public ModelAndView redirectCotizacion() {
		ModelAndView mav = new ModelAndView("documentacion/cotizacionDoc");
		List<Cotizacion> cotiza= cotizacionservice.findAll();
		mav.addObject("cotiza", cotiza);
		return mav;
	}
	
	@GetMapping("/cotizacionform")
	public String redirectCotizacionForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		List<Tablamaestra> moneda = tablamaestraservice.findByIdtablamaestra("Hora002");
		Cotizacion cotizacion = new Cotizacion();	
		
		if(id != 0) {
			cotizacion = cotizacionservice.findbyid(id);		
		}
		model.addAttribute("cotizacion",cotizacion);
		model.addAttribute("moneda", moneda);
		return "crearEditar/cotizacion";
	}
	
	@PostMapping("/addcotizacion")
	public String addCotizacion (@ModelAttribute(name="cotizacion")Cotizacion cotizacion,Model model) {
		if(null != cotizacionservice.save(cotizacion)) {
			model.addAttribute("result", 1);
		}else {			
		
		model.addAttribute("result", 0);
		}
		return "redirect:/documentacion/cotizacion";
	}
	
	@GetMapping("/borrarcotizacion")
	public String borrarCotizacion(@RequestParam(name="id",required=true)int id,Model model) {
		//int soli = contactoService.findbyidcliente(id);
		//if (cont == 0) {		
			cotizacionservice.delete(id);
		//}
		return "redirect:/documentacion/cotizacion";
	}
	
	//*************************DESPACHO*********************************
	
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
	
	//*****************************Solicitud*******************************************
	
	@GetMapping("/solicitud")
	public ModelAndView redirectSolicitud() {
		ModelAndView mav = new ModelAndView("documentacion/solicitudDoc");
		List<Solicitud> solici = solicitudService.findByAll();
		mav.addObject("solicitud", solici);
		return mav;
	}
	
	@GetMapping("/solicitudform")
	public String redirectSolicitudForm(@RequestParam(name="id",required=false )int id,
			Model model) {
		Solicitud solicitud = new Solicitud();
		List<Cliente> cliente = clienteService.findByAll();		
		
		if(id != 0) {
			solicitud = solicitudService.findByidsolicitud(id);		
		}
		model.addAttribute("solicitud",solicitud);
		model.addAttribute("cliente", cliente);
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
	//******************************VALORIZACION********************************************************
	
	@GetMapping("/valorizacion")
	public String Valorizacion() {
		return "documentacion/valorizacionDoc";
	}
	
	
}
