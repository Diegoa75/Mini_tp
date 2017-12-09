<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
		<head>
		<link href="../css/bootstrap.min.css" rel="stylesheet" >
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    
	    <!-- Bootstrap theme -->
	    <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="../css/estilos.css" rel="stylesheet">
	    	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>		 
	    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/funciones.js"></script>    	  		
	</head>
<body>

<header class="panel-primary">
<div class="container-fluid panel-heading">
  <h1><center><img src="../img/Logo.jpg"/></center></h1>
   <div class="col-md-11"> <center><h2>Alta de preguntas: ${Examen.nombre}</h2></center></div>  <div class="col-md-1"><a href="/proyecto-limpio-spring/exit"  class="btn btn-info btn-lg active" role="button">Salir</a></div>
</div>
</header>

<div class="contenedor">

<form:form action="guardarPregunta" method="POST" modelAttribute="Pregunta"> 

<center><h1><span class="label label-info">Examen: ${Examen.nombre}</span></h1></center>

 <div class="form-group">
 
	<input type="hidden" name="IdExamen" value="${Examen.id}"/>	

<br>
	<form:input path="nombre" id="nombre" class="form-control" placeholder="Ingrese la nueva Pregunta"  />
<br>
 	
<br>
<br>
<br>
<br>
<br>
<br>
<br>
	<center><input type="submit" value="Guardar Nueva Pregunta" class="btn btn-success"/></center>
 </div>	   
</form:form>
<br>
<br>

</div>	 





<!-- Footer -->	     

	                <div class="footer">
	                    <center><p><h6>Copyright &copy; Proyecto Colmena 2018</h6></p></center>
	                </div>
</body>
</html>