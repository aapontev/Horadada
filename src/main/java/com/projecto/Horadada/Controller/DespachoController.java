package com.projecto.Horadada.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.projecto.Horadada.Entity.DespachoEntity;
import com.projecto.Horadada.Entity.DespachoXvehiculoEntity;
import com.projecto.Horadada.Entity.DireccionEntity;
import com.projecto.Horadada.Entity.OrdenCompraEntity;
import com.projecto.Horadada.Entity.TransportistaEntity;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.DespachoService;
import com.projecto.Horadada.service.OrdenCompraService;
import com.projecto.Horadada.service.TransportistaService;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/despacho")
public class DespachoController {

    @Autowired
    @Qualifier("despachoservice")
    private DespachoService despachoservice;

    @Autowired
    @Qualifier("ordencompraservice")
    private OrdenCompraService ordencompraservice;

    @Autowired
    @Qualifier("utilitarioservice")
    private UtilitarioService utilitarioservice;

    @Autowired
    @Qualifier("transportistaServiceImp")
    private TransportistaService transportistaservice;

    @GetMapping("")
    public String despachos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5);
        Page<DespachoEntity> despacho = despachoservice.findAll(pageRequest);
        PageRender<DespachoEntity> pagerender = new PageRender<DespachoEntity>("/despacho", despacho);
        model.addAttribute("despachos", despacho);
        model.addAttribute("page", pagerender);
        return "documentacion/despachoDoc";
    }

    @GetMapping("/despachoform")
    public String despachoForm(@RequestParam(name = "id", required = false) int id, Model model) {
        DespachoEntity despacho = new DespachoEntity();
        List<OrdenCompraEntity> ordencompra = ordencompraservice.findByEstadoordencompra(1);
        List<DireccionEntity> direccion = utilitarioservice.findAll();
        int resu = 0;
        if (id != 0) {
            despacho = despachoservice.findByiddespacho(id);
            resu = 1;
        }
        TransportistaEntity transportista = transportistaservice.findByidsituaciontransportista(1);
        model.addAttribute("transportista", transportista);
        model.addAttribute("ordcompra", ordencompra);
        model.addAttribute("despacho", despacho);
        model.addAttribute("resu", resu);
        model.addAttribute("direccion", direccion);
        return "crearEditar/despacho";
    }

    @PostMapping("/adddespacho")
    public String addDespacho(@ModelAttribute(name = "despacho") DespachoEntity despacho, Model model,
            @RequestParam(name = "fechacarga[]", required = false) String[] fechacarga,
            @RequestParam(name = "fechadescarga[]", required = false) String[] fechadescarga,
            @RequestParam(name = "transport[]", required = false) String[] transport,
            @RequestParam(name = "horacarga[]", required = false) String[] horacarga,
            @RequestParam(name = "horadescarga[]", required = false) String[] horadescarga) {
        java.util.Date date1 = new java.util.Date();
        List<DespachoXvehiculoEntity> desxvehiculo = new ArrayList<DespachoXvehiculoEntity>();
        for (int i = 0; i < transport.length; i++) {
            try {
                date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fechacarga[i]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            DespachoXvehiculoEntity linea = new DespachoXvehiculoEntity();
            linea.setFechaCarga(date1);
            linea.setHoraCarga(horacarga[i]);
            linea.setHoraDescarga(horadescarga[i]);
            linea.setIdTransportista(Integer.parseInt(transport[i]));
            desxvehiculo.add(linea);
        }
        despacho.setDespachoXVehiculos(desxvehiculo);

        //OrdenCompraEntity orcom = despacho.getOrdenCompra();
        //OrdenCompraEntity orden = ordencompraservice.findbyid(orcom.getIdordencompra());
        //orden.setEstadoOrdenCompra(2);
        //despacho.setOrdenCompra(orden);
        if (null != despachoservice.save(despacho)) {
            model.addAttribute("result", 1);
        } else {
            model.addAttribute("result", 0);
        }
        return "redirect:/despacho";
    }

}
