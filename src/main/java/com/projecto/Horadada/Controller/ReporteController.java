package com.projecto.Horadada.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.projecto.Horadada.Entity.TablaMaestraEntity;
import com.projecto.Horadada.Util.Common;
import com.projecto.Horadada.Util.Constantes;
import com.projecto.Horadada.service.UtilitarioService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reporte")
public class ReporteController {

    @Autowired
    @Qualifier("utilitarioservice")
    private UtilitarioService utilitarioservice;
    Common common = new Common();

    @GetMapping("")
    public String Reportes(Model model) {

        List<TablaMaestraEntity> documentos = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_DOCUMENTOS);
        int[] aniosArr = common.ultanios(10);
        String[] meses = Constantes.MESES;
        model.addAttribute("documentos", documentos);
        model.addAttribute("aniosArr", aniosArr);
        model.addAttribute("meses", meses);
        return "reporte/reportes";
    }

    @GetMapping("/descargar")
    public ResponseEntity<?> descargar(@RequestParam(name = "ruta") String ruta, @RequestParam(name = "nro") String nro, HttpServletResponse response) {
        try {
            String rutaArchivo = "D://fileserver//" + ruta + nro;
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                throw new FileNotFoundException("El archivo no existe");
            }
            InputStreamResource resource = new InputStreamResource(new FileInputStream(archivo));
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + archivo.getName());
            headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
            return ResponseEntity.ok().headers(headers).body(resource);
        } catch (FileNotFoundException e) {
            String mensaje = "El archivo solicitado no existe en el servidor";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        } catch (Exception e) {
            String mensaje = "Ha ocurrido un error en la descarga del archivo";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensaje);
        }
    }

    @GetMapping("/buscarArchivos")
    @ResponseBody
    public boolean obtenerArchivo(@RequestParam(name = "ruta") String rutaArchivo) {

        rutaArchivo = "D://fileserver//" + rutaArchivo;
        return common.existeArchivo(rutaArchivo);
    }

}
