
package ar.edu.unlam.tallerweb1.servicios.Examen;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Nota;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


public interface ServicioExamen {

	public ArrayList<Examen> cargarExamen();
	
	public Examen cargarExamen(long Idexamen);
	public Examen cargarExamenDinamico(long Idcurso);
	public ArrayList<Respuesta> corregirRta(String[] rta);
	public ArrayList<Pregunta> cargarPreguntaPorExamen(long Idexamen);	
	public float GetNotaExamen(ArrayList <Pregunta>  preguntas, long[] respuestas);
	public void GrabarNotaExamen(Nota nota);
	public long GrabarExamen(Examen examen);
	public boolean ExamenYaUtilizado(long Idexamen);
	public ArrayList <Examen> cargarExamenXCurso (long Idcurso);
	public void SetEstadoExamen(Examen examen);
	public ArrayList <Examen> getExamenPendientes(long idUsuario, long idCurso);
	public List <Examen> GetExamenPendiente (List <Examen> examenes,Usuario usuario);
	public List <Examen> GetExamenesRendidos (List <Examen> examenes,Usuario usuario);
	
	
}