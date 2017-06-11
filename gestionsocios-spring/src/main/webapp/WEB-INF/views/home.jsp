<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="defaultHeader.jsp" />

<div class="jumbotron">
  <h1>${clubNombre}</h1>
  <p>	
  		<a class="btn btn-primary btn-lg" href="<c:url value='/socios'/>">${menuSocios}</a>
  		<a class="btn btn-primary btn-lg" href="<c:url value='/socios/competidores'/>" >${menuCompetidores}</a> 
  		<a class="btn btn-primary btn-lg" href="<c:url value='/veladas'/>">${menuVeladas}</a> 
  		<a class="btn btn-primary btn-lg" href="<c:url value='/combates'/>">${menuCombates}</a>
  	</p>
</div>

<jsp:include page="defaultFooter.jsp" />