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
import com.projecto.Horadada.Entity.CotizacionEntity;
import com.projecto.Horadada.Entity.OrdenCompraEntity;
import com.projecto.Horadada.Entity.TablaMaestraEntity;
import com.projecto.Horadada.Util.Constantes;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.CotizacionService;
import com.projecto.Horadada.service.OrdenCompraService;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/ordencompra")
public class OrdenCompraController {

    @Autowired
    @Qualifier("ordencompraservice")
    private OrdenCompraService ordencompraservice;

    @Autowired
    @Qualifier("utilitarioservice")
    private UtilitarioService utilitarioservice;

    @Autowired
    @Qualifier("cotizacionserviceimp")
    private CotizacionService cotizacionservice;

    @GetMapping("")
    public String OrdenCompra(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5);
        Page<OrdenCompraEntity> ordenes = ordencompraservice.findAll(pageRequest);
        PageRender<OrdenCompraEntity> pagerender = new PageRender<OrdenCompraEntity>("/ordencompra", ordenes);
        model.addAttribute("ordenes", ordenes);
        model.addAttribute("page", pagerender);
        return "documentacion/ordenCompraDoc";
    }

    @GetMapping("/ordencompraform")
    public String redirectOrdenCompraForm(@RequestParam(name = "id", required = false) int id, Model model) {
        List<TablaMaestraEntity> moneda = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_MONEDA);
        List<CotizacionEntity> cotizacion = cotizacionservice.findByaprobado(0);
        OrdenCompraEntity ordencompra = new OrdenCompraEntity();
        int resu = 0;
        if (id != 0) {
            ordencompra = ordencompraservice.findbyid(id);
            resu = 1;
        }
        model.addAttribute("resu", resu);
        model.addAttribute("ordencompra", ordencompra);
        model.addAttribute("moneda", moneda);
        model.addAttribute("cotizacion", cotizacion);
        return "crearEditar/ordencompra";
    }

    @PostMapping("/addordencompra")
    public String addOrdencompra(@ModelAttribute(name = "ordencompra") OrdenCompraEntity ordencompra, Model model) {
        CotizacionEntity cotiza = ordencompra.getCotizacion();
        CotizacionEntity coti = cotizacionservice.findbyid(cotiza.getIdCotizacion());
        coti.setAprobado(1);
        ordencompra.setEstadoOrdenCompra(1);
        ordencompra.setCotizacion(coti);
        if (null != ordencompraservice.save(ordencompra)) {
            model.addAttribute("result", 1);
        } else {
            model.addAttribute("result", 0);
        }
        return "redirect:/ordencompra";
    }

    @GetMapping("/borrarordencompra")
    public String borrarCotizacion(@RequestParam(name = "id", required = true) int id, Model model) {
        ordencompraservice.delete(id);
        return "redirect:/ordencompra";
    }
}
