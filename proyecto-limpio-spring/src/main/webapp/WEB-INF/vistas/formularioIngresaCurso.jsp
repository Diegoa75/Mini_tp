<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <!--   <div class="col-md-11"> <h2>${Usuario} </h2></div>  <center><a href="/proyecto-limpio-spring/exit"  class="btn btn-info btn-lg active" role="button">Salir</a></center>-->
    <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>
</header>
<br><br>
<form:form action="guardarCurso" method="POST" modelAttribute="Materia">


<br>
	<div class="col-md-4"></div>
		<div class="col-md-4">
	<div class="panel panel-primary"><div class="panel-heading">Ingresar curso</div>
	<br><br>
	<div class="col-xs-12">
	<label class="control-label" for="nombreCurso">Nombre del curso</label>
	<form:input path="nombre" id="nombreCurso" placeholder="Nombre Curso" class="form-control"/>
	
	<label class="control-label" for="maximoAlumnos">Maximo de Alumnos Permitidos</label>
	<form:input path="maximoAlumnos" id="maximoAlumnos" placeholder="Alumnos Permitidos" class="form-control"/>
	
	</div><br><br><br><br>
	<input type="submit" class="btn btn-lg btn-danger btn-block" role="button" value="Guardar"/>
	</div>
	</div>
	<div class="col-md-4"></div>
</form:form>
</body>
</html> 