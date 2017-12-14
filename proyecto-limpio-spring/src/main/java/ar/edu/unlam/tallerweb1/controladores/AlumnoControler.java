package ar.edu.unlam.tallerweb1.controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.DateUtil;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Nota;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Alumno.ServicioAlumno;
import ar.edu.unlam.tallerweb1.servicios.Curso.ServicioCurso;
import ar.edu.unlam.tallerweb1.servicios.Examen.ServicioExamen;
import ar.edu.unlam.tallerweb1.servicios.Respuesta.ServicioRespuesta;
import ar.edu.unlam.tallerweb1.servicios.Usuario.ServicioUsuario;

@Controller
public class AlumnoControler {
	@Inject
	private ServicioUsuario serviciousuario;	
	@Inject
	private ServicioCurso servicioCurso;	
	@Inject
	private ServicioAlumno servicioAlumno;
	
	@Inject
	private ServicioExamen servicioExamen;
	
	@Inject
	private ServicioRespuesta servicioRespuesta;
	
	
	@RequestMapping(value="/IrAccionAlumno", method= RequestMethod.POST)	
	public ModelAndView homeAlumno(@RequestParam("IdCurso")long idCurso, @RequestParam("idAlumno")long idAlumno, @RequestParam("btnAction")String accion){
		ModelMap model = new ModelMap();	
		Curso curso = new Curso();	
		Usuario usuario = new Usuario();
		
		curso = servicioCurso.GetCurso(idCurso);
		usuario = serviciousuario.UsuarioporId(idAlumno);
				
		Examen examen = new Examen();	
		String vista="";
		
		switch (accion){
		case "Ver Examenes Pendientes": 
			
			curso.setExamen(servicioExamen.GetExamenPendiente ( curso.getExamen(),usuario));		
			model.put("Alumno", usuario);
			model.put("Curso", curso);			
			vista="listaExamenAlumno";				
			break;
		case "Ver Notas": 
			curso.setExamen( servicioExamen.GetExamenesRendidos( curso.getExamen(),usuario));
			model.put("Curso", curso);	
			model.put("Examen", examen);			
			vista="listaNotaAlumno";				
			break;					
		case "Inscribirse a un Curso": 
			ArrayList <Curso> cursos = servicioCurso.cursosParaAnotarse();
			model.put("Cursos", cursos);			
			model.put("Alumno", usuario);
			vista="InscripcionAlumnoCurso";
		}	
		
		return new ModelAndView(vista, model);		
	}
	
			
	
 @RequestMapping("/InscribirseCursoAlumno/{idAlumno}/{idCurso}")
 public ModelAndView InscribirCursoAlumno(@PathVariable long idAlumno,@PathVariable long idCurso)
 {
 		ModelMap model = new ModelMap();
 		
		
 		Curso curso = new Curso();
		curso = servicioCurso.GetCurso(idCurso);
		int canti= curso.getCantidadAlumnos();
		curso.setCantidadAlumnos(++canti);
				
		Usuario alumno = new Usuario();
		alumno = serviciousuario.UsuarioporId(idAlumno);		
		
		Collection<Curso>cursos = new ArrayList<Curso>();
		cursos = alumno.getCursos();
		
		cursos.add(curso);
		alumno.setCursos(cursos);
			
		servicioAlumno.anotarAlumno(alumno);		
		 
		alumno = serviciousuario.UsuarioporId(idAlumno);
		cursos = servicioCurso.cursosParaAnotarse();
		
		model.put("Cursos", cursos);			
		model.put("Alumno", alumno);
		 
 		return new ModelAndView("InscripcionAlumnoCurso",model);
	} 
 
 
	@RequestMapping("/ingresarAlumno")
	public ModelAndView ingresarAlumno()
	{
		ModelMap modelo = new ModelMap();
		Usuario alumno = new Usuario();
		modelo.put("Alumno", alumno);	
		return new ModelAndView("formularioIngresaAlumno", modelo);
	}
 
	@Inject
 	private SessionFactory sessionFactory;
	@RequestMapping(value="/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute ("Alumno") Usuario alumno)
	{	ModelMap model = new ModelMap();
		    alumno.setRol("alumno");		
		    serviciousuario.grabarUsuario(alumno);	
		    
		    model.put("error", "Usuario creado con exito");
		    
			return new ModelAndView("redirect:/login",model);
	}
	

	
	 @RequestMapping("/rendirExamenAlumno/{idExamen}")
	 public ModelAndView rendirExamenAlumno(@PathVariable long idExamen)
	 {
		 Examen examen = new Examen();	
			ModelMap model= new ModelMap();					
			//pido el examen con ID 1
			examen= servicioExamen.cargarExamen((long)idExamen);
			model.put("Examen", examen);
			model.put("Nombre", "pepe");
			model.put("Apellido", "santo");
			return new ModelAndView("homeExamen",model);
		 	 		
		} 
	 
	 @RequestMapping(path ="/rendirExamenAlumno/corregir-examen", method=RequestMethod.POST)
		public ModelAndView CorregirExamen(@RequestParam("RespuestadelExamen")long[] checkboxValue, @RequestParam("IdExamen")long idExamen, HttpServletRequest request
				,@RequestParam("nombre")String nombre ,@RequestParam("apellido")String apellido)
		{		
			 ModelMap model = new ModelMap();
			 ArrayList <Pregunta> preguntas;
			 ArrayList <Respuesta> respuestas = new ArrayList<Respuesta>();
			 Examen examen;
			 Nota nota=new Nota(); 
			 Respuesta nombreRta = new Respuesta();
			 Usuario usuario;
			 examen = servicioExamen.cargarExamen(idExamen);
			 preguntas= servicioExamen.cargarPreguntaPorExamen(idExamen);
			 
			 nota.setCalificacion( servicioExamen.GetNotaExamen(preguntas, checkboxValue));			 
			 nota.setFecha(new SimpleDateFormat("dd-MM-yyyy").format( DateUtil.now()));
			 nota.setExamen(examen);
					 
			 usuario= serviciousuario.UsuarioporId((long) request.getSession().getAttribute("idUsuario"));		
			 
			 nota.setUsuario(usuario);
			 
			 servicioExamen.GrabarNotaExamen(nota);
			 			 		
			model.put("examen",examen);	 
			model.put("nota",nota.getCalificacion());
			
			//hacer un array que metraiga los nombres y pasarlo al modelo
			for(int i=0;i<checkboxValue.length;i++) 
		    {
			nombreRta = servicioRespuesta.nomRespuesta(checkboxValue[i]);
			respuestas.add(nombreRta);
		    }
			model.put("Nombre", nombre);
			model.put("Apellido", apellido);
			//model.put("examen", respuestas);
			model.put("Mis_respuestas", respuestas);
			
			return new ModelAndView("Resultado", model);
		}

	

}



	
