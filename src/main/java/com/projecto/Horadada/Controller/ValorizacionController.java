package com.projecto.Horadada.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/valorizacion")
public class ValorizacionController {

        @GetMapping("")
    public String redirectSolicitud() {
        return "documentacion/valorizacionDoc";
    }
}
