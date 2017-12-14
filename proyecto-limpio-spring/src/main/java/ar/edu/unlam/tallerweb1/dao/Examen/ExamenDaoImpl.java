package ar.edu.unlam.tallerweb1.dao.Examen;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Nota;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import javax.inject.Inject;

@Repository("ExamenDao")
public class ExamenDaoImpl implements ExamenDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Examen> cargarExamen() {

		@SuppressWarnings("unused")
		ArrayList <Examen> examen = new ArrayList <Examen>();
		final Session session = sessionFactory.getCurrentSession();
		return (ArrayList<Examen>) session.createCriteria(Examen.class)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Nota> getNotas(long Idexamen){
		final Session session = sessionFactory.getCurrentSession();
		return (ArrayList<Nota>) session.createCriteria(Nota.class)
				.createAlias("examen", "exa")   
   			 .setFetchMode("examen", FetchMode.SELECT)
				.add (Restrictions.eq("exa.id",Idexamen))
				.list();			
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Examen cargarExamen(long Idexamen){
		
		@SuppressWarnings("unused")	
		Examen ex;
		
		final Session session = sessionFactory.getCurrentSession();
		
		ex=  (Examen) session.createCriteria(Examen.class)
				.add (Restrictions.eq("id",Idexamen))
    			.uniqueResult();				
		return ex;
		}
	
	@SuppressWarnings("unchecked")
 	@Override
	public Examen cargarExamenDinamico(long idCurso){

 		
 		@SuppressWarnings("unused")	
 		Examen ex;
 		
 		final Session session = sessionFactory.getCurrentSession();
 		
 		ex=  (Examen) session.createCriteria(Examen.class)
				.createAlias("curso", "miCurso")
				.add (Restrictions.eq("miCurso.id",idCurso))
     			.uniqueResult();				
		
 		return ex;
	}
	
		
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Respuesta> corregirRta(String[] rta){
		
		@SuppressWarnings("unused")		
		
		final Session session = sessionFactory.getCurrentSession();
		
		return (ArrayList<Respuesta>) session.createCriteria(Respuesta.class)
				.add (Restrictions.eq("nombre",rta))
    			.list();				
			
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	 public ArrayList<Pregunta>  cargarPreguntaPorExamen(long Idexamen){
		
		@SuppressWarnings("unused")	
		ArrayList <Pregunta> pr;
		
		final Session session = sessionFactory.getCurrentSession();
		
		pr= (ArrayList<Pregunta>) session.createCriteria(Pregunta.class)
				.add (Restrictions.eq("examen.id",Idexamen))
    			.list();				
		
		return pr;	 
		 
	 }
	

	@Override	
	public void GrabarNotaExamen (Nota nota){
	
		final Session session = sessionFactory.getCurrentSession();
		session.save(nota);  		
	}
	
	 public long GrabarExamen(Examen examen){
		 
		 final Session session = sessionFactory.getCurrentSession();
			session.save(examen); 			
			return examen.getId();		 
	 }
	 
		@SuppressWarnings("unchecked")
		@Override
	public  ArrayList <Examen> cargarExamenXCurso(long Idcurso){
	
		@SuppressWarnings("unused")	
		ArrayList <Examen> ex;
		
		final Session session = sessionFactory.getCurrentSession();
		
		ex= (ArrayList<Examen>) session.createCriteria(Examen.class)
				.add (Restrictions.eq("idCurso",Idcurso))
    			.list();				
		return ex;
	}
	
	public void   SetEstadoExamen(Examen examen){
				
		final Session session = sessionFactory.getCurrentSession();
		
		session.update(examen);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList <Examen> getExamenPendientes(long idUsuario, long idCurso){
		ArrayList <Examen> ex;
		
		final Session session = sessionFactory.getCurrentSession();
		
		ex=  (ArrayList <Examen>) session.createCriteria(Examen.class) 				
    			.createAlias("curso", "cur")   
    			 .setFetchMode("curso", FetchMode.SELECT)
    			 .createAlias("nota", "nota")    
    			 .setFetchMode("nota", FetchMode.SELECT)
    			 .createAlias("nota.usuario", "usuario") 
    			 .setFetchMode("nota.usuario", FetchMode.SELECT)
    			 .add(Restrictions.not( Restrictions.in("usuario.id",(long) idUsuario) ))  
    			 .add(Restrictions.eq("cur.id", idCurso)) 
    			 .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
    			 .list();
		
		// .add(Restrictions.ne("usuario.id",(long) idUsuario))
		
		return ex;
	
	
	}
}


