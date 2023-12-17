package com.projecto.Horadada.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.Entity.PersonaEntity;
import com.projecto.Horadada.Entity.TelefonoMonitoreoEntity;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/telefono")
public class TelefonoController {

    @Autowired
    @Qualifier("utilitarioservice")
    private UtilitarioService utilitarioservice;

    @GetMapping
    public String listaTelefono(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);
        Page<TelefonoMonitoreoEntity> telefono = utilitarioservice.findAllTel(pageRequest);
        PageRender<TelefonoMonitoreoEntity> pagerender = new PageRender<TelefonoMonitoreoEntity>("/telefono", telefono);
        model.addAttribute("telefono", telefono);
        model.addAttribute("page", pagerender);
        return "utilitarios/telefono";
    }

    @GetMapping("/personaform")
    public String redirectPersonaForm(@RequestParam(name = "idpersona", required = false) int id, Model model) {
        PersonaEntity per = new PersonaEntity();
        int resu = 0;
        if (id != 0) {
            resu = 1;
        }
        model.addAttribute("resu", resu);
        model.addAttribute("persona", per);
        return "crearEditar/persona";
    }
}
