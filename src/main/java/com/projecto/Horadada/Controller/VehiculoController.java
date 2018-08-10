package com.projecto.Horadada.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
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
import com.projecto.Horadada.Entity.Transportista;
import com.projecto.Horadada.Entity.Vehiculo;
import com.projecto.Horadada.Model.MarcaAuto;
import com.projecto.Horadada.Model.ModeloAuto;
import com.projecto.Horadada.Util.PageRender;
import com.projecto.Horadada.service.TransportistaService;
import com.projecto.Horadada.service.UtilitarioService;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {

	@Autowired
	@Qualifier("utilitarioservice")
	private UtilitarioService utilitarioservice;

	@Autowired
	@Qualifier("transportistaServiceImp")
	private TransportistaService transportistaservice;

	@GetMapping("")
	public String vehiculos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Vehiculo> vehiculo = utilitarioservice.findAll(pageRequest);
		PageRender<Vehiculo> pagerender = new PageRender<Vehiculo>("/Vehiculo", vehiculo);
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("page", pagerender);
		return "utilitarios/vehiculo";
	}

	@GetMapping("/vehiculoform")
	public String redirectPersonaForm(@RequestParam(name = "id", required = false) int id, Model model) {
		Vehiculo veh = new Vehiculo();
		List<Transportista> transportista = transportistaservice.findByAll();
		if (id != 0) {
			veh = utilitarioservice.findByidvehiculo(id);
		}
		List<MarcaAuto> marcas = obtieneMarca();
		List<ModeloAuto> modelo = obtieneModelo(56);
		model.addAttribute("marcas", marcas);
		model.addAttribute("modelo", modelo);
		model.addAttribute("vehiculo", veh);
		model.addAttribute("trasnportista", transportista);
		return "crearEditar/vehiculo";
	}

	@GetMapping("/deletevehiculo")
	public String borrarPersona(@RequestParam(name = "id", required = true) int id, Model model) {
		utilitarioservice.deleteVeh(id);
		return "redirect:/persona/";
	}

	@PostMapping("/addpersona")
	public String addPersona(@ModelAttribute(name = "vehiculo") Vehiculo vehiculo, Model model) {
		if (null != utilitarioservice.save(vehiculo)) {
			model.addAttribute("resu", 1);
		} else {
			model.addAttribute("resu", 0);
		}
		return "redirect:/vehiculo";
	}

	public List<MarcaAuto> obtieneMarca() {
		List<MarcaAuto> marcas = new ArrayList<MarcaAuto>();
		try {
			String web = "http://fipeapi.appspot.com/api/1/carros/marcas.json";
			URL url = new URL(null, web, new sun.net.www.protocol.https.Handler());
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String output = br.readLine();
				JSONArray jsonarray = new JSONArray(output);
				for (int i = 0; i < jsonarray.length(); i++) {
					MarcaAuto marca = new MarcaAuto();
					JSONObject jsonobject = jsonarray.getJSONObject(i);
					String name = jsonobject.getString("name");
					String fipename = jsonobject.getString("fipe_name");
					int order = jsonobject.getInt("order");
					String key = jsonobject.getString("key");
					int id = jsonobject.getInt("id");
					marca.setName(name);
					marca.setFipe_name(fipename);
					marca.setOrder(order);
					marca.setKey(key);
					marca.setId(id);
					marcas.add(marca);
				}
				System.out.print(marcas);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return marcas;
	}

	public List<ModeloAuto> obtieneModelo(int ids) {
		List<ModeloAuto> modelos = new ArrayList<ModeloAuto>();
		try {
			String web = "http://fipeapi.appspot.com/api/1/carros/veiculos/" + ids + ".json";
			URL url = new URL(null, web, new sun.net.www.protocol.https.Handler());
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String output = br.readLine();
				JSONArray jsonarray = new JSONArray(output);
				for (int i = 0; i < jsonarray.length(); i++) {
					ModeloAuto modelo = new ModeloAuto();
					JSONObject jsonobject = jsonarray.getJSONObject(i);
					String marca = jsonobject.getString("marca");
					String name = jsonobject.getString("name");
					String fipemarca = jsonobject.getString("fipe_marca");
					String fipename = jsonobject.getString("fipe_name");
					String key = jsonobject.getString("key");
					String id = jsonobject.getString("id");
					modelo.setMarca(marca);
					modelo.setName(name);
					modelo.setFipeMarca(fipemarca);
					modelo.setFipeName(fipename);
					modelo.setKey(key);
					modelo.setId(id);
					modelos.add(modelo);
				}
				System.out.print(modelos);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return modelos;
	}
}
