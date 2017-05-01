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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.controller.validator.VeladaValidator;
import com.ipartek.formacion.persistence.Velada;
import com.ipartek.formacion.service.interfaces.VeladaService;
/**
*
*
@author Violeta González
*
*
**/

@Controller
@RequestMapping(value = "/veladas")
public class VeladaController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VeladaController.class);
	private ModelAndView mav = null;
	
	@Autowired
	private VeladaService vS;
	@Resource(name = "veladaValidator")
	VeladaValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("veladas");
			List<Velada> veladas = vS.getAll();
		mav.addObject("listadoVeladas", veladas);
			LOGGER.info("Cargada lista de veladas.");
		return mav;
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView getById(@PathVariable("id") long id) {
		mav = new ModelAndView("velada");
		mav.addObject("velada", vS.getById(id));
			LOGGER.info("Cargadas veladas.");
		return mav;
	}
	
	@RequestMapping(value = "/addVelada")
	public String addVelada(Model model) {
		
		Velada velada = new Velada();
		velada.setActivo(true);	
		model.addAttribute("velada", velada);
			LOGGER.info("Añadir velada.");
		return "velada";
	}
	
	@RequestMapping(value = "/editVelada/{codigovelada}")
	public ModelAndView editVelada(@PathVariable("codigovelada") long codigovelada) {
		
		mav = new ModelAndView("velada");
		
		Velada velada = vS.getById(codigovelada);
		mav.addObject("velada", velada);
		
			LOGGER.info("Editar velada");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveVelada(Model model,@ModelAttribute("velada") 
							@Valid Velada velada,
							BindingResult bindingResult) {
		String destino = "";

		if (bindingResult.hasErrors()) {
			LOGGER.info("Los datos del velada tienen errores");
			destino = "velada";
		} else {
			destino = "redirect:/veladas";
			if (velada.getCodigo() > -1) {
				LOGGER.info("Editar velada: ", velada.toString());
				vS.update(velada);
			} else {
				LOGGER.info("Crear velada: ", velada.toString());
				vS.create(velada);
			}
		}
		return destino;
	}
	
	@RequestMapping(value = "/deleteVelada/{id}") 
	public String delete(@PathVariable("id") long id, Model model) {
		vS.delete(id);
			LOGGER.info("Borrar velada: ", vS.getById(id).getCodigo());
		return "veladas";
	}

	
}