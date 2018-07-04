package com.projecto.Horadada.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projecto.Horadada.service.ClienteService;
import com.projecto.Horadada.service.CotizacionDetalleService;
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
	@Qualifier("cotizaciondetalleservice")
	private CotizacionDetalleService cotizaciondetalleservice;

	@Autowired
	@Qualifier("tablamaestraserviceimp")
	private TablaMaestraService tablamaestraservice;

	// *****************************COTIZACION***********************************
	
	// *************************DESPACHO*********************************



	// ******************************VALORIZACION********************************************************

	@GetMapping("/valorizacion")
	public String Valorizacion() {
		return "documentacion/valorizacionDoc";
	}

}
