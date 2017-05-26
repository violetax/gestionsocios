package com.ipartek.formacion.api.restfulservers.combate;

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

import com.ipartek.formacion.persistence.Combate;
import com.ipartek.formacion.service.interfaces.CombateService;

/**
*
@author Violeta González
*
**/

//@CrossOrigin(origins ="*", maxAge = 3600, 
//methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RestController
@RequestMapping(value = "/api/combate")
public class CombateRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CombateRestController.class);

	@Autowired
	CombateService sS;

	@RequestMapping(value="/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Combate> getById(@PathVariable("codigo") int codigo) {
		
		Combate combate = sS.getById(codigo);
		ResponseEntity<Combate> response = null;
		
		if (combate == null) {
			response = new ResponseEntity<Combate>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Combate>(HttpStatus.OK);
		}
		
		return response;
	}
	
	public ResponseEntity<List<Combate>> getAll() {
		List<Combate> combates = sS.getAll();
		ResponseEntity<List<Combate>> response = null;
		
		if (combates == null || combates.isEmpty()) {
			response = new ResponseEntity<List<Combate>>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<List<Combate>>(combates, HttpStatus.OK);
		}
				
		return response;
	}
	
	@RequestMapping(value= "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Combate> update(@PathVariable("codigo")
	int id, @RequestBody Combate combate) {
		
	//@PathVariable("codigo") int id relaciona codigo e id.
		
		Combate alum = sS.getById(id);
		ResponseEntity<Combate> response = null;
		
		if (alum == null) {
			response = new ResponseEntity<Combate>(HttpStatus.NOT_FOUND);
		} else {
			
			try {
		
				alum = sS.update(combate);
				response = new ResponseEntity<Combate>(alum, HttpStatus.ACCEPTED);
				
			} catch (Exception e) {
				response = new ResponseEntity<Combate>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		return response;
		
	}

	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Combate> deleteById(@PathVariable("codigo")
	int id) {
	
		Combate alum = sS.getById(id);
		ResponseEntity<Combate> response = null;
		
		if (alum == null) {
			response = new ResponseEntity<Combate>(HttpStatus.NOT_FOUND);
		} else {
			sS.delete(id);
			response = new ResponseEntity<Combate>(HttpStatus.NO_CONTENT);
		}
		
		return response;
		
	}
	
}