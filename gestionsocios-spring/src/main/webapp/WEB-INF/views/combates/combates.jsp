<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<section class="row">
		<header class="col-xs-12"><h2 class="">${combatesTitulo }</h2></header>
		<div class="row">
			<sec:authorize access="isAuthenticated()">
				<div class="col-xs-5 col-md-10 col-lg-5">
					<a class="btn btn-info" href="<c:url value='/combates/addCombate'/>">Introducir combate</a>
				</div>	
			</sec:authorize>
		</div>
	
	
		<div class="row">
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Fecha</div>
				<div class="col-xs-2 col-md-4 col-lg-2" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Competidor</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Resultado</div>
				<div class="col-xs-3 col-md-6 col-lg-3" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Comentarios</div>
		</div>
			
			<c:choose>
				<c:when test="${not empty listadoCombates}">
			
					<c:forEach var="combate" items="${listadoCombates}">
					<div class="row">
						<div class="col-xs-1 col-md-2 col-lg-1">
							<fmt:formatDate pattern="dd/MM/yyyy" value="${combate.velada.fecha}" />					
						</div>
						<div class="col-xs-2 col-md-4 col-lg-2">${combate.socio.identificador}</div>
						<div class="col-xs-1 col-md-2 col-lg-1">${combate.resultado}</div>
						<div class="col-xs-3 col-md-6 col-lg-3">${combate.comentarios}</div>

						<sec:authorize access="isAuthenticated()">
							<div class="col-xs-1 col-md-2 col-lg-1">
								<a class="btn btn-success" href="<c:url value='/combates/editCombate/${combate.codigo}'/>">Editar</a>
							</div>
							<div class="col-xs-1 col-md-2 col-lg-1">
								<a class="btn btn-danger" href="<c:url value='/combates/deleteCombate/${combate.codigo}'/>">Borrar</a>
							</div>
						</sec:authorize>
					</div>
					</c:forEach>
				</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<div class="row"><span class="text-danger text-center">No se han encontrado combates en la Base de Datos</span></div>
				</c:otherwise>
			</c:choose>
		</div>
	
	</section>
	

