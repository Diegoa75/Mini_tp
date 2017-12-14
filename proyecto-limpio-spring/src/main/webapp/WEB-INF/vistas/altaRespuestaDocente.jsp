<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
   <div class="col-md-11"> <center><h2>Carga de respuestas ${usuario.nombre} ${usuario.apellido}</h2></center></div>  
    <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>
</header>


<div class="contenedor">

<form:form action="../../altaRespuestaDocenteok" method="POST" modelAttribute="respuesta"> 

<center><h1><span class="label label-info">Examen: ${examen.nombre}</span></h1></center>
<center><h1><span class="label label-info">Pregunta: ${pregunta.nombre} </span></h1></center>



 <div class="form-group">
 
	<input type="hidden" name="idExamen" value="${examen.id}"/>
	 <input type="hidden" name="idPregunta" value="${pregunta.id}"/> 

<br>
	<form:input path="nombre" id="nombre" class="form-control" placeholder="Ingrese la nueva Respuesta"  />
<br>
 
  <label for="checkCorrecta">La respuesta ingresada es la Correcta?</label>
 <select class="btn" id="checkCorrecta" name="checkCorrecta">
   <option value="1">Correcta</option>
   <option value="0">Incorrecta</option>
 
</select>
							
	
<br>
<br>
<br>
<br>
<br>
<br>
<br>
	<center><input class="btn btn-primary"  type="submit" value="Guardar Nueva Respuesta"/></center>
 </div>	   
</form:form>
 
<br>
<br>

<br>
<br>

</div>



<!-- Footer -->	     

	                <div class="footer">
	                    <center><p><h6>Copyright &copy; Proyecto Colmena 2018</h6></p></center>
	                </div>
	
</body>
</html>