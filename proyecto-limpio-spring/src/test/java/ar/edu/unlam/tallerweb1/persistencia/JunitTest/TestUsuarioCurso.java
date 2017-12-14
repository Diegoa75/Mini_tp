package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class TestUsuarioCurso  extends SpringTest{

	 Examen examen;
	    Examen examen2;
		Pregunta pregunta;
		Respuesta respuesta;
		
				    
		
	    @Before
	    @Transactional @Rollback(false)
	    public void llenarDatos()  
	    {   	    		        	
	    	Collection<Curso> cursos = new ArrayList<Curso>(); 
	    	Curso curso = new Curso();
	    	curso.setNombre("Ingles");
	       	  		    		    	
	    	       	
	    	Usuario usuario = new Usuario();
	    	usuario.setEmail("1@1");
	    	usuario.setNombre("test");
	    	usuario.setRol("alumno");
	    	usuario.setPassword("1234");
	    	
	    	cursos.add(curso);
	    	
	    	usuario.setCursos(cursos);
	    	
	    	getSession().save(usuario);  
	    		    	
	    } 	
	   
	    
	   @Test
	    @Transactional @Rollback(false)
	    public void GetCursoUsuario()  
	    {   
			List <Usuario> usr;
			usr = getSession().createCriteria(Usuario.class)    			
	    			.createAlias("curso", "cur")
	    			 .setFetchMode("curso", FetchMode.JOIN) 
	    			.add(Restrictions.eq("cur.nombre", "Ingles"))    	   			
	    			.list();    	      
	    	 
	    	for (Usuario usuario : usr) {  
	    			    		
	    		for (Curso  curso : usuario.getCursos()) { 	    			
	    			 Assert.assertEquals(curso.getNombre(),"Ingles");	    			
	    		}
	    		      	
	    	}
		   
		   
	    }
	
}
