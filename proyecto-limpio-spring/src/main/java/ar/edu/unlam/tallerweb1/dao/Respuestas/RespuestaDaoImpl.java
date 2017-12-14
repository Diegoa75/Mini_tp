package ar.edu.unlam.tallerweb1.dao.Respuestas;


import java.util.ArrayList;

import javax.inject.Inject;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;



@Repository("RespuestaDao")
public class RespuestaDaoImpl implements RespuestaDao{

	@Inject
 	private SessionFactory sessionFactory;	

	@Transactional
	public void grabarRespuesta(Respuesta Respuesta){	
		Session s = sessionFactory.openSession();
		s.save(Respuesta);		
		
	}
	
	@SuppressWarnings("unchecked")
	public Respuesta nomRespuesta(long idRta)
	{		
		final Session session = sessionFactory.getCurrentSession();
		
		return (Respuesta) session.createCriteria(Respuesta.class)
				.add(Restrictions.eq("id",idRta))
				.uniqueResult();
	}
	
	@Override
	public boolean borrarRespuesta(Respuesta  respuesta){
		boolean Borro=false;
		final Session session = sessionFactory.getCurrentSession();
							
		try
		{
			session.delete(respuesta);
			Borro=true;
		}
		catch(org.hibernate.exception.ConstraintViolationException ex){
			Borro=false;
			
		}
				
		return Borro;
	
	}
	
	@Override
	public ArrayList<Respuesta> getRespuestas(long idPregunta){
		
		final Session session = sessionFactory.getCurrentSession();
		
		return (ArrayList<Respuesta>) session.createCriteria(Respuesta.class)    			
    			.createAlias("pregunta", "pre")
    			 .setFetchMode("pregunta", FetchMode.JOIN) 
    			.add(Restrictions.eq("pre.id", idPregunta))    	   			
    			.list();    
	
	}

}