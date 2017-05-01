package com.ipartek.formacion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
*
*
@author Violeta González
*
*
**/


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		LOGGER.info("Comienzo. La locale es: {}. La página es: {}", locale, "home");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		
		
		 return "home";
	}

	@RequestMapping(value = "login")
	public String loginPage(HttpServletRequest request) {
		
		LOGGER.info("Por aquí entra el logout.");
		
		String referer = request.getHeader("Referer");
		LOGGER.info("redirect: " + referer);
	    return "redirect:"+ referer;
		
	}
	
	
	@RequestMapping(value = "Access_Denied")
	public String accesoDenegado(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		
		LOGGER.info("LOGIN: Acceso DENEGADO en {}", "login");
		
		return "login";
	}

	@RequestMapping(method = RequestMethod.GET, value = "login.html")
	public String accessLogin(HttpServletRequest request) {
		
		LOGGER.info("Redirect login: Acceso a {}", "login");
		
		return "login";

	}

	private String getPrincipal() {
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			LOGGER.info("auth != null: LOGOUT SUCCESS: Acceso a {}", "login");
		}
		
		LOGGER.info("LOGOUT SUCCESS: Acceso a {}", "login");
		
		return "login";
		
	}
	

}