package ar.edu.unlam.tallerweb1.dao.Preguntas;


import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.modelo.Pregunta;



@Repository("PreguntaDao")
public class PreguntaDaoImpl implements PreguntaDao{

	@Inject
 	private SessionFactory sessionFactory;	

	@Transactional
	public void grabarPregunta(Pregunta Pregunta){	
		Session s = sessionFactory.openSession();
		s.save(Pregunta);		
		
	}

}