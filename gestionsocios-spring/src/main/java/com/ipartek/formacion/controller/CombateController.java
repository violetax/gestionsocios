package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.controller.validator.CombateValidator;
import com.ipartek.formacion.dbms.pojo.TipoResultadoCombate;
import com.ipartek.formacion.persistence.Combate;
import com.ipartek.formacion.persistence.Socio;
import com.ipartek.formacion.persistence.Velada;
import com.ipartek.formacion.service.TipoResultadoCombateServiceImp;
import com.ipartek.formacion.service.interfaces.CombateService;
import com.ipartek.formacion.service.interfaces.SocioService;
import com.ipartek.formacion.service.interfaces.VeladaService;
/**
*
*
@author Violeta González
*
*
**/

@Controller
@RequestMapping(value = "/combates")
public class CombateController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CombateController.class);
	private ModelAndView mav = null;
	
	@Autowired
	private CombateService cS;
	@Autowired
	private TipoResultadoCombateServiceImp tipoResultadoCombate;
	
	@Autowired
	private VeladaService vS;
	@Autowired
	private SocioService sS;
	@Resource(name = "combateValidator")
	CombateValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		
		List<Combate> combates = cS.getAll();
			LOGGER.info("Lista: " + combates.size());
		model.addAttribute("listadoCombates", combates);
			LOGGER.info("Cargada lista de combates.");
		
		return "combates";
	}
	
	
	@RequestMapping(value = "/{codigo}")
	public String getById(@PathVariable("codigo") long codigo, Model model) {
		
		model.addAttribute("combate", cS.getById(codigo));
			LOGGER.info("Cargado combate.");
		return "combate";
	}
	
	@RequestMapping(value = "/addCombate")
	public String addCombate(Model model) {
			
		Combate combate = new Combate();
		combate.setActivo(true);
		model.addAttribute("combate", combate);
			
		
		List<Socio> competidores = sS.getCompetidores();
		List<Velada> veladas = vS.getAllPast();
		List<TipoResultadoCombate> resultados = tipoResultadoCombate.getAll();
		
		model.addAttribute("listadoVeladas", veladas);
		model.addAttribute("listadoCompetidores", competidores);
		model.addAttribute("listaResultados", resultados);
		
			LOGGER.info("Añadir combates, resultados, veladas y competidores.");
		return "combate";
	}
	
	@RequestMapping(value = "/editCombate/{codigocombate}")
	public ModelAndView editCombate(@PathVariable("codigocombate") long codigocombate) {
		
		mav = new ModelAndView("combate");
		mav.addObject("combate", cS.getById(codigocombate));
		
		List<TipoResultadoCombate> resultados = tipoResultadoCombate.getAll();
		mav.addObject("listaResultados", resultados);
		
		List<Socio> competidores = sS.getCompetidores();
		mav.addObject("listadoCompetidores", competidores);
		
		List<Velada> veladas = vS.getAllPast();
		mav.addObject("listadoVeladas", veladas);
		
			LOGGER.info("Editar combate.");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCombate(ModelMap model,@ModelAttribute("combate") 
							@Valid Combate combate,
							BindingResult bindingResult) {
		String destino = "";

		if (bindingResult.hasErrors()) {
				LOGGER.info("Los datos del combate tienen errores");
			destino = "combate";
		} else {
			destino = "redirect:/combates";
			if (combate.getCodigo() > -1) {
					LOGGER.info("Editar combate: ",combate.toString());
				cS.update(combate);
			} else {
					LOGGER.info("Crear combate: ", combate.toString());
				cS.create(combate);
			}
		}
		return destino;
	}
	
	@RequestMapping(value = "/deleteCombate/{id}") 
	public String delete(@PathVariable("id") long id, Model model) {
		cS.delete(id);
		LOGGER.info("Borrar combate: ", cS.getById(id).getCodigo());
		return "combates";
	}


}