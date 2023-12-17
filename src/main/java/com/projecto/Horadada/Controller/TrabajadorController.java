package com.projecto.Horadada.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.projecto.Horadada.Entity.PersonaEntity;
import com.projecto.Horadada.service.PersonaService;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

    @Autowired
    @Qualifier("personaServiceImp")
    private PersonaService personaService;

    @GetMapping("")
    public ModelAndView Trabajador(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        ModelAndView mav = new ModelAndView("mantenimiento/trabajador");
        mav.addObject("traba", personaService.findByTipopersona(3));
        return mav;
    }

    @GetMapping("/trabajadorform")
    public String redirectContactoForm(@RequestParam(name = "id", required = false) int id,
            Model model) {
        int resu = 0;
        PersonaEntity persona = new PersonaEntity();
        List<PersonaEntity> person = personaService.findByTipopersona(0);
        if (id != 0) {
            persona = personaService.findByidPersona(id);
        }
        if (person != null) {
            resu = 1;
        }
        model.addAttribute("person", person);
        model.addAttribute("persona", persona);
        model.addAttribute("resu", resu);
        return "crearEditar/trabajador";
    }

    @PostMapping("/addtrabajador")
    public String addTrabajador(@ModelAttribute(name = "persona") PersonaEntity persona, Model model) {

        PersonaEntity per = personaService.findByidPersona(persona.getIdPersona());
        per.setTipoPersona(3);
        if (null != personaService.save(per)) {
            model.addAttribute("resu", 1);
        } else {
            model.addAttribute("resu", 0);
        }
        return "redirect:/trabajador";
    }

    @GetMapping("/borrartrabajador")
    public String borrarTrabajador(@RequestParam(name = "id", required = true) int id, Model model) {
        PersonaEntity per = personaService.findByidPersona(id);
        per.setTipoPersona(0);
        if (null != personaService.save(per)) {
            model.addAttribute("resu", 1);
        } else {
            model.addAttribute("resu", 0);
        }
        return "redirect:/trabajador";
    }
}
