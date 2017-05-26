package com.ipartek.formacion.api.restfulservers.velada;

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

import com.ipartek.formacion.persistence.Velada;
import com.ipartek.formacion.service.interfaces.VeladaService;
/**
*
@author Violeta González
*
**/

@CrossOrigin(origins ="*", maxAge = 3600, 
methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RestController
@RequestMapping(value = "/api/velada")
public class VeladaRestController {

	@Autowired
	VeladaService sS;
	private static final Logger LOGGER = LoggerFactory.getLogger(VeladaRestController.class);

	@RequestMapping(value="/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Velada> getById(@PathVariable("codigo") int codigo) {
		
		Velada velada = sS.getById(codigo);
		ResponseEntity<Velada> response = null;
		
		if (velada == null) {
			response = new ResponseEntity<Velada>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Velada>(HttpStatus.OK);
		}
		
		return response;
	}
	
	public ResponseEntity<List<Velada>> getAll() {
		List<Velada> veladas = sS.getAll();
		ResponseEntity<List<Velada>> response = null;
		
		if (veladas == null || veladas.isEmpty()) {
			response = new ResponseEntity<List<Velada>>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<List<Velada>>(veladas, HttpStatus.OK);
		}
				
		return response;
	}
	
	@RequestMapping(value= "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Velada> update(@PathVariable("codigo")
	int id, @RequestBody Velada velada) {
		
	//@PathVariable("codigo") int id relaciona codigo e id.
		
		Velada alum = sS.getById(id);
		ResponseEntity<Velada> response = null;
		
		if (alum == null) {
			response = new ResponseEntity<Velada>(HttpStatus.NOT_FOUND);
		} else {
			
			try {
		
				alum = sS.update(velada);
				response = new ResponseEntity<Velada>(alum, HttpStatus.ACCEPTED);
				
			} catch (Exception e) {
				response = new ResponseEntity<Velada>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		return response;
		
	}

	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Velada> deleteById(@PathVariable("codigo")
	int id) {
	
		Velada alum = sS.getById(id);
		ResponseEntity<Velada> response = null;
		
		if (alum == null) {
			response = new ResponseEntity<Velada>(HttpStatus.NOT_FOUND);
		} else {
			sS.delete(id);
			response = new ResponseEntity<Velada>(HttpStatus.NO_CONTENT);
		}
		
		return response;
		
	}
	
}