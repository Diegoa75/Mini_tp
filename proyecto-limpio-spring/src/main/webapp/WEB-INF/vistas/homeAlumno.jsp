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
   <div class="col-md-11"> <center><h2>Bienvenido Alumno ${usuario.nombre} ${usuario.apellido}</h2></center></div>  
    <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>
</header>

<br>
<center><h3>Por favor elija la accion a realizar  </h3></center>
<br>
<form:form action="IrAccionAlumno"  method="POST"> 
	 <input type="hidden" name="idAlumno" value="${usuario.id}">
	 		
		<select id="IdCurso" name="IdCurso" class="form-control">
		<option value="0" selected>(Cursos Inscriptos)</option>
		<c:forEach items= "${Materias}" var="curso" >
				<option value="${curso.id}">${curso.nombre}</option>	 
			</c:forEach> 
		</select> 
	
<br>
<br>

 <input type="submit" name="btnAction" value="Ver Examenes Pendientes" onclick="return validacionCurso();" class="btn btn-large btn-block btn-primary" />
    <br />   
    <input type="submit" name="btnAction" value="Ver Notas"  onclick="return validacionCurso();" class="btn btn-large btn-block btn-primary"/>
     <br />
    <input type="submit" name="btnAction" value="Inscribirse a un Curso"  class="btn btn-large btn-block btn-primary"/>

</form:form> 
<!-- Footer -->	     

	                <div class="footer">
	                    <center><p><h6>Copyright &copy; Proyecto Colmena 2018</h6></p></center>
	                </div> 
	</body>
</html>