package com.projecto.Horadada.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.projecto.Horadada.Entity.TablaMaestra;
import com.projecto.Horadada.service.UtilitarioService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@RequestMapping("/tablamaestra")
public class TablaMaestraController {

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;

	int resu =0;
	
	@GetMapping("")
	public ModelAndView TablaMaestra(@RequestParam(name="tipotabla",required=false,defaultValue = "0")String tipotabla) {
		resu=0;
		List<TablaMaestra> tablas = utilitarioservice.findByIdtablaMaestra(tipotabla);
		
		ModelAndView mav = new ModelAndView("utilitarios/tablaMaestra");
		if (tipotabla.equals("0")) {
			resu = 0 ;
		}else {
			if (tablas.size() > 0) {
				resu = 1 ;
			}
		}
		mav.addObject("resu", resu);
		mav.addObject("titulo",tipotabla);
		mav.addObject("tablas", tablas);
		return mav;
	}
	
	@GetMapping("/form")
	public ModelAndView TablaMaestraForm(@RequestParam(name="idTabla")String idTabla, @RequestParam(name="clave1")String clave1) {

		ModelAndView mav = new ModelAndView("utilitarios/tablaMaestra");
		TablaMaestra tm = utilitarioservice.findByidTablaMaestraAndClave1(idTabla, clave1);
		mav.addObject("tabla", tm);
		return mav;
	}
	
	@GetMapping("/tablaMaestraTabla")
	public ResponseEntity<List<TablaMaestra>> tablaMaestraTabla (@RequestParam(name = "tabla")String tabla){
		List<TablaMaestra> maestra = utilitarioservice.findByIdtablaMaestra(tabla);
		return new ResponseEntity<List<TablaMaestra>>(maestra,HttpStatus.OK);
	}
	@GetMapping("/tablaMaestraDetalle")
	public ResponseEntity<TablaMaestra> tablaMaestraDetalle (@RequestParam(name = "tabla")String tabla,@RequestParam(name = "clave1")String clave1){
		TablaMaestra maestra = utilitarioservice.findByidTablaMaestraAndClave1(tabla,clave1);
		return new ResponseEntity<TablaMaestra>(maestra,HttpStatus.OK);
	}
}
