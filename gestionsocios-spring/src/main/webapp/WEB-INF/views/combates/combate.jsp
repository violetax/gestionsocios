<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message var="men" code="formCrear" text="nombre" />
<c:if test="${curso.codigo > 0}" >
	<spring:message var="men"  code="formEditar" text="nombre" />
</c:if> 


<section class="row">
		<c:url var="sendUrl" value="/combates/save"/>
		<c:url var="cancelUrl" value="/combates"/>
	
	<form:form action="${sendUrl }" method="post" cssClass="form-horizontal" modelAttribute="combate">
		<c:if test="${!empty combate}">
			<form:hidden path="codigo"/>
		</c:if>
		
		<div class="form-group">
			<form:label path="velada" cssClass="control-label  col-xs-2">Velada:</form:label>
				<div class="col-xs-4">
					<form:select cssClass="form-control" path="velada">
			            <form:option value="0" label="Elige velada"/>
						<form:options items="${listadoVeladas}" itemValue="codigo" itemLabel="identificador" />
			        </form:select> 
			     </div>
			<form:errors path="velada" cssClass="text-danger col-xs-6"></form:errors>
		</div>
		
		<div class="form-group">
			<form:label cssClass="control-label col-xs-2" path="socio">Competidor:</form:label>
				<div class="col-xs-4">
					<form:select cssClass="form-control" path="socio">
			            <form:option value="0" label="Elige un competidor"/>
						<form:options items="${listadoCompetidores}" itemValue="codigo" itemLabel="identificador" />
			        </form:select> 
			     </div>
		   	 	 <form:errors cssClass="text-danger col-xs-6"  path="socio"/>   
			</div>
			
		<div class="form-group">
			<form:label cssClass="control-label col-xs-2" path="resultado">Resultado:</form:label>
			<div class="col-xs-4">
				<form:select cssClass="form-control" path="resultado">
			        <form:option value="0" label="Señala el resultado"/>
					<form:options items="${listaResultados}" itemValue="resultado" itemLabel="resultado" />
			    </form:select> 
			</div>
			<form:errors path="resultado" cssClass="text-danger col-xs-6"></form:errors>
		</div>
		
		<div class="form-group">
			<form:label path="comentarios" cssClass="control-label  col-xs-2">Comentarios</form:label>
				<div class="col-xs-4">
					<form:input type="text" path="comentarios" cssClass="form-control" cssErrorClass="form-control text-danger"/>
				</div>
			<form:errors path="comentarios" cssClass="text-danger col-xs-6"></form:errors>
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
