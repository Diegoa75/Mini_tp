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
<body>

<header class="panel-primary">
<div class="container-fluid panel-heading">
  <h1><center><img src="${pageContext.request.contextPath}/img/Logo.jpg"/></center></h1>
   <div class="col-md-11"> <center><h2>Cargue el Exámen Profesor ${usuario.nombre} ${usuario.apellido}</h2></center></div>  
    <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>
</header>

<br>
<br>

<div class="contenedor">
             

<form:form method="GET" modelAttribute="examen" > 

	 <center><h3>Preguntas Cargadas del Examen: ${examen.nombre}</h3></center>
				
		 <table class="table table-hover">
			 <thead>
			    <tr>
			      <th><h3>Preguntas</h3></th>
			       <th> <a class="btn btn-success" href="<c:url value='/CargarPreguntaDocente/${examen.id}'/>" role="button">Cargar Pregunta</a></th>
                  <th> </th>			      
			    </tr>
			  </thead>	
			  				
			<c:forEach items= "${examen.preguntas}" var="pregunta">
			 <tr> 
			 <td>	
			 <form:label path="nombre" id="id">${pregunta.nombre}</form:label>
			 </td> 			 
			 <td>	
					<table class="table">
						<thead>				
					    <tr>			     
					      <th>Respuestas</th>
					      <th>Es Correcta</th>
					      <th><a class="btn btn-success" href="<c:url value='/guardarRespuestaDocente/${examen.id}/${pregunta.id}'/>"  role="button">Cargar Respuesta</a></th>
					    </tr>
					   </thead>						
							 <c:forEach  items="${pregunta.respuestas}" var="respuestas"> 
							  <tr>
						  		<td>		    
						     	 	<label>${respuestas.nombre}</label> 
						     	</td>
						     	<td>
							     	<c:if test="${respuestas.correcta}" >
							     		<p class="text-success">Respuesta Correcta</p>			     	
							     	 </c:if>
						     	 </td>
						     	 <td>
						     	 
					   				<a class="btn btn-danger" href="<c:url value='/borrarRespuestaDocente/${examen.id}/${pregunta.id}/${respuestas.id}'/>" role="button">Borrar Respuesta</a>
						     	 </td>
						      </tr>
					    	</c:forEach>								
					</table>				
			</td>
				  
			<td> 				  
                   	<a class="btn btn-danger" href="<c:url value='/borrarPreguntaDocente/${examen.id}/${pregunta.id}'/>" role="button">Borrar Pregunta</a>					   
			</td>
			   			  
			  </tr>
			    			 				       	    
			</c:forEach> 	
		</table>
		
		
	    
</form:form>

</div>
  
 <c:if test="${not empty mensageErr}">
			       ${mensageErr}			        
</c:if>	

<!-- Footer -->	     

	                <div class="footer">
	                    <center><p><h6>Copyright &copy; Proyecto Colmena 2018</h6></p></center>
	                </div>
</body>
</html>