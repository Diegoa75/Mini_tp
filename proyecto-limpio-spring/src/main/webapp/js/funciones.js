
//VALIDACION Seleccion de Curso
function validacionCurso() {
   
  var idCurso = $('select[id=IdCurso]').val();
    
  var todoOk = false;
       
  if (idCurso == 0) {
      alert('Debe seleccionar un curso');      
  } else  {
	   todoOk = true;
  }
     
  return todoOk;
   
}

//VALIDACION CHECKBOX
function validacion(formu, obj) {
  limite=1; //limite de checks a seleccionar
  num=0;
    for (i=0;ele=document.getElementById(formu).children[i] ; i++)
    {   
    	if (ele.checked) 
    	num++;	    	
    }
  if (num>limite)
    obj.checked=false;  
}  

function deshabilitaRetroceso(){
    window.location.hash="no-back-button";
    window.location.hash="Again-No-back-button" //chrome
    window.onhashchange=function(){window.location.hash="no-back-button";}

$(document).ready(function() {
    $("#verExamen").click(function(event) {
    	
    	var todoOk = false;
   	 var idCurso = $('select[id=IdCurso]').val();
   	
	   	 todoOk = validacionCurso();
	   	 
	   if 	(todoOk==true)
	   	{ 		   
		   //$("#verExamen").attr('href',"\"<c:url value='/verExamenesDocente/'\" + idCurso + "/>");
	   	}
	
    	
        var href = $('#verExamen').attr('href');
        alert(href);        
        //event.preventDefault();
    });
})}