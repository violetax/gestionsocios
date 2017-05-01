package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.dbms.pojo.TipoResultadoCombate;
/**
*
*
@author Violeta González
*
*
**/


@Service("tipoResultadoCombateServiceImp")
public class TipoResultadoCombateServiceImp{

	private TipoResultadoCombate resultado;
	private List<TipoResultadoCombate> listaResultados;
	
	public TipoResultadoCombateServiceImp () {
		super();
		listaResultados = new ArrayList<TipoResultadoCombate>();
		init();
	}
	
	private void init() {
		
		resultado = new TipoResultadoCombate();
		resultado.setResultado("VUD");
			listaResultados.add(resultado);
		
		resultado = new TipoResultadoCombate();
		resultado.setResultado("VMD");
			listaResultados.add(resultado);
        
		resultado = new TipoResultadoCombate();	
		resultado.setResultado("VSD");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();
        resultado.setResultado("VPT");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();	
        resultado.setResultado("VKO");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();	
        resultado.setResultado("VKT");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();
        resultado.setResultado("DUD");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();		
        resultado.setResultado("DMD");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();	
        resultado.setResultado("DSD");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();
        resultado.setResultado("DPT");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();	
        resultado.setResultado("DKO");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();
        resultado.setResultado("DKT");
        	listaResultados.add(resultado);
        
        resultado = new TipoResultadoCombate();	
        resultado.setResultado("NUD");
        	listaResultados.add(resultado);    
        
        resultado = new TipoResultadoCombate();	
        resultado.setResultado("NMD");
        	listaResultados.add(resultado);

		
	}


	public List<TipoResultadoCombate> getAll() {
		
		return listaResultados;
	}

}
