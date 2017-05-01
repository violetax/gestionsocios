package com.ipartek.formacion.api.restfulservers.socio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.persistence.Socio;
import com.ipartek.formacion.service.interfaces.SocioService;
/**
*
*
@author Violeta González
*
*
**/

@CrossOrigin(origins ="*", maxAge = 3600, 
methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RestController
@RequestMapping(value = "/api/socios")
public class SocioRestController {

	@Autowired
	SocioService sS;
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Socio> getById(@PathVariable("codigo") int codigo) {
		
		Socio socio = sS.getById(codigo);
		ResponseEntity<Socio> response = null;
		
		if (socio == null) {
			response = new ResponseEntity<Socio>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Socio>(HttpStatus.OK);
		}
		
		return response;
	}
	
	public ResponseEntity<List<Socio>> getAll() {
		List<Socio> socios = sS.getAll();
		ResponseEntity<List<Socio>> response = null;
		
		if (socios == null || socios.isEmpty()) {
			response = new ResponseEntity<List<Socio>>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<List<Socio>>(socios, HttpStatus.OK);
		}
				
		return response;
	}
	
	@RequestMapping(value= "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Socio> update(@PathVariable("codigo")
	int id, @RequestBody Socio socio) {
		
	//@PathVariable("codigo") int id relaciona codigo e id.
		
		Socio alum = sS.getById(id);
		ResponseEntity<Socio> response = null;
		
		if (alum == null) {
			response = new ResponseEntity<Socio>(HttpStatus.NOT_FOUND);
		} else {
			
			try {
		
				alum = sS.update(socio);
				response = new ResponseEntity<Socio>(alum, HttpStatus.ACCEPTED);
				
			} catch (Exception e) {
				response = new ResponseEntity<Socio>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		return response;
		
	}

	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Socio> deleteById(@PathVariable("codigo")
	int id) {
	
		Socio alum = sS.getById(id);
		ResponseEntity<Socio> response = null;
		
		if (alum == null) {
			response = new ResponseEntity<Socio>(HttpStatus.NOT_FOUND);
		} else {
			sS.delete(id);
			response = new ResponseEntity<Socio>(HttpStatus.NO_CONTENT);
		}
		
		return response;
		
	}
	
}