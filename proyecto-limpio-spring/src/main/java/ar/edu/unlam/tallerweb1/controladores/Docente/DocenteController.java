package ar.edu.unlam.tallerweb1.controladores.Docente;

import java.util.ArrayList;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Nota;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.servicios.Curso.ServicioCurso;
import ar.edu.unlam.tallerweb1.servicios.Examen.ServicioExamen;
import ar.edu.unlam.tallerweb1.servicios.Preguntas.ServicioPregunta;
import ar.edu.unlam.tallerweb1.servicios.Respuesta.ServicioRespuesta;


@Controller	
public class DocenteController{
			
	@Inject ServicioCurso serviciocurso;
	@Inject ServicioExamen servicioexamen;
	@Inject ServicioPregunta serviciopregunta;
	@Inject ServicioRespuesta servicioRespuesta;
	
	@RequestMapping(value="/IrAccion", method= RequestMethod.POST)	
	public ModelAndView altaExamen(@RequestParam("IdCurso")long idCurso, @RequestParam("btnAction")String accion){
		ModelMap model = new ModelMap();	
		Curso curso = new Curso();
		Nota nota = new Nota();
		curso = serviciocurso.GetCurso(idCurso);
		Examen examen = new Examen();	
		String vista="";
		
		switch (accion){
		case "Ver Examenes": 	
			model.put("Curso", curso);			
			vista="listaExamen";									
			break;
		case "Alta Examen": 
			model.put("Curso", curso);	
			model.put("Examen", examen);			
			vista="altaExamenDocente";				
			break;					
		case "Ver Alumnos": 
			model.put("Curso", curso);						
			vista="vistaAlumnoCurso";
			
		case	"Ver Notas":
			model.put("Curso", curso);
			
			vista="vistaNotasAlumnos";
		}	
		
		return new ModelAndView(vista, model);		
	}
	
			
	@RequestMapping(value="/ModificarExamenDocente/{idExamen}", method=RequestMethod.GET)
	public ModelAndView ModificarExamenDocente(@PathVariable long idExamen){
		ModelMap model = new ModelMap();
		Examen examen = new Examen();
		Pregunta pregunta = new Pregunta();
					
		/*traigo el examen de la base por id*/			
		examen= servicioexamen.cargarExamen((long)idExamen);			
		model.addAttribute("examen", examen);				
				
		return new ModelAndView("abmExamen",model);
	}
	
	@RequestMapping(value="/DesabilitarExamenDocente/{idExamen}", method=RequestMethod.GET)
	public ModelAndView DesabilitarExamen(@PathVariable long idExamen){
		
		ModelMap model = new ModelMap();
		Examen examen = new Examen();	
		examen= servicioexamen.cargarExamen((long)idExamen);
		
		examen.setHabilitado(1);			
		servicioexamen.SetEstadoExamen(examen);	
						
		model.addAttribute("Curso", examen.getCurso());						
		return new ModelAndView("listaExamen",model);
	
	}
	
	@RequestMapping(value="/HabilitarExamenDocente/{idExamen}", method=RequestMethod.GET)
	public ModelAndView HabilitarExamen(@PathVariable long idExamen){
		
		ModelMap model = new ModelMap();
		Examen examen = new Examen();	
		examen= servicioexamen.cargarExamen((long)idExamen);
			
		examen.setHabilitado(0);			
		servicioexamen.SetEstadoExamen(examen);					
							
		model.addAttribute("Curso", examen.getCurso());	
					
		return new ModelAndView("listaExamen",model);
	
	}
	
	
	/*ALTA EXAMEN*/
	@RequestMapping(value="/guardarExamen", method= RequestMethod.POST)	
	public ModelAndView GuardarExamenDocente(@RequestParam("IdCurso")long idCurso, @ModelAttribute("Examen") Examen examen){
		
		Pregunta pregunta = new Pregunta();
		
		ModelMap modelExamen = new ModelMap();
		Curso curso = new Curso();
		curso = serviciocurso.GetCurso(idCurso);
		
		examen.setCurso(curso);
		examen.setHabilitado(1);//por defecto se crea deshabilitado
							
		servicioexamen.GrabarExamen(examen);		
				
		curso = serviciocurso.GetCurso(idCurso);
							
		modelExamen.addAttribute("Curso", curso);	
		
		
		return new ModelAndView("listaExamen", modelExamen);			
		
	}
	
	//CargarPreguntaDocente
	@RequestMapping(value="/CargarPreguntaDocente/{idExamen}", method=RequestMethod.GET)
	public ModelAndView CargarPreguntaDocente(@PathVariable long idExamen){
		ModelMap model = new ModelMap();
		Examen examen = new Examen();
		Pregunta pregunta = new Pregunta();	
		
		examen= servicioexamen.cargarExamen((long)idExamen);	
						
		model.addAttribute("Pregunta", pregunta);	
		model.put("Examen", examen);
				
		return new ModelAndView("altaPreguntaDocente",model);
	}
	
