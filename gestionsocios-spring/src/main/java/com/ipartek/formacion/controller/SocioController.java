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

import com.ipartek.formacion.controller.validator.SocioValidator;
import com.ipartek.formacion.persistence.Socio;
import com.ipartek.formacion.service.interfaces.SocioService;
/**
*
*
@author Violeta González
*
*
**/

@Controller
@RequestMapping(value = "/socios")
public class SocioController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SocioController.class);
	private ModelAndView mav = null;
	
	@Autowired
	private SocioService sS;
	@Resource(name = "socioValidator")
	SocioValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("socios");
			List<Socio> socios = sS.getAll();
		mav.addObject("listadoSocios", socios);
			LOGGER.info("Cargada lista de socios.");
		return mav;
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView getById(@PathVariable("id") long id) {
		mav = new ModelAndView("socio");
		mav.addObject("socio", sS.getById(id));
			LOGGER.info("Cargado socio.");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/competidores")
	public ModelAndView getCompetidores() {
		
		mav = new ModelAndView("competidores");
		List<Socio> competidores = sS.getCompetidores();
			LOGGER.info("Lista: " + competidores.size());
		mav.addObject("listadoCompetidores", competidores);
			LOGGER.info("Cargados competidores.");
		
		return mav;
	}	
	
	@RequestMapping(value = "/addSocio")
	public String addSocio(Model model) {
		
		Socio socio = new Socio();
		socio.setActivo(true);
		model.addAttribute("socio", socio);
			LOGGER.info("Añadir socio.");
		return "socio";
	}
	
	@RequestMapping(value = "/editSocio/{codigosocio}")
	public ModelAndView editSocio(@PathVariable("codigosocio") long codigosocio) {
		
		mav = new ModelAndView("socio");
		mav.addObject("socio", sS.getById(codigosocio));
		
			LOGGER.info("Editar socio.");
		
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSocio(Model model, @ModelAttribute("socio") 
							@Valid Socio socio,
							BindingResult bindingResult) {
		String destino = "";

		if (bindingResult.hasErrors()) {
			LOGGER.info("Los datos del socio tienen errores");
			destino = "socio";
		} else {
			destino = "redirect:/socios";
			if (socio.getCodigo() > -1) {
				LOGGER.info("Editar socio: ",socio.toString());
				sS.update(socio);
			} else {
				LOGGER.info("Crear socio: ",socio.toString());
				sS.create(socio);
			}
		}
		return destino;
	}
	
	@RequestMapping(value = "/deleteSocio/{id}") 
	public String delete(@PathVariable("id") long id, Model model) {
		sS.delete(id);
			LOGGER.info("Borrar socio: ", sS.getById(id).getCodigo());
		return "socios";
	}

	
}