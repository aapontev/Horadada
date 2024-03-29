package com.projecto.Horadada.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.Entity.CotizacionEntity;
import com.projecto.Horadada.Entity.CotizacionDetalleEntity;
import com.projecto.Horadada.Entity.SolicitudEntity;
import com.projecto.Horadada.Entity.TablaMaestraEntity;
import com.projecto.Horadada.Util.Constantes;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.CotizacionDetalleService;
import com.projecto.Horadada.service.CotizacionService;
import com.projecto.Horadada.service.SolicitudService;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/cotizacion")
public class CotizacionController {

    @Autowired
    @Qualifier("cotizacionserviceimp")
    private CotizacionService cotizacionservice;

    @Autowired
    @Qualifier("cotizaciondetalleservice")
    private CotizacionDetalleService cotizaciondetalleservice;

    @Autowired
    @Qualifier("utilitarioservice")
    private UtilitarioService utilitarioservice;

    @Autowired
    @Qualifier("solicitudServiceimp")
    private SolicitudService solicitudService;

    @GetMapping("")
    public String redirectCotizacion(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5);
        Page<CotizacionEntity> cotizacion = cotizacionservice.findAll(pageRequest);
        PageRender<CotizacionEntity> pagerender = new PageRender<CotizacionEntity>("/cotizacion", cotizacion);
        model.addAttribute("cotiza", cotizacion);
        model.addAttribute("page", pagerender);
        return "documentacion/cotizacionDoc";
    }

    @GetMapping("/cotizacionform")
    public String redirectCotizacionForm(@RequestParam(name = "id", required = false) int id, Model model) {
        String impuesto;
        List<TablaMaestraEntity> moneda = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_MONEDA);
        List<SolicitudEntity> idsoli = solicitudService.getidsolicitud();
        List<TablaMaestraEntity> medida = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_UNIDAD_MEDIDA);
        List<TablaMaestraEntity> igv = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_VALOR_IGV);
        impuesto = igv.get(0).getValor1();
        CotizacionEntity cotizacion = new CotizacionEntity();
        int resu = 0;
        if (id != 0) {
            cotizacion = cotizacionservice.findbyid(id);
            resu = 1;
        }
        model.addAttribute("resu", resu);
        model.addAttribute("solici", idsoli);
        model.addAttribute("moneda", moneda);
        model.addAttribute("medida", medida);
        model.addAttribute("igv", impuesto);
        model.addAttribute("cotizacion", cotizacion);
        return "crearEditar/cotizacion";
    }

    @PostMapping("/addcotizacion")
    public String Guardar(CotizacionEntity cotizacion, Model model, BindingResult result,
            @RequestParam(name = "recurso[]", required = false) String[] recurso,
            @RequestParam(name = "ccostos[]", required = false) String[] ccostos,
            @RequestParam(name = "cantidad[]", required = false) String[] cantidad,
            @RequestParam(name = "totaldetalle[]", required = false) String[] totaldetalle,
            @RequestParam(name = "idunidadmedida[]", required = false) String[] idunidadmedida) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Crear Factura");
            return "crearEditar/cotizacion";
        }
        if (recurso == null || recurso.length == 0) {
            model.addAttribute("titulo", "Crear Factura");
            model.addAttribute("error", "Error: La factura NO puede no tener líneas!");
            return "crearEditar/cotizacion";
        }
        List<CotizacionDetalleEntity> cot = new ArrayList<CotizacionDetalleEntity>();
        for (int i = 0; i < recurso.length; i++) {
            CotizacionDetalleEntity linea = new CotizacionDetalleEntity();
            linea.setItem(i + 1);
            linea.setCcostos(ccostos[i]);
            linea.setCantidad(Double.parseDouble(cantidad[i]));
            linea.setCodRecurso(recurso[i]);
            linea.setDescripcion(cotizacion.getObservaciones());
            linea.setDescuento(0.00);
            linea.setPrecioUnitario(0.00);
            linea.setTotalDetalle(Double.parseDouble(totaldetalle[i]));
            linea.setIdUnidadMedida(Integer.parseInt(idunidadmedida[i]));
            cot.add(linea);
        }
        cotizacion.setCotizacionDetalles(cot);
        cotizacionservice.save(cotizacion);
        return "redirect:/cotizacion";
    }

    @GetMapping("/borrarcotizacion")
    public String borrarCotizacion(@RequestParam(name = "id", required = true) int id, Model model) {
        cotizacionservice.delete(id);
        return "redirect:/cotizacion";
    }

    @GetMapping("/cotizaciondetalleform")
    public String redirectCotizacionDetalleform(@RequestParam(name = "id", required = false) int id,
            @RequestParam(name = "item", required = false) int item, Model model) {

        List<TablaMaestraEntity> medida = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_UNIDAD_MEDIDA);
        CotizacionDetalleEntity cotizaciondetalle = new CotizacionDetalleEntity();
        CotizacionEntity cotizacion = cotizacionservice.findbyid(id);

        if (item != 0) {
            cotizaciondetalle = cotizaciondetalleservice.findByItem(item);
        }
        model.addAttribute("medida", medida);
        model.addAttribute("cotizacion", cotizacion.getIdCotizacion());
        model.addAttribute("cotizadeta", cotizaciondetalle);
        return "crearEditar/cotizacionDetalle";
    }

    @PostMapping("/addcotizaciondetalle")
    public String addCotizacionDetalle(@ModelAttribute(name = "cotizaciondetalle") CotizacionDetalleEntity cotidetalle,
            Model model) {

        if (null != cotizaciondetalleservice.save(cotidetalle)) {
            model.addAttribute("result", 1);
        } else {
            model.addAttribute("result", 0);
        }
        return "redirect:/cotizacion";
    }

}
