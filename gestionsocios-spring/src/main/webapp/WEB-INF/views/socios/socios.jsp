<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<jsp:include page="../defaultHeader.jsp" />

<section class="row">
		
		<header class="col-xs-12"><h2 class=""> ${sociosTitulo } </h2></header>
		
		<div class="row">
			<sec:authorize access="isAuthenticated()">
				<div class="col-xs-5 col-md-10 col-lg-5">
					<a class="btn btn-info" href="<c:url value='/socios/addSocio'/>">Nuevo socio</a>
				</div>
			</sec:authorize>
		
			<sec:authorize access="isAuthenticated()">
				<div class="col-xs-5 col-md-10 col-lg-5">
					<a class="btn btn-warning" href="<c:url value='/recibos'/>">Ver recibos</a>
				</div>
			</sec:authorize>
		</div>
	
		<div class="row">
				<div class="col-xs-2 col-md-4 col-lg-2" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Socio</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Email</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Teléfono</div>
				<div class="col-xs-1 col-md-2 col-lg-1" style="display: inline-block; background-color:#87CEFA; box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);">Activo</div>
		</div>
		
		<c:choose>
			<c:when test="${not empty listadoSocios}">
				<c:forEach var="socio" items="${listadoSocios}">
				<div class="row">
					<div class="col-xs-2 col-md-4 col-lg-2">${socio.identificador}</div>
					<div class="col-xs-1 col-md-2 col-lg-1">${socio.email}</div>
					<div class="col-xs-1 col-md-2 col-lg-1">${socio.telefono}</div>
					<div class="col-xs-1 col-md-2 col-lg-1">
						<c:choose>
    						<c:when test="${socio.competidor == true }">
									Competidor
							 </c:when>    
	   						<c:otherwise>
	   								Socio
	   						</c:otherwise>
   						</c:choose>	
					</div>					
					<sec:authorize access="isAuthenticated()">
							<div class="col-xs-1 col-md-2 col-lg-1">
								<a class="btn btn-success" href="<c:url value='/socios/editSocio/${socio.codigo}'/>">Editar</a>
							</div>
							<div class="col-xs-1 col-md-2 col-lg-1">
								<a class="btn btn-danger" href="<c:url value='/socios/deleteSocio/${socio.codigo}'/>">Borrar</a>
							</div>
					</sec:authorize>					
				</div>
				</c:forEach>
				
			</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<div class="row"><span class="text-danger text-center">No se han encontrado socios en la Base de Datos</span></div>
				</c:otherwise>
			
		</c:choose>
		
	</section>
	
	<jsp:include page="../defaultFooter.jsp" />	

