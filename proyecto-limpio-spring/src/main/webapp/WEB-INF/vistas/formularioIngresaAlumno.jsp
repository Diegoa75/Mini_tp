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
   <div class="col-md-11"> <center><h2>${usuario.nombre} ${usuario.apellido}</h2></center></div>  
    <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>
</header><br><br>
<div class="col-md-4"></div>
<div class="col-md-4">
<div class="panel panel-primary"><div class="panel-heading"><center>Ingresa tus datos</center></div>

<form:form action="guardarAlumno" method="POST" modelAttribute="Alumno"> 
	<br><br>
	<div class="col-xs-12">
	<form:input path="nombre" placeholder="Nombre" class="form-control"/>
	</div><br><br><br><br>
	<div class="col-xs-12">
	<form:input path="apellido" placeholder="Apellido" class="form-control"/>
	</div><br><br><br><br>
	<div class="col-xs-12">
	<form:input path="email" placeholder="Mail" class="form-control"/>
	</div><br><br><br><br>	
	<div class="col-xs-12">
	<form:input path="password" placeholder="Contraseña" class="form-control"/>
	</div><br><br><br><br>	
	<br>
	<button class="btn btn-lg btn-danger btn-block" Type="Submit">Guardar</button>
	</form:form>
	</div>
<br>

</div>
<div class="col-md-4"></div>
</body>
</html> 