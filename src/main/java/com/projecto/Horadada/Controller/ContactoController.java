package com.projecto.Horadada.Controller;

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
import com.projecto.Horadada.Entity.ClienteEntity;
import com.projecto.Horadada.Entity.ContactoEntity;
import com.projecto.Horadada.Entity.PersonaEntity;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.ClienteService;
import com.projecto.Horadada.service.ContactoService;
import com.projecto.Horadada.service.PersonaService;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    @Qualifier("contactoServiceImp")
    private ContactoService contactoService;

    @Autowired
    @Qualifier("clienteServiceImp")
    private ClienteService clienteService;

    @Autowired
    @Qualifier("personaServiceImp")
    private PersonaService personaService;

    @GetMapping("")
    public String Contacto(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5);
        Page<ContactoEntity> contacto = contactoService.findAll(pageRequest);
        PageRender<ContactoEntity> pagerender = new PageRender<ContactoEntity>("/contacto", contacto);
        model.addAttribute("cont", contacto);
        model.addAttribute("page", pagerender);
        return "mantenimiento/contacto";
    }

    @GetMapping("/contactoform")
    public String redirectContactoForm(@RequestParam(name = "id", required = false) int id,
            Model model) {
        ContactoEntity contacto = new ContactoEntity();
        List<PersonaEntity> persona = personaService.findByTipopersona(0);
        List<ClienteEntity> cliente = clienteService.findByAll();
        if (id != 0) {
            contacto = contactoService.findByidcontacto(id);
        }
        model.addAttribute("cliente", cliente);
        model.addAttribute("contacto", contacto);
        model.addAttribute("persona", persona);
        return "crearEditar/contacto";
    }

    @PostMapping("/addcontacto")
    public String addContacto(@ModelAttribute(name = "contacto") ContactoEntity contacto, Model model) {
        if (null != contactoService.save(contacto)) {
            model.addAttribute("result", 1);
        } else {
            model.addAttribute("result", 0);
        }
        return "redirect:/contacto/";
    }

    @GetMapping("/borrarcontacto")
    public String borrarContacto(@RequestParam(name = "id", required = true) int id, Model model) {
        contactoService.delete(id);
        return "redirect:/contacto/";
    }
}
