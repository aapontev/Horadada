package com.projecto.Horadada.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Service.TablaMaestraService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RestTablaMaestraController {
	
	@Autowired
	private TablaMaestraService tmService;
	
	@GetMapping("/tablaMaestra")
	public List<Tablamaestra> Index() {
		return tmService.findAll();
	}
}