	/*guardar Pregunta*/	
	@RequestMapping(value="/CargarPreguntaDocente/guardarPregunta", method=RequestMethod.POST)
	public ModelAndView altaPregunta(@RequestParam("IdExamen")long idExamen,@ModelAttribute("pregunta") Pregunta pregunta){
		ModelMap modelPregunta = new ModelMap();
		
		/*traigo el examen de la base por id*/
		Examen examen = new Examen();	
		examen= servicioexamen.cargarExamen((long)idExamen);
		/*relaciono el examen con la pregunta y la guardo */
		pregunta.setExamen(examen);		
		serviciopregunta.grabarPregunta(pregunta); 
		
		/*mando el examen para poder mostrar todas las preguntas del mismo con un for en la vista*/
		examen= servicioexamen.cargarExamen((long)idExamen);
		modelPregunta.put("examen", examen);	
		
		
		return new ModelAndView("abmExamen",modelPregunta);
	}
	
	/*Borrar Pregunta*/	
	@RequestMapping(value="/borrarPreguntaDocente/{idExamen}/{idPregunta}", method=RequestMethod.GET)
	public ModelAndView borrarPregunta(@PathVariable long idExamen, @PathVariable long idPregunta){
		Examen examen = new Examen();
		ModelMap model=new ModelMap();
				
		/*Valido si el examen ya fue rendido alguna vez*/		
		if (servicioexamen.ExamenYaUtilizado((long)idExamen)==true){
			model.put("mensageErr", "<script type='text/javascript'>alert('No se puede eliminar la respuesta por que el examen ya fue rendido por al menos un alumno');</script>");
		}
		else
		{	
			serviciopregunta.borrarPregunta(idPregunta);						
		}
				
		/*traigo el examen de la base por id*/			
		examen= servicioexamen.cargarExamen((long)idExamen);			
		model.addAttribute("examen", examen);
							
		return new ModelAndView("abmExamen",model);
	}
	
	
	/*ALTA RESPUESTA*/		
	@RequestMapping ("/guardarRespuestaDocente/{idExamen}/{idPregunta}")
	public ModelAndView guardarRespuestaDocente(@PathVariable long idExamen, @PathVariable long idPregunta){
			
	ModelMap ModelRespuesta = new ModelMap();
		
	Examen examen = servicioexamen.cargarExamen((long)idExamen); 
	Pregunta pregunta = serviciopregunta.cargarPregunta((long)idPregunta);
	Respuesta respuesta = new Respuesta();	
			
	ModelRespuesta.put("examen", examen);
	ModelRespuesta.put("pregunta", pregunta);
	ModelRespuesta.put("respuesta", respuesta);
	
	return new ModelAndView ("altaRespuestaDocente", ModelRespuesta);		
	}
	
		
	
	/*ALTA RESPUESTA*/		
	@RequestMapping(value="/altaRespuestaDocenteok", method=RequestMethod.POST)	
	public ModelAndView altRespuesta( @RequestParam("checkCorrecta")int checkCorrecta, @RequestParam long idExamen, @RequestParam long idPregunta,
			@ModelAttribute("respuesta") Respuesta respuesta)
	{
		ModelMap ModelRespuesta = new ModelMap();		
		Examen examen = new Examen();	
				
						
		/*traigo la pregunta de la base por id*/
		Pregunta pregunta = new Pregunta();
		pregunta= serviciopregunta.cargarPregunta((long) idPregunta);
		
		/*valido que solo exista una respuesta correcta*/
		if (servicioRespuesta.validarRespuesta((long) idPregunta) && (checkCorrecta==1)) {
			ModelRespuesta.put("mensageErr", "<script type='text/javascript'>alert('Solo puede existir 1 respuesta Correcta por pregunta');</script>");		
		}
		else
		{
			if (checkCorrecta==1)
				respuesta.setCorrecta(true);			
			else			
				respuesta.setCorrecta(false);
			
			/*relaciono la pregunta con la respuesta y la guardo */
			respuesta.setPregunta(pregunta);			
		    servicioRespuesta.grabarRespuesta(respuesta);			
		}
		
					    								
		examen= servicioexamen.cargarExamen((long)idExamen);				
		ModelRespuesta.put("examen", examen);				
		 				
		return new ModelAndView ("abmExamen", ModelRespuesta);
		
	}
	
	/*borrar respuesta*/
	///borrarRespuestaDocente/${examen.id}/${pregunta.id}/${respuestas.id}
	@RequestMapping(value="/borrarRespuestaDocente/{idExamen}/{idPregunta}/{idRespuesta}", method=RequestMethod.GET)
	public ModelAndView borrarRespuesta(@PathVariable long idExamen, @PathVariable long idPregunta, @PathVariable long idRespuesta){
		ModelMap model = new ModelMap();
		Examen examen = new Examen();
		
				
		/*Valido si el examen ya fue rendido alguna vez*/		
		if (servicioexamen.ExamenYaUtilizado((long)idExamen)==true){
			model.put("mensageErr", "<script type='text/javascript'>alert('No se puede eliminar la respuesta por que el examen ya fue rendido por al menos un alumno');</script>");
		}
		else
		{	
			servicioRespuesta.borrarRespuesta(idRespuesta);						
		}
				
		/*traigo el examen de la base por id*/			
		examen= servicioexamen.cargarExamen((long)idExamen);			
		model.addAttribute("examen", examen);
							
		return new ModelAndView("abmExamen",model);
	}
	
		  
}

		


