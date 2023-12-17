package com.projecto.Horadada.Controller;

import com.projecto.Horadada.Entity.ClienteEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.Horadada.Entity.PersonaEntity;
import com.projecto.Horadada.Entity.TablaMaestraEntity;
import com.projecto.Horadada.Entity.TelefonoMonitoreoEntity;
import com.projecto.Horadada.Entity.UsuarioEntity;
import com.projecto.Horadada.Model.PersonaModel;
import com.projecto.Horadada.Util.Common;
import com.projecto.Horadada.Util.Constantes;
import com.projecto.Horadada.service.ClienteService;
import com.projecto.Horadada.service.PersonaService;
import com.projecto.Horadada.service.RoleUsuarioService;
import com.projecto.Horadada.service.UsuarioService;
import com.projecto.Horadada.service.UtilitarioService;
import java.text.ParseException;
import java.util.Date;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping("persona")
public class PersonaController {

    @Autowired
    @Qualifier("personaServiceImp")
    private PersonaService personaService;

    @Autowired
    @Qualifier("utilitarioservice")
    private UtilitarioService utilitarioservice;

    @Autowired
    @Qualifier("clienteServiceImp")
    private ClienteService clienteService;

    @Autowired
    @Qualifier("usuarioServiceImp")
    private UsuarioService usuarioService;
    @Autowired
    @Qualifier("roleUsuarioServiceImp")
    private RoleUsuarioService roleUsuarioService;

    @Autowired
    private BCryptPasswordEncoder codificador;

    private Common common = new Common();

