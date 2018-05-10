package com.projecto.Horadada.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documentacion")
public class DocumentacionController {

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
	public String Solicitud() {
		return "documentacion/solicitudDoc";
	}
	@GetMapping("/valorizacion")
	public String Valorizacion() {
		return "documentacion/valorizacionDoc";
	}
}
