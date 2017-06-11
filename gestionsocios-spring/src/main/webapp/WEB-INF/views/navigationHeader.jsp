<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%><nav class="navbar navbar-inverse">

<div class="container-fluid">
	<!-- Brand and toggle get grouped for better mobile display -->
	   <div class="navbar-header">
	   	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Pincha para visualizar</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	    </button>
	   </div>
	   <!-- Collect the nav links, forms, and other content for toggling -->
	   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
		    	<li><a class="btn btn-round btn-lg" href="<c:url value='/'/>">${homeTitulo}</a></li>
	  			<li><a class="btn btn-primary btn-lg" href="<c:url value='/socios'/>">${menuSocios}</a></li>
  				<li><a class="btn btn-primary btn-lg" href="<c:url value='/socios/competidores'/>" >${menuCompetidores}</a></li>
  				<li><a class="btn btn-primary btn-lg" href="<c:url value='/veladas'/>">${menuVeladas}</a></li>
  				<li><a class="btn btn-primary btn-lg" href="<c:url value='/combates'/>">${menuCombates}</a></li>
   			</ul>
		</div>
 	</div>
</nav>     