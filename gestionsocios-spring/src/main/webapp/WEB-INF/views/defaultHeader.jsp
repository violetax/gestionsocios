<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" 
crossorigin="anonymous">


<title>
	<spring:message text="Gestion BoxBox" scope="page" code="aplicacion.nombre" /> 
		<!-- -   <c:out value="${seccion}"/> --> 
</title>

<spring:message var="idiomasTitulo" code="idiomas.titulo" />
<spring:message var="idiomaCastellano" code="idioma.castellano" />
<spring:message var="idiomaIngles" code="idioma.ingles" />
<spring:message var="botonLogout" code="boton.logout" />
<spring:message var="botonLogin" code="boton.login" />


</head>
<body>

<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Pincha para visualizar</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      

	    </div>
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li>
				<a href="<c:url value='/cursos'/>">
					<spring:message code="menu.cursos" text="G. Cursos" />
				</a>
	        </li>
	        <li role="separator" class="divider"></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
			<li>
			<sec:authorize access="isAnonymous()">
			    <form method="POST"  role="form" class="navbar-form navbar-right" action="<c:url value='/login'/>">
			         <div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
				        <input name="userId" type="text" class="form-control" value="${SPRING_SECURITY_LAST_USERNAME}" />
				     </div> 
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						<input name="password" class="form-control" type="password" />
					</div> 

			        <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
					<div class="form-group ">				
				   		 <button type="submit" class="btn btn-primary">Login</button>
				   	</div>
			    </form>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			    <a class="btn " href="<c:url value="/logout" />">Logout</a>
			</sec:authorize>
			</li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>