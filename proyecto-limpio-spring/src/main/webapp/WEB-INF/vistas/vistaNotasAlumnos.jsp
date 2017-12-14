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
   <div class="col-md-11"> <center><h2>Listado de Examenes del curso ${Curso.nombre}</h2></center></div>  
    <div class="col-md-1"> 
      <a href="/proyecto-limpio-spring/irHomeusuario" class="btn btn-large btn-block btn-info">Inicio</a>
    <a href="/proyecto-limpio-spring/exit" class="btn btn-large btn-block btn-danger">Salir</a>
 </div> 
</div>
</header>

<br>
<br>

<div class="contenedor">

<form:form method="GET" modelAttribute="Curso" > 
	    
          
          <table class="table table-hover">
              <thead>
                <tr>
                	<c:if test="${empty Curso.usuarios}">	  
                		 <th><h3>No hay alumnos inscriptos</h3></th>  
                		     
    				</c:if>
    				<c:if test="${not empty Curso.usuarios}">	
    					<th><h3>Nombre </h3></th> 
    					<th><h3>Apellido</h3></th>  
                		 <th><h3>Tipo examen</h3></th>
                		<th><h3>Nota</h3></th>
                		<th></th>
                		<th></th>
    				</c:if>                   
                                    
                </tr>
              </thead>
                     
               <tbody>
               <c:forEach items= "${Curso.usuarios}" var="usuarios">
             
	              <c:forEach items= "${Curso.examen}" var="examen">  
	               <c:forEach items= "${examen.nota}" var="nota">
	                             
	                <tr>
	                		<td><h4>${usuarios.nombre}</h4></td>
	                	 <td><h4>${usuarios.apellido}</h4></td>	              
	                  <td><h4>${examen.tipo}</h4></td>	
	                  
	                   <td><h4>${nota.calificacion}</h4></td>
	                        
	                </tr> 
	              </c:forEach>  
	               </c:forEach> 
	               </c:forEach>             
              </tbody> 
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