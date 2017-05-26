package com.ipartek.formacion.api.restfulservers.recibo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.persistence.Recibo;
import com.ipartek.formacion.service.interfaces.ReciboService;

/**
*
@author Violeta González
*
**/

@CrossOrigin(origins ="*", maxAge = 3600, 
methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RestController
@RequestMapping(value = "/api/recibo")
public class ReciboRestController {

	@Autowired
	ReciboService sS;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReciboRestController.class);
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Recibo> getById(@PathVariable("codigo") int codigo) {
		
		Recibo recibo = sS.getById(codigo);
		ResponseEntity<Recibo> response = null;
		
		if (recibo == null) {
			response = new ResponseEntity<Recibo>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Recibo>(HttpStatus.OK);
		}
		
		return response;
	}
	
	public ResponseEntity<List<Recibo>> getAll() {
		List<Recibo> recibos = sS.getAll();
		ResponseEntity<List<Recibo>> response = null;
		
		if (recibos == null || recibos.isEmpty()) {
			response = new ResponseEntity<List<Recibo>>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<List<Recibo>>(recibos, HttpStatus.OK);
		}
				
		return response;
	}
	
	@RequestMapping(value= "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Recibo> update(@PathVariable("codigo")
	int id, @RequestBody Recibo recibo) {
		
	//@PathVariable("codigo") int id relaciona codigo e id.
		
		Recibo alum = sS.getById(id);
		ResponseEntity<Recibo> response = null;
		
		if (alum == null) {
			response = new ResponseEntity<Recibo>(HttpStatus.NOT_FOUND);
		} else {
			
			try {
		
				alum = sS.update(recibo);
				response = new ResponseEntity<Recibo>(alum, HttpStatus.ACCEPTED);
				
			} catch (Exception e) {
				response = new ResponseEntity<Recibo>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		return response;
		
	}

	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Recibo> deleteById(@PathVariable("codigo")
	int id) {
	
		Recibo alum = sS.getById(id);
		ResponseEntity<Recibo> response = null;
		
		if (alum == null) {
			response = new ResponseEntity<Recibo>(HttpStatus.NOT_FOUND);
		} else {
			sS.delete(id);
			response = new ResponseEntity<Recibo>(HttpStatus.NO_CONTENT);
		}
		
		return response;
		
	}
	
}