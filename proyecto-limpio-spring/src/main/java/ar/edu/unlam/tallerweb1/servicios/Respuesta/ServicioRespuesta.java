package ar.edu.unlam.tallerweb1.servicios.Respuesta;


import ar.edu.unlam.tallerweb1.modelo.Respuesta;

public interface ServicioRespuesta {

	public void grabarRespuesta(Respuesta Respuesta);
	public Respuesta nomRespuesta(long idRta);
	public boolean borrarRespuesta( long IdRespuesta);
	public boolean validarRespuesta(long idPregunta);
	
}