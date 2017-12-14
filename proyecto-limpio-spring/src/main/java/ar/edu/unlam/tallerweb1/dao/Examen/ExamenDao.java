package ar.edu.unlam.tallerweb1.dao.Examen;
import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Nota;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;

// Interface que define los metodos del DAO de Usuarios.
public interface ExamenDao {
	
	ArrayList<Examen> cargarExamen ();
	 Examen cargarExamen(long Idexamen);
	 public Examen cargarExamenDinamico(long idCurso);
	 ArrayList<Respuesta> corregirRta(String[] rta);
	 ArrayList<Pregunta>  cargarPreguntaPorExamen(long Idexamen);
	 public void GrabarNotaExamen (Nota nota);
	 public long GrabarExamen(Examen examen);
	 ArrayList<Nota>getNotas(long Idexamen);
	 ArrayList <Examen> cargarExamenXCurso(long Idcurso);
	 public void SetEstadoExamen(Examen examen);
	 public ArrayList <Examen> getExamenPendientes(long idUsuario, long idCurso);
}
	

