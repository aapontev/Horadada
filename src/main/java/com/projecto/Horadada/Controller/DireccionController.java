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
import com.projecto.Horadada.Entity.DireccionEntity;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/direccion")
public class DireccionController {

    @Autowired
    @Qualifier("utilitarioservice")
    private UtilitarioService utilitarioservice;

    @GetMapping("")
    public String DireccionList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5);
        Page<DireccionEntity> direccion = utilitarioservice.findAllDir(pageRequest);
        PageRender<DireccionEntity> pagerender = new PageRender<DireccionEntity>("/direccion", direccion);
        model.addAttribute("direccion", direccion);
        model.addAttribute("page", pagerender);
        return "utilitarios/direccion";
    }

    @GetMapping("direccionform")
    public String DireccionForm(@RequestParam("id") int id, Model model) {
        DireccionEntity direccion = new DireccionEntity();
        if (id != 0) {
            direccion = utilitarioservice.findByIddireccion(id);
        }
        model.addAttribute("direccion", direccion);
        return "crearEditar/direccion";
    }

    @GetMapping("deletedireccion")
    public String DeleteDireccion(@RequestParam("id") int id) {
        utilitarioservice.deleteDire(id);
        return "redirect:/direccion";
    }

    @PostMapping("addireccion")
    public String addDireccion(@ModelAttribute("direccion") DireccionEntity direccion, Model model) {
        if (null != utilitarioservice.save(direccion)) {
            model.addAttribute("result", 1);
        } else {
            model.addAttribute("result", 0);
        }
        return "redirect:/direccion";
    }
}
