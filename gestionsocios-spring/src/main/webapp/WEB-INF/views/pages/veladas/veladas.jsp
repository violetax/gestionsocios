<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<section class="row">
		<header class="col-xs-12"><h2 class="">${veladasTitulo }</h2></header>
	<div class="row">
		<sec:authorize access="isAuthenticated()">
			<div class="col-xs-5 col-md-10 col-lg-5">
				<a class="btn btn-info" href="<c:url value='/veladas/addVelada'/>">Introducir velada</a>
			</div>
		</sec:authorize>
	</div>	
			<div class="row">
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Fecha</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Lugar</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Provincia</div>
				<div class="col-xs-3 col-md-6 col-lg-3" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Comentarios</div>
			</div>
			
			<c:choose>
				<c:when test="${not empty listadoVeladas}">
					<c:forEach var="velada" items="${listadoVeladas}">
					<div class="row">
						<div class="col-xs-1 col-md-2 col-lg-1">
							<fmt:formatDate pattern="dd/MM/yyyy" value="${velada.fecha}" />
						</div>
						<div class="col-xs-1 col-md-2 col-lg-1">${velada.lugar}</div>
						<div class="col-xs-1 col-md-2 col-lg-1">${velada.provincia}</div>
						<div class="col-xs-3 col-md-6 col-lg-3">${velada.comentarios}</div>
						
						<sec:authorize access="isAuthenticated()">
							<div class="col-xs-1 col-md-2 col-lg-1">
								<a class="btn btn-success" href="<c:url value='/veladas/editVelada/${velada.codigo}'/>">Editar</a>
							</div>
							<div class="col-xs-1 col-md-2 col-lg-1">
								<a class="btn btn-danger" href="<c:url value='/veladas/deleteVelada/${velada.codigo}'/>">Borrar</a>
							</div>
						</sec:authorize>
					</div>	
					</c:forEach>
				</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<div class="row"><span class="text-danger text-center">No se han encontrado veladas en la Base de Datos</span></div>
				</c:otherwise>
			</c:choose>
		
	</section>	
	

