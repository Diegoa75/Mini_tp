<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
   <div class="col-md-11"> <h4>${usuario.nombre} ${usuario.apellido}</h4></div> 
    <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>

</header>
<br><br><br>
		<div class="col-md-4"></div>
		<div class="col-md-4">
		
			<div class="panel panel-primary"><div class="panel-heading">Seleccione una opción</div><br><br>
			
			
			<div><a href="ingresarCurso"  class="btn btn-lg btn-danger btn-block" role="button">Crear curso</a></div><br>
			
			<!--  <div><a href=""  class="btn btn-danger btn-sm active" role="button">Ver cursos</a></div><br>-->
			
			<div><a href="ingresarDocente"  class="btn btn-lg btn-danger btn-block" role="button">Ingresar docente</a></div><br>
			
			
			</div>
			
			
			
			
			
		</div>
		<div class="col-md-4"></div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>