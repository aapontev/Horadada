package com.projecto.Horadada.Controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.projecto.Horadada.Entity.Cliente;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.ClienteService;
import com.projecto.Horadada.service.ContactoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	@Qualifier("clienteServiceImp")
	private ClienteService clienteService;

	@Autowired
	@Qualifier("contactoServiceImp")
	private ContactoService contactoService;

	@GetMapping("")
	public String Cliente(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Cliente> clientes = clienteService.findAll(pageRequest);
		PageRender<Cliente> pagerender = new PageRender<Cliente>("/mantenimiento/cliente",clientes);
		model.addAttribute("cli", clientes);
		model.addAttribute("page", pagerender);
		return "mantenimiento/cliente";
	}

	@GetMapping("/clienteform")
	public String redirectClienteForm(@RequestParam(name = "id", required = false) int id, Model model) {
		Cliente cliente = new Cliente();
		if (id != 0) {
			cliente = clienteService.findByidcliente(id);
		}
		model.addAttribute("cliente", cliente);
		return "crearEditar/cliente";
	}

	@PostMapping("/addcliente")
	public String addCliente(@ModelAttribute(name = "cliente") Cliente cliente, Model model) {
		if (null != clienteService.save(cliente)) {
			// Cliente client= clienteService.save(cliente);
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/cliente";
	}

	@GetMapping("/borrarcliente")
	public ModelAndView borrarCliente(@RequestParam(name = "id", required = true) int id, Model model) {
		ModelAndView mav = new ModelAndView("mantenimiento/cliente");
		mav.addObject("cliid", clienteService.findByidcliente(id));
		int cont = clienteService.delete(id);

		mav.addObject("result", cont);
		mav.addObject("cli", clienteService.findByAll());
		return mav;
	}
}
