package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.Examen.ServicioExamen;
import ar.edu.unlam.tallerweb1.servicios.Login.*;



import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;


import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;



public class TestLogin extends SpringTest{
     
    Usuario usuario;
    
/*TEST LOGIN*/

   @Test
    @Transactional @Rollback(false)
    public void LoginUsuarioDocente()  
    {   
	   Usuario usuarioMock = mock(Usuario.class);
	   Usuario usuarioMockDOCENTE = mock(Usuario.class);
	   ServicioLogin serviciologinmock =  mock(ServicioLogin.class);
	   
	   when (usuarioMockDOCENTE.getPassword()).thenReturn("1234");
	   when (usuarioMockDOCENTE.getEmail()).thenReturn("docente@doc"); 
	   when (usuarioMockDOCENTE.getRol()).thenReturn("docente");
	   
	 when (serviciologinmock.consultarUsuario(usuarioMock)).thenReturn(usuarioMockDOCENTE); 

	 assertThat (usuarioMockDOCENTE.getRol()).isEqualTo("docente");	

   	
          	    	    	      	         	
    }
    
   @Test
   @Transactional @Rollback(false)
   public void LoginUsuarioAlumno()  
   {   
	   Usuario usuarioMock = mock(Usuario.class);
	   Usuario usuarioMockAlumno = mock(Usuario.class);
	   ServicioLogin serviciologinmock =  mock(ServicioLogin.class);
	   
	   when (usuarioMockAlumno.getPassword()).thenReturn("alumno@alumno");
	   when (usuarioMockAlumno.getEmail()).thenReturn("1"); 
	   when (usuarioMockAlumno.getRol()).thenReturn("Alumno");
	   
	 when (serviciologinmock.consultarUsuario(usuarioMock)).thenReturn(usuarioMockAlumno); 

	 assertThat (usuarioMockAlumno.getRol()).isEqualTo("Alumno");	  	
         	    	    	      	         	
   }
   
   
   @Test
   @Transactional @Rollback(false)
   public void LoginUsuarioAdministrador()  
   {   
	   Usuario usuarioMock = mock(Usuario.class);
	   Usuario usuarioMockADMIN = mock(Usuario.class);
	   ServicioLogin serviciologinmock =  mock(ServicioLogin.class);
	   
	   when (usuarioMockADMIN.getPassword()).thenReturn("1234");
	   when (usuarioMockADMIN.getEmail()).thenReturn("admin@admin"); 
	   when (usuarioMockADMIN.getRol()).thenReturn("Admin");
	   
	 when (serviciologinmock.consultarUsuario(usuarioMock)).thenReturn(usuarioMockADMIN); 

	 assertThat (usuarioMockADMIN.getRol()).isEqualTo("Admin");	  	
         	    	    	      	         	
   }
   
/*TEST DOCENTE CONTROLLER*/ 
  
   @Test
   @Transactional @Rollback(false)
   public void ModificarExamenDocente()
   {
	   Examen examenMock = mock(Examen.class);
	   ServicioExamen servicioExamenMock = mock(ServicioExamen.class);
	   
	   
	   when (examenMock.getId()).thenReturn((long)1);
	     
	   when (servicioExamenMock.cargarExamen((long)1)).thenReturn(examenMock);
	   
	   assertThat (examenMock.getId()).isEqualTo((long)1);
	   
   }
   /*
   @Test
   @Transactional @Rollback(false)
   public void DesabilitarExamen()
   {
	   
	  Examen examenMock = mock(Examen.class); 
	  ServicioExamen servicioExamenMock = mock(ServicioExamen.class);
	  
	  when (examenMock.getId()).thenReturn((long)1);
	  when (examenMock.getNombre()).thenReturn("Matematicas");
	  when (examenMock.getFecha()).thenReturn("10/12/2017");
	  when (examenMock.getTipo()).thenReturn("1er Parcial");
	  when (examenMock.getEstado()).thenReturn("Habilitado");
	  when (examenMock.getHabilitado()).thenReturn(1);
	  when (examenMock.getUmbral()).thenReturn(70);
	  
	   
	  when (servicioExamenMock.cargarExamen((long)1)).thenReturn(examenMock);
	   
	   
	  when (servicioExamenMock.SetEstadoExamen(examenMock))
	   
	   assertThat()
	 
	  
   }
    */
   
}