    @GetMapping
    public String persona(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);
        model.addAttribute("persona", personaService.findAll(pageRequest));
        return "mantenimiento/persona";
    }

    @PostMapping("/addpersona")
    public String addPersona(@ModelAttribute(name = "persona") PersonaModel personaModel,
            Model model) throws ParseException {

        PersonaEntity personaNew = seteaPersona(personaModel);
        PersonaEntity persona = personaService.save(personaNew);
        if (persona != null) {
            model.addAttribute("resu", 1);
        } else {
            model.addAttribute("resu", 0);
        }

        if (!personaModel.getNumeroTelefono().isEmpty()) {
            TelefonoMonitoreoEntity telefono = new TelefonoMonitoreoEntity();
            telefono.setIdTelefono(personaModel.getIdTelefono());
            telefono.setIdOperador(personaModel.getOperador());
            telefono.setIdTipoTelefono(personaModel.getTipoTelefono());
            telefono.setNumeroTelefono(personaModel.getNumeroTelefono());
            telefono.setPersona(persona);
            utilitarioservice.save(telefono);
        }
        if(persona.getTipoPersona() == 3){
            insertUsuario(persona);
        }

        return "redirect:/persona";
    }

    @GetMapping("/personaform")
    public String redirectPersonaForm(@RequestParam(name = "idpersona", required = false) int id, Model model) {
        PersonaModel per = new PersonaModel();
        int resu = 0;
        List<TablaMaestraEntity> persotip = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_TIPO_PERSONA);
        List<TablaMaestraEntity> tipodoc = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_TIPO_DOC);
        List<TablaMaestraEntity> operador = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_OPERADOR_TEL);
        List<TablaMaestraEntity> tipotelefono = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_TIPO_TEL);
        List<TablaMaestraEntity> estado = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_ESTADO_TRANSPORTISTA);
        List<TablaMaestraEntity> licencia = utilitarioservice.findByIdtablaMaestra(Constantes.TABLA_TIPO_lICENCIA);
        List<ClienteEntity> cliente = clienteService.findByAll();
        int tipPer = 0;
        if (id != 0) {
            PersonaEntity persona = personaService.findByidPersona(id);
            TelefonoMonitoreoEntity telefono = utilitarioservice.findByPersona(persona);
            per.setIdPersona(persona.getIdPersona());
            per.setTipoPersona(persona.getTipoPersona());
            per.setNombreCompleto(persona.getNombreCompleto());
            per.setCodTipoDocumento(persona.getCodTipoDocumento());
            per.setNumeroDocumento(persona.getNumeroDocumento());
            per.setDireccion(persona.getDireccion());
            per.setFechaNacimiento(persona.getFechaNacimiento().toString());
            per.setCorreoElectronico(persona.getCorreoElectronico());
            if (telefono != null) {
                per.setIdTelefono(telefono.getIdTelefono());
                per.setNumeroTelefono(telefono.getNumeroTelefono());
                per.setTipoTelefono(telefono.getIdTipoTelefono());
                per.setOperador(telefono.getIdOperador());
            }
            resu = 1;
            tipPer = per.getTipoPersona();
        }
        model.addAttribute("resu", resu);
        model.addAttribute("tipopersona", persotip);
        model.addAttribute("operador", operador);
        model.addAttribute("tipotelefono", tipotelefono);
        model.addAttribute("tipodoc", tipodoc);
        model.addAttribute("estado", estado);
        model.addAttribute("licencia", licencia);
        model.addAttribute("persona", per);
        model.addAttribute("cliente", cliente);
        model.addAttribute("tipPer", tipPer);
        return "crearEditar/persona";
    }

    @GetMapping("/borrarpersona")
    public String borrarPersona(@RequestParam(name = "idpersona", required = true) int id, Model model) {

        PersonaEntity persona = personaService.findByidPersona(id);

        personaService.delete(persona);
        return "redirect:/persona/";
    }

    public PersonaEntity seteaPersona(PersonaModel personaModel) throws ParseException {
        PersonaEntity persona = new PersonaEntity();
        persona.setIdPersona(personaModel.getIdPersona());
        persona.setCodTipoDocumento(personaModel.getCodTipoDocumento());
        persona.setCorreoElectronico(personaModel.getCorreoElectronico());
        persona.setDireccion(personaModel.getDireccion());
        persona.setEdad(12); /////////////////////////////
        persona.setFechaCreacion(new Date());
        persona.setFechaNacimiento(common.setearFecha(personaModel.getFechaNacimiento()));
        persona.setFechaUpdate(new Date());
        persona.setNombreCompleto(personaModel.getNombreCompleto());
        persona.setNumeroDocumento(personaModel.getNumeroDocumento());
        String[] nombreCompleto = persona.getNombreCompleto().split(" ");
        switch (nombreCompleto.length) {
            case 4:
                persona.setPrimerApellido(nombreCompleto[0]);
                persona.setSegundoApellido(nombreCompleto[1]);
                persona.setPrimerNombre(nombreCompleto[2]);
                persona.setSegundoNombre(nombreCompleto[3]);
                break;
            case 3:
                persona.setPrimerApellido(nombreCompleto[0]);
                persona.setSegundoApellido(nombreCompleto[1]);
                persona.setPrimerNombre(nombreCompleto[2]);
                break;
            case 2:
                persona.setPrimerApellido(nombreCompleto[0]);
                persona.setSegundoApellido(nombreCompleto[1]);
                break;
            default:
                persona.setPrimerApellido(nombreCompleto[0]);
                break;
        }
        persona.setTipoPersona(personaModel.getTipoPersona());
        return persona;
    }

    public void insertUsuario(PersonaEntity per) {
        String nombre = per.getPrimerNombre().charAt(0) + per.getPrimerApellido() ;
        int cont = 0;
        UsuarioEntity ue = usuarioService.obtenerUno(nombre); 
        while (ue.getNombreUsuario() != null) {
            nombre = nombre + cont;
            ue = new UsuarioEntity();
            ue = usuarioService.obtenerUno(nombre);            
            cont = cont + 1;
        }
        UsuarioEntity newUS = new UsuarioEntity();

        newUS.setNombreUsuario(nombre);
        newUS.setEstado(true);
        newUS.setContrasena(codificador.encode("12345"));
        newUS.setPersona(personaService.findByidPersona(2));
        newUS.setIdroleusuario(roleUsuarioService.obtenerUno(2));
        newUS.setFechaUpdate(new Date());
        UsuarioEntity a = usuarioService.insertar(newUS);
        
    }
}
