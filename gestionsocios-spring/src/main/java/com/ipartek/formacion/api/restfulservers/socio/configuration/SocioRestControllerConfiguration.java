package com.ipartek.formacion.api.restfulservers.socio.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
*
*
@author Violeta González
*
*
**/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ipartek.formacion.api.restfulservers")
public class SocioRestControllerConfiguration {

}