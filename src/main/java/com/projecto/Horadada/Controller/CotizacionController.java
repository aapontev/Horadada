package com.projecto.Horadada.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.Entity.Cotizacion;
import com.projecto.Horadada.Entity.Cotizaciondetalle;
import com.projecto.Horadada.Entity.Solicitud;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.CotizacionDetalleService;
import com.projecto.Horadada.service.CotizacionService;
import com.projecto.Horadada.service.SolicitudService;
import com.projecto.Horadada.service.UtilitarioService;

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
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;

	@Autowired
	@Qualifier("solicitudServiceimp")
	private SolicitudService solicitudService;
	
	@GetMapping("")
	public String redirectCotizacion(@RequestParam(name = "page", defaultValue = "0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Cotizacion> cotizacion = cotizacionservice.findAll(pageRequest);
		PageRender<Cotizacion> pagerender = new PageRender<Cotizacion>("/cotizacion",cotizacion);
		model.addAttribute("cotiza", cotizacion);
		model.addAttribute("page", pagerender);
		return "documentacion/cotizacionDoc";
	}

	@GetMapping("/cotizacionform")
	public String redirectCotizacionForm(@RequestParam(name = "id", required = false) int id, Model model) {
		String impuesto;
		List<Tablamaestra> moneda = utilitarioservice.findByIdtablamaestra("Hora002");
		List<Solicitud> idsoli = solicitudService.getidsolicitud();
		List<Tablamaestra> medida = utilitarioservice.findByIdtablamaestra("Hora014");	
		List<Tablamaestra> igv = utilitarioservice.findByIdtablamaestra("Hora008");	
		impuesto = igv.get(0).getValor1();
		Cotizacion cotizacion = new Cotizacion();
		int resu = 0;
		if (id != 0) {			
			cotizacion = cotizacionservice.findbyid(id);
			resu = 1;
		}		
		model.addAttribute("resu", resu);
		model.addAttribute("solici", idsoli);
		model.addAttribute("moneda", moneda);
		model.addAttribute("medida", medida);
		model.addAttribute("igv", impuesto);
		model.addAttribute("cotizacion", cotizacion);
		return "crearEditar/cotizacion";
	}

	@PostMapping("/addcotizacion")
	public String Guardar(@Valid Cotizacion cotizacion, Model model,BindingResult result,
			@RequestParam(name= "recurso[]",required= false)String[]recurso,
			@RequestParam(name= "ccostos[]",required= false)String[]ccostos,
			@RequestParam(name= "cantidad[]",required= false)String[]cantidad,
			@RequestParam(name= "totaldetalle[]",required= false)String[]totaldetalle,
			@RequestParam(name= "idunidadmedida[]",required= false)String[]idunidadmedida) {
				
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear Factura");
			return "crearEditar/cotizacion";
		}
		if (recurso == null || recurso.length == 0) {
			model.addAttribute("titulo", "Crear Factura");
			model.addAttribute("error", "Error: La factura NO puede no tener líneas!");
			return "crearEditar/cotizacion";
		}
		List<Cotizaciondetalle> cot = new ArrayList<Cotizaciondetalle>();
		for (int i = 0; i < recurso.length; i++) {
			Cotizaciondetalle linea = new Cotizaciondetalle();
			linea.setItem(i+1);
			linea.setCcostos(ccostos[i]);
			linea.setCantidad(Double.parseDouble(cantidad[i]));
			linea.setCodrecurso(recurso[i]);
			linea.setDescripcion(cotizacion.getObservaciones());
			linea.setDescuento(0.00);
			linea.setPreciounitario(0.00);
			linea.setTotaldetalle(Double.parseDouble(totaldetalle[i]));
			linea.setIdunidadmedida(Integer.parseInt(idunidadmedida[i]));		
			cot.add(linea);
		}
		cotizacion.setCotizaciondetalles(cot);
		cotizacionservice.save(cotizacion);
		return "redirect:/cotizacion";
	}
	@GetMapping("/borrarcotizacion")
	public String borrarCotizacion(@RequestParam(name = "id", required = true) int id, Model model) {
		cotizacionservice.delete(id);
		return "redirect:/cotizacion";
	}

	/*@GetMapping("/cotizaciondetalle")
	public String redirectCotizacionDetalle(@RequestParam(name = "id", required = false) int id, Model model) {
		Cotizacion cotizacion = cotizacionservice.findbyid(id);
		//List<Cotizaciondetalle> cotizaDeta = cotizaciondetalleservice.findBycotizacion(cotizacion);

		model.addAttribute("cotizadeta", cotizaDeta);
		model.addAttribute("cotizaid", id);
		return "documentacion/cotizacionDetalle";
	}*/
	
	@GetMapping("/cotizaciondetalleform")
	public String redirectCotizacionDetalleform(@RequestParam(name = "id", required = false) int id,
			@RequestParam(name = "item", required = false) int item, Model model) {
		
		List<Tablamaestra> medida = utilitarioservice.findByIdtablamaestra("Hora014");		
		Cotizaciondetalle cotizaciondetalle = new Cotizaciondetalle();
		Cotizacion cotizacion = cotizacionservice.findbyid(id);
		
		if(item != 0) {
		 cotizaciondetalle = cotizaciondetalleservice.findByItem(item);
		}
		model.addAttribute("medida", medida);
		model.addAttribute("cotizacion", cotizacion.getIdcotizacion());
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
	
	/*@GetMapping(value = "/cargar-cotizacion/{term}", produces = { "application/json" })
	public @ResponseBody Cotizacion cargarCotizacion(@PathVariable String term) {
		Cotizacion cot = cotizacionservice.findbyid(Integer.parseInt(term));
		return cot;
	}*/
}
