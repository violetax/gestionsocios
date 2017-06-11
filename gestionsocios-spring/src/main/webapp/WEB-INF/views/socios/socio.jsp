    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section class="row">
		<c:url var="sendUrl" value="/socios/save"/>
		<c:url var="cancelUrl" value="/socios"/>
	
	<form:form action="${sendUrl }" method="post" cssClass="form-horizontal" modelAttribute="socio">
		<c:if test="${!empty socio}">
			<form:hidden path="codigo"/>
		</c:if>
		
		
		<div class="form-group">
			<form:label path="nombre" cssClass="control-label  col-xs-2">Nombre:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="nombre" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="nombre" cssClass="text-danger col-xs-6" />
		</div>
		
		<div class="form-group">
			<form:label path="apellidos" cssClass="control-label  col-xs-2">Apellidos:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="apellidos" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="apellidos" cssClass="text-danger col-xs-6" />
		</div>
		<div class="form-group">
			<form:label path="email" cssClass="control-label  col-xs-2">Email:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="email" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="email" cssClass="text-danger col-xs-6" />
		</div>
		<div class="form-group">
			<form:label path="telefono" cssClass="control-label  col-xs-2">Telefono:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="telefono" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="telefono" cssClass="text-danger col-xs-6" />
		</div>
		<div class="form-group">
			<form:label path="nrotarjeta" cssClass="control-label  col-xs-2">Número de tarjeta:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="nrotarjeta" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="nrotarjeta" cssClass="text-danger col-xs-6" />
		</div>
		<div class="form-group">	
			<form:label path="competidor" cssClass="control-label  col-xs-2">Competidor:</form:label>
			<div class="col-xs-4">
				<form:checkbox path="competidor"/>			
			</div>
			<form:errors path="competidor" cssClass="text-danger col-xs-6" />				  
		</div>
		
		<!-- 
		
		<form:input type="text" path="competidor" cssClass="form-control" cssErrorClass="form-control text-danger"/>
		
		<input type="checkbox" id="${socio.codigo}" value="${socio.competidor}">
		 -->
		
		
		<div class="form-group">
			<div class="col-md-offset-3">
				<button type="submit" class="btn btn-success">${formGuardar}</button>
				<a class="btn btn-warning" href="${cancelUrl}">${formCancelar}</a>
			</div>
		</div>
		<form:hidden path="activo"/>
	</form:form>
	</section>

