<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  

<section class="row">
		<header class="col-xs-12"><h2 class="">${recibosTitulo }</h2></header>
		
		<div class="row">
			<div class="col-xs-5 col-md-10 col-lg-5">
				<a class="btn btn-info" href="<c:url value='/recibos/addRecibo'/>">Introducir recibo</a>
			</div>
		</div>
		
<div class="row">
				<div class="col-xs-2 col-md-4 col-lg-2" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Socio</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Fecha</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Cantidad</div>
				<div class="col-xs-2 col-md-4 col-lg-2" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Concepto</div>
				
		</div>
		<c:choose>
				<c:when test="${not empty listadoRecibos}">
					<c:forEach var="recibo" items="${listadoRecibos}">
					<div class="row">
						<div class="col-xs-2 col-md-4 col-lg-2">${recibo.socio.identificador}</div>
						<div class="col-xs-1 col-md-2 col-lg-1">
							<fmt:formatDate pattern="dd/MM/yyyy" value="${recibo.fechapago}" />					
						</div>
						<div class="col-xs-1 col-md-2 col-lg-1">${recibo.cantidad}</div>
						<div class="col-xs-2 col-md-4 col-lg-2">${recibo.concepto}</div>
						<div class="col-xs-1 col-md-2 col-lg-1">
							<a class="btn btn-success" href="<c:url value='/recibos/editRecibo/${recibo.codigo}'/>">Editar</a>
						</div>
						<div class="col-xs-1 col-md-2 col-lg-1">
							<a class="btn btn-danger" href="<c:url value='/recibos/deleteRecibo/${recibo.codigo}'/>">Borrar</a>
						</div>
					</div>
					</c:forEach>
				</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<div class="row"><span class="text-danger text-center">No se han encontrado combates en la Base de Datos</span></div>
				</c:otherwise>
			</c:choose>
						
	</section>
	

