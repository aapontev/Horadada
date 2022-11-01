package com.projecto.Horadada.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.projecto.Horadada.Entity.DespachoXvehiculo;
import com.projecto.Horadada.Entity.Direccion;
import com.projecto.Horadada.Entity.OrdenCompra;
import com.projecto.Horadada.Entity.Transportista;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.DespachoService;
import com.projecto.Horadada.service.OrdenCompraService;
import com.projecto.Horadada.service.TransportistaService;
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

	@Autowired
	@Qualifier("transportistaServiceImp")
	private TransportistaService transportistaservice;

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
		List<OrdenCompra> ordencompra = ordencompraservice.findByestadoordencompra(1);
		List<Direccion> direccion = utilitarioservice.findAll();
		int resu = 0;
		if (id != 0) {
			despacho = despachoservice.findByiddespacho(id);
			resu = 1;
		}
		Transportista transportista = transportistaservice.findByidsituaciontransportista(1);
		model.addAttribute("transportista", transportista);
		model.addAttribute("ordencompra", ordencompra);
		model.addAttribute("despacho", despacho);
		model.addAttribute("resu", resu);
		model.addAttribute("direccion", direccion);
		return "crearEditar/despacho";
	}

	@PostMapping("/adddespacho")
	public String addDespacho(@ModelAttribute(name = "despacho") Despacho despacho, Model model,
			@RequestParam(name = "fechacarga[]", required = false) String[] fechacarga,
			@RequestParam(name = "fechadescarga[]", required = false) String[] fechadescarga,
			@RequestParam(name = "transport[]", required = false) String[] transport,
			@RequestParam(name = "horacarga[]", required = false) String[] horacarga,
			@RequestParam(name = "horadescarga[]", required = false) String[] horadescarga) {
		java.util.Date date1 = new java.util.Date();
		List<DespachoXvehiculo> desxvehiculo = new ArrayList<DespachoXvehiculo>();
		for (int i = 0; i < transport.length; i++) {
		    try {
				date1=new SimpleDateFormat("dd/MM/yyyy").parse(fechacarga[i]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			DespachoXvehiculo linea = new DespachoXvehiculo();
			linea.setFechaCarga(date1);
		//	linea.setFechadescarga(fechadescarga[i]);
			linea.setHoraCarga(horacarga[i]);
			linea.setHoraDescarga(horadescarga[i]);
			linea.setIdTransportista(Integer.parseInt(transport[i]));
			
			desxvehiculo.add(linea);
		}
		despacho.setDespachoXvehiculos(desxvehiculo);
		
		
		OrdenCompra orcom = despacho.getOrdenCompra();
		OrdenCompra orden = ordencompraservice.findbyid(orcom.getIdOrdenCompra());
		orden.setEstadoOrdenCompra(2);
		despacho.setOrdenCompra(orden);
		if (null != despachoservice.save(despacho)) {
			model.addAttribute("result", 1);
		} else {

			model.addAttribute("result", 0);
		}
		return "redirect:/despacho";
	}

}
