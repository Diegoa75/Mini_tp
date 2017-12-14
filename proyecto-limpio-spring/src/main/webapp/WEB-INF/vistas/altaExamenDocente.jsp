<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->	 	    
	     <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
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

<h3>Nuevo Exámen</h3>
		
	
<form:form action="guardarExamen" method="POST" modelAttribute="Examen"> 

	<select id="IdCurso" name="IdCurso" class="form-control"  >
	<option value="${Curso.id}" selected>${Curso.nombre}</option>		
	</select> 	
	<br>		
	<form:input path="nombre" id="nombre"  class="form-control" placeholder="Nombre del Examen"  />
	<br>
	<form:input path="fecha" id="fecha" class="form-control"  placeholder="Fecha del Examen"/>
	<br>	
	<form:input path="tipo" id="tipo" class="form-control"  placeholder="Tipo de Examen"/>
	<br>
	<h5>Porcentaje de respuestas correctas:</h5>
	<form:input path="umbral" id="umbral" class="form-control" value="70"  />
	<br>
				
	<input class="btn btn-success" type="submit" value="Guardar Nuevo Exámen"/>
	
    
</form:form>

</div>

<!-- Footer -->	     

	                <div class="footer">
	                    <center><p><h6>Copyright &copy; Proyecto Colmena 2018</h6></p></center>
	                </div> 
</body>
</html>