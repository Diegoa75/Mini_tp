package ar.edu.unlam.tallerweb1.servicios.Examen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.Examen.ExamenDao;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Nota;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("ServicioExamen")
@Transactional
public class ServicioExamenImpl implements ServicioExamen{

	@Inject
	private ExamenDao examendao;
	
	
	public ArrayList<Examen> cargarExamen(){
		return examendao.cargarExamen();
	}
		
	public Examen cargarExamen(long Idexamen){
		return examendao.cargarExamen(Idexamen);
	}
		
	public Examen cargarExamenDinamico(long Idcurso){
		return examendao.cargarExamen(Idcurso);
	}

	@Transactional
	public ArrayList<Respuesta> corregirRta(String[] rta){
		return examendao.corregirRta(rta);
	}
	
	public ArrayList<Pregunta> cargarPreguntaPorExamen(long Idexamen){
		return examendao.cargarPreguntaPorExamen(Idexamen);		
	}
	
	public float GetNotaExamen(ArrayList <Pregunta>  preguntas, long[] respuestas){
		 List<Respuesta>  respuesta;
		 float aciertos=0;
		 float CantPreguntas =0;
		 float nota=0;
		 
		 CantPreguntas = preguntas.size();
		 
		for (int i=0; i< preguntas.size();i++){
			
			respuesta = preguntas.get(i).getRespuestas();
											
			for (int j=0; j< respuesta.size();j++){
				
				for (int z=0; z< respuestas.length;z++){
					
					if (respuesta.get(j).getId()==(long) respuestas[z] ){
						
						if (respuesta.get(j).getCorrecta()){
							aciertos++;
						}								
					}							
				}
			}		
		}
		
		nota= (aciertos/CantPreguntas)*100;			
		
		return (float) nota;
	}
	
	@Transactional
	public void GrabarNotaExamen(Nota nota){		
		examendao.GrabarNotaExamen(nota);	
	}
	
	@Transactional
	public long GrabarExamen(Examen examen){
		return examendao.GrabarExamen(examen);
	}
	
	public boolean ExamenYaUtilizado(long Idexamen){
	
		Boolean respuesta;
		
		ArrayList <Nota> notas  = new ArrayList <Nota>();
		
		if(examendao.getNotas(Idexamen).size()==0)
		{respuesta=false;		
		}else
		{respuesta=true;}
				
	return respuesta;
		
	}
	
	public ArrayList <Examen> cargarExamenXCurso (long Idcurso){
		
		return examendao.cargarExamenXCurso(Idcurso);
		
	}
	
	@Transactional
	public void SetEstadoExamen(Examen examen){
				
		examendao.SetEstadoExamen(examen);
	}
	
	public List <Examen> GetExamenPendiente (List <Examen> examenes, Usuario usuario){
		List <Examen> auxEx = new ArrayList <Examen>();
		List <Nota> notas = usuario.getNotas();
		boolean rindio = false;
		
		for (int i=0; i< examenes.size();i++){					
			rindio = false;
			
					for (int j=0; j< notas.size();j++){						
						if (examenes.get(i).getId() == notas.get(j).getExamen().getId())
						{
								rindio = true;							
						}
					}
					
					if(rindio==false)
					{
						auxEx.add(examenes.get(i));
					}		
		}
		
		return auxEx;
		
	}
	
	
	
	public List <Examen> GetExamenesRendidos (List <Examen> examenes, Usuario usuario){
		List <Examen> auxEx = new ArrayList <Examen>();
		List <Nota> notas = usuario.getNotas();
		boolean rindio = false;
		
		for (int i=0; i< examenes.size();i++){					
			rindio = false;
			
					for (int j=0; j< notas.size();j++){						
						if (examenes.get(i).getId() == notas.get(j).getExamen().getId())
						{
								rindio = true;							
						}
					}
					
					if(rindio==true)
					{
						auxEx.add(examenes.get(i));
					}		
		}
		
		return auxEx;
		
	}
	
	public ArrayList <Examen> getExamenPendientes(long idUsuario, long idCurso){
		return examendao.getExamenPendientes(idUsuario, idCurso);
	}
	
}