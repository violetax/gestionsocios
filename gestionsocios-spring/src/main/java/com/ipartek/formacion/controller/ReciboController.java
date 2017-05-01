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

import com.ipartek.formacion.controller.validator.ReciboValidator;
import com.ipartek.formacion.persistence.Recibo;
import com.ipartek.formacion.persistence.Socio;
import com.ipartek.formacion.service.interfaces.ReciboService;
import com.ipartek.formacion.service.interfaces.SocioService;

/**
*
* @Violeta González
*
**/

@Controller
@RequestMapping(value = "/recibos")
public class ReciboController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReciboController.class);
	private ModelAndView mav = null;
	
	@Autowired
	private ReciboService rS;
	@Autowired
	private SocioService sS;
	@Resource(name="reciboValidator")
	ReciboValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("recibos");
		List<Recibo> recibos = rS.getAll();
			LOGGER.info("Lista: " + recibos.size());
		mav.addObject("listadoRecibos", recibos);
			LOGGER.info("Cargada lista de recibos.");
		return mav;
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView getById(@PathVariable("id") long id) {
		mav = new ModelAndView("recibo");
		mav.addObject("recibo", rS.getById(id));
			LOGGER.info("Cargado recibo.");
		return mav;
	}
	
	@RequestMapping(value = "/addRecibo")
	public String addRecibo(Model model) {
		
		Recibo recibo = new Recibo();
		recibo.setActivo(true);
		model.addAttribute("recibo", recibo);
			LOGGER.info("Añadir recibo.");
			
		List<Socio> socios = sS.getAll();
		model.addAttribute("listadoSocios", socios);
			
		return "recibo";
	}
	
	@RequestMapping(value = "/editRecibo/{codigorecibo}")
	public ModelAndView editRecibo(@PathVariable("codigorecibo") long codigorecibo) {
		
		mav = new ModelAndView("recibo");
		mav.addObject("recibo", rS.getById(codigorecibo));
		mav.addObject("listadoSocios", sS.getAll());
				
			LOGGER.info("Editar recibo.");
		
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRecibo(Model model, @ModelAttribute("recibo") 
							@Valid Recibo recibo,
							BindingResult bindingResult) {
		String destino = "";

		if (bindingResult.hasErrors()) {
				LOGGER.info("Los datos del recibo tienen errores");
			destino = "recibo";
		} else {
			destino = "redirect:/recibos";
			if (recibo.getCodigo() > -1) {
					LOGGER.info("Editar recibo: ",recibo.toString());
				rS.update(recibo);
			} else {
					LOGGER.info("Crear recibo: ",recibo.toString());
				rS.create(recibo);
			}
		}
		return destino;
	}
	
	@RequestMapping(value = "/deleteRecibo/{id}") 
	public String delete(@PathVariable("id") long id, Model model) {
		
		LOGGER.info("Borrar recibo: ", rS.getById(id).getCodigo());
		rS.delete(id);
		return "recibos";
	}

	
}
