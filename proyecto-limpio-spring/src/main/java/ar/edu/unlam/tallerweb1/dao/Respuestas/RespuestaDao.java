package ar.edu.unlam.tallerweb1.dao.Respuestas;


import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Respuesta;


public interface RespuestaDao {
	
	public void grabarRespuesta(Respuesta Respuesta);	
	public Respuesta nomRespuesta(long idRta);
	public boolean borrarRespuesta(Respuesta  respuesta);
	public ArrayList<Respuesta> getRespuestas(long idPregunta);
}