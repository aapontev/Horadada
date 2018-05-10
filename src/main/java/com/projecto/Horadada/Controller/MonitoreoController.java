package com.projecto.Horadada.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monitoreo")
public class MonitoreoController {
	
	@GetMapping("/")
	public String monitoreo() {
		return "monitoreo/monitoreo";
	}

}
