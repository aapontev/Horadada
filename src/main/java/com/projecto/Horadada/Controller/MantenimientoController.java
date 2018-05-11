package com.projecto.Horadada.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.Horadada.Constantes.ConstantesMaestra;
import com.projecto.Horadada.service.PersonaService;
import com.projecto.Horadada.service.TablaMaestraService;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {
	
	@Autowired
	@Qualifier("personaServiceImp")
	private PersonaService personaService;
	private ConstantesMaestra cm;
	
	@Autowired
	@Qualifier("tablaMaestraServiceImp")
	private TablaMaestraService tablaService;
	@GetMapping("/cliente")
	public ModelAndView Cliente() {
		ModelAndView mav =new ModelAndView("mantenimiento/cliente");
		mav.addObject("cli",personaService.findByTipopersona(cm.TIPOPERCLIEN));
		return mav;
	}
	
	@GetMapping("/contacto")
	public ModelAndView Contacto() {
		ModelAndView mav =new ModelAndView("mantenimiento/contacto");
		mav.addObject("cont",personaService.findByTipopersona(cm.TIPOPERCLIEN));
		return mav;
	}
	
	@GetMapping("/trabajador")
	public ModelAndView Trabajador() {
		ModelAndView mav =new ModelAndView("mantenimiento/trabajador");
		mav.addObject("traba",personaService.findByTipopersona(cm.TIPOPERADM));
		return mav;
	}
	
	@GetMapping("/transportista")
	public ModelAndView Transportista() {
		ModelAndView mav = new ModelAndView("mantenimiento/transportista");
		mav.addObject("transport", personaService.findByTipopersona(cm.TIPOPERtRANSPORT));
		return mav;
	}
	@GetMapping("/persona")
	public ModelAndView Persona() {
		ModelAndView mav = new ModelAndView("mantenimiento/persona");
		mav.addObject("transport", personaService.findByTipopersona(cm.TIPOPERtRANSPORT));
		return mav;
	}
	@GetMapping("/tablaMaestra")
	public ModelAndView TablaMaestra() {
		List<String> valMa = tablaService.getdescripcion();
		ModelAndView mav = new ModelAndView("mantenimiento/tablaMaestra");
		mav.addObject("valMa", valMa);
		return mav;
	}
}

/*@GetMapping("/showcontactos")
public ModelAndView showContactos() {
	ModelAndView mav = new ModelAndView(ConstantView.CONTACTS);
	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
	mav.addObject("username",user.getUsername());
	mav.addObject("contactos",contactoService.listAllContactos());
	return mav;
}*/