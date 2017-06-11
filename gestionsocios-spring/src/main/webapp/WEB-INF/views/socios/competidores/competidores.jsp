<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section class="row">
		<header class="col-xs-12"><h2 class="">${competidoresTitulo}</h2></header>
		<div class="row">
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Nombre</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Apellidos</div>
			<!-- 	<div class="hidden-xs col-sm-2">Record</div>  -->
		</div>
			
			<c:choose>
				<c:when test="${not empty listadoCompetidores}">
				<c:forEach var="socio" items="${listadoCompetidores}">
				<div class="row">
					<div class="col-xs-1 col-md-2 col-lg-1">
						${socio.nombre}
					</div>
					<div class="col-xs-1 col-md-2 col-lg-1">
						${socio.apellidos}
					</div>
				<!--  	<div class="col-xs-2"> Record </div> -->
				</div>
				</c:forEach>
				
				</c:when>
					<c:otherwise><!-- Cuando la lista NO tiene datos -->
						<div class="row"><span class="text-danger text-center">No se han encontrado competidores en la Base de Datos</span></div>
					</c:otherwise>
			</c:choose>
		
	</section>
	
	

