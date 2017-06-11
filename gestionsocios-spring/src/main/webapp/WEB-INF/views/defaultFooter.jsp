<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message var="idiomasTitulo" code="idiomas.titulo" />
<spring:message var="idiomaCastellano" code="idioma.castellano" />
<spring:message var="idiomaIngles" code="idioma.ingles" />
<spring:message var="botonLogout" code="boton.logout" />
<spring:message var="botonLogin" code="boton.login" />

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav">
	    <li>
	        <div class="btn-group">
				<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" >
					${idiomasTitulo}<span class="caret"></span>
				</button>					
				<ul class="dropdown-menu">
					<li><a class="" href="?locale=es">${idiomaCastellano}</a></li>
					<li><a class="" href="?locale=en">${idiomaIngles}</a></li>
				</ul>					
			</div>
		</li>
	</ul>
	<ul class="nav navbar-nav">	 	
		<li>		 	
			<sec:authorize access="isAuthenticated()">
			<div class="dropdown">
		  		 <a class="btn btn-default btn-sm dropdown-toggle"  href="<c:url value="/logout" />">${botonLogout}</a>
		  	</div>
			</sec:authorize>	
			<sec:authorize access="isAnonymous()">
			<div class="dropdown">
  				<button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown">${botonLogin}</button>	
				<ul class="dropdown-menu">
		 			<li>
						<form method="POST"  role="form" class="navbar-form navbar-right" action="<c:url value='/login'/>">						         
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
								<input class="form-control input-sm" value="${SPRING_SECURITY_LAST_USERNAME}" type="text" id="userId" name="userId" required />
							</div> 										 
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
								<input class="form-control input-sm" type="password" id="password" name="password" required />
							</div> 
			
						    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							     
						    <div class="form-group ">				
								<button type="submit" class="btn btn-default">${botonLogin}</button>
							</div>
						</form>
					</li>
				</ul>
			</div>
			</sec:authorize>	
	    </li>
	  </ul>
</div>
   
<div class="col-xs-5 col-md-10 col-lg-5">
<footer>
Club Deportivo de Boxeo BoxBox
</footer>
</div>
</body>
</html>