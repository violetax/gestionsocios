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

<spring:message var="aplicacionNombre" scope="request" code="aplicacion.nombre" />
<spring:message var="botonLogin" scope="request" code="boton.login" />
<spring:message var="botonLogout" scope="request" code="boton.logout" />
<spring:message var="botonAcceso" scope="request" code="boton.acceso" />
<spring:message var="clubNombre" scope="request" code="club.nombre" />
<spring:message var="idiomasTitulo" scope="request" code="idiomas.titulo" />
<spring:message var="idiomaCastellano" scope="request" code="idioma.castellano" />
<spring:message var="idiomaIngles" scope="request" code="idioma.ingles" />
<spring:message var="formEditar" scope="request" code="form.editar" />
<spring:message var="formGuardar" scope="request" code="form.guardar" />
<spring:message var="formCancelar" scope="request" code="form.cancelar" />
<spring:message var="formCrear" scope="request" code="form.crear" />
<spring:message var="homeTitulo" scope="request" code="home.titulo" />
<spring:message var="menuCombates" scope="request" code="menu.combates" />
<spring:message var="menuRecibos" scope="request" code="menu.recibos" />
<spring:message var="menuSocios" scope="request" code="menu.socios" />
<spring:message var="menuCompetidores" scope="request" code="menu.competidores" />
<spring:message var="menuVeladas" scope="request" code="menu.veladas" />
<spring:message var="combatesTitulo" scope="request" code="combates.titulo" />
<spring:message var="combateTitulo" scope="request" code="combate.titulo" />
<spring:message var="combateResultado" scope="request" code="combate.resultado" />
<spring:message var="combateComentarios" scope="request" code="combate.comentarios" />
<spring:message var="recibosTitulo" scope="request" code="recibos.titulo" />
<spring:message var="reciboTitulo" scope="request" code="recibo.titulo" />
<spring:message var="reciboCantidad" scope="request" code="recibo.cantidad" />
<spring:message var="reciboConcepto" scope="request" code="recibo.concepto" />
<spring:message var="reciboFecha" scope="request" code="recibo.fecha" />
<spring:message var="sociosSocios" scope="request" code="socios.titulo" />
<spring:message var="socioTitulo" scope="request" code="socio.titulo" />
<spring:message var="socioNombre" scope="request" code="socio.nombre" />
<spring:message var="socioApellidos" scope="request" code="socio.apellidos" />
<spring:message var="socioTelefono" scope="request" code="socio.telefono" />
<spring:message var="socioEmail" scope="request" code="socio.email" />
<spring:message var="socioNrotarjeta" scope="request" code="socio.nrotarjeta" />
<spring:message var="socioCompetidor" scope="request" code="socio.competidor" />
<spring:message var="competidoresTitulo" scope="request" code="competidores.titulo" />
<spring:message var="competidoresNombre" scope="request" code="competidores.nombre" />
<spring:message var="competidoresApellidos" scope="request" code="competidores.apellidos" />
<spring:message var="competidoresRecord" scope="request" code="competidores.record" />
<spring:message var="veladasTitulo" scope="request" code="veladas.titulo" />
<spring:message var="veladaTitulo" scope="request" code="velada.titulo" />
<spring:message var="veladaFecha" scope="request" code="velada.fecha" />
<spring:message var="veladaLugar" scope="request" code="velada.lugar" />
<spring:message var="veladaProvincia" scope="request" code="velada.provincia" />
<spring:message var="veladaComentarios" scope="request" code="velada.comentarios" />
<spring:message var="formularioSocios" scope="request" code="formulario.socios" />
<spring:message var="formularioRecibos" scope="request" code="formulario.recibos" />
<spring:message var="formularioVeladas" scope="request" code="formulario.veladas" />
<spring:message var="formularioCombates" scope="request" code="formulario.combates" />


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