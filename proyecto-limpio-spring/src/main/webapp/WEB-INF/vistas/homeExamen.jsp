<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->	 	    
	     <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  
	    <!-- Bootstrap theme -->
	    <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet">
	    	    	    	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>		 
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/funciones.js"></script> 
	</head>  


<body onload="deshabilitaRetroceso()">
		<header class="panel-primary">
<div class="container-fluid panel-heading">
 <h1><center><img src="${pageContext.request.contextPath}/img/Logo.jpg"/></center></h1>
   <div class="col-md-11"> <h4>${Nombre} ${Apellido}</h4></div>  
    <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>

</header>
			
<div class="row">
  <div class="col-md-4"></div>
<div class="col-md-4">	<br><br>
<div class="panel panel-primary"><div class="panel-heading">${Examen.nombre}</div></div>		  
<form:form action="corregir-examen" method="POST" modelAttribute="Examen" >

 <input type="hidden" name="IdExamen" value="${Examen.id}">
	<input type="hidden" name="nombre" value="${Nombre}">
  <input type="hidden" name="apellido" value="${Apellido}">
	<!--Union de dos clases-->
	<c:forEach items= "${Examen.preguntas}" var="pregunta" >
	
		<div id="${pregunta.id}" class = "container" ><h3>${pregunta.nombre}</h3> <BR> 
			
			<c:forEach items= "${pregunta.respuestas}" var="respuesta" >	
		  		<input type="checkbox"  name="RespuestadelExamen" value="${respuesta.id}"  onclick="validacion('${pregunta.id}',this)" >${respuesta.nombre} <BR>			       	    
			</c:forEach> 	
		</div>	 
	 
	</c:forEach> 
	<br>
<input type="submit" class="btn btn-lg btn-danger btn-block" value="Enviar"/>

</form:form></div>
	 <div class="col-md-4"></div></div>		
				<!-- Footer -->	     

	                <div class="footer">
	                    <center><p>Copyright &copy; Proyecto Colmena 2018</p></center>
	                </div> 	
				
	
	
	</body>


</html>