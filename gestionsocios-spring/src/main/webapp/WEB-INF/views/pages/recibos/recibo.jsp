<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section class="row">
		<c:url var="sendUrl" value="/recibos/save"/>
		<c:url var="cancelUrl" value="/recibos"/>
	
	<form:form action="${sendUrl }" method="post" cssClass="form-horizontal" modelAttribute="recibo">
		<c:if test="${!empty recibo}">
			<form:hidden path="codigo"/>
		</c:if>
		
		<div class="form-group">
			<form:label cssClass="control-label col-xs-2" path="socio">Socio:</form:label>
				<div class="col-xs-4">
					<form:select cssClass="form-control" path="socio">
			            <form:option value="0" label="Elige un socio"/>
						<form:options items="${listadoSocios}" itemValue="codigo" itemLabel="identificador" />
			        </form:select> 
			     </div>
		   	 <form:errors cssClass="text-danger col-xs-6"  path="socio"/>   
		</div>
		<div class="form-group">
			<form:label path="cantidad" cssClass="control-label  col-xs-2">Cantidad:</form:label>
			<div class="col-xs-4">	
				<form:input path="cantidad"  cssClass="form-control" cssErrorClass="form-control text-danger" />
			</div>
			<form:errors path="cantidad" cssClass="text-danger col-xs-6" />
		</div>
		<div class="form-group">
			<form:label path="concepto" cssClass="control-label  col-xs-2">Concepto:</form:label>
			<div class="col-xs-4">
				<form:input path="concepto" cssClass="form-control" cssErrorClass="form-control text-danger" />
			</div>
			<form:errors path="concepto" cssClass="text-danger col-xs-6" />
		</div>
		<div class="form-group">
			<form:label path="fechapago" cssClass="control-label  col-xs-2">Fecha de pago:</form:label>
			<div class="col-xs-4">
				<form:input path="fechapago" placeholder="dd/MM/yyyy" 
					pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"  cssClass="form-control" cssErrorClass="form-control text-danger"/>
			</div>
			<form:errors path="fechapago" cssClass="text-danger col-xs-6" />
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

