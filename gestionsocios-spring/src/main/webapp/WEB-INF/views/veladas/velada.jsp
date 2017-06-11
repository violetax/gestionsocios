    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section class="row">
		<c:url var="sendUrl" value="/veladas/save"/>
		<c:url var="cancelUrl" value="/veladas"/>
	
	<form:form action="${sendUrl }" method="post" cssClass="form-horizontal" modelAttribute="velada">
		<c:if test="${!empty velada}">
			<form:hidden path="codigo"/>
		</c:if>
		
		<div class="form-group">
			<form:label path="fecha" cssClass="control-label  col-xs-2">Fecha:</form:label>
			<div class="col-xs-4">
				<form:input path="fecha" placeholder="dd/MM/yyyy" 
					pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"  cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="fecha" cssClass="text-danger col-xs-6" />
		</div>	
		<div class="form-group">
			<form:label path="lugar" cssClass="control-label  col-xs-2">Lugar:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="lugar" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="lugar" cssClass="text-danger col-xs-6" />
		</div>
		<div class="form-group">
			<form:label path="provincia" cssClass="control-label  col-xs-2">Provincia:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="provincia" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="provincia" cssClass="text-danger col-xs-6" />
		</div>
		<div class="form-group">
			<form:label path="comentarios" cssClass="control-label  col-xs-2">Comentarios:</form:label>
			<div class="col-xs-4">
				<form:input type="text" path="comentarios" cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="comentarios" cssClass="text-danger col-xs-6" />
		</div>
		
		<div class="form-group">
			<div class="col-md-offset-3">
				<button type="submit" class="btn btn-success">${formGuardar}</button>
				<a class="btn btn-warning" href="${cancelUrl}">${formCancelar}</a>
			</div>
		</div>
		<form:hidden path="activo"/>
	</form:form>
	</section>

