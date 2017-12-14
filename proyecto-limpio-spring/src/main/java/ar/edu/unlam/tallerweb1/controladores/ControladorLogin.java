package ar.edu.unlam.tallerweb1.controladores;


import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Login.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.Curso.ServicioCurso;
import ar.edu.unlam.tallerweb1.servicios.Usuario.ServicioUsuario;


@Controller
public class ControladorLogin {
	
	 @Inject
		private ServicioLogin servicioLogin;
	 
	 @Inject
		private ServicioCurso servicioCurso;
	
	 @Inject
		private ServicioUsuario serviciousuario;	
	
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@Inject
	private ServicioCurso BuscarCursos;
	
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			
			request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
			
			if(("docente".equals(usuarioBuscado.getRol())))
			{
				ModelMap modelDocente = new ModelMap();
				
				ArrayList<Curso> cursos = new ArrayList<Curso>();		
				cursos =	servicioCurso.cursosParaAnotarse();
				
				modelDocente.put("Cursos", cursos);
				modelDocente.put("usuario", usuarioBuscado);
				
			   
				return new ModelAndView("homeDocente", modelDocente);}
			
			else{
				
				if(("alumno".equals(usuarioBuscado.getRol())))
					{
					model.put("usuario", usuarioBuscado);
					
					ArrayList<Curso>cursos = new ArrayList<Curso>();
					cursos = BuscarCursos.consultarTodosLosCursos(usuarioBuscado.getId());
					model.put("Materias", cursos);	
					
					return new ModelAndView("homeAlumno", model);}
								
				
				if(("admin".equals(usuarioBuscado.getRol())))
					
				{model.put("usuario", usuarioBuscado);
				return new ModelAndView("home", model);}
				model.put("error", "Usuario o clave incorrecta");
			}
			
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);//como no existe te manda de vuelta al login
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}
	
	

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
	
	//PARA DESLOGUEAR AL USUARIO
	@RequestMapping(value = "/exit",  method = RequestMethod.GET)
	public ModelAndView vistaLogout (HttpServletRequest request) {
		if(request.getSession() != null) {
			request.getSession().invalidate();
		}
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value = "/irHomeusuario",  method = RequestMethod.GET)
	public ModelAndView irHomeusuario(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		
		Usuario usuarioBuscado = serviciousuario.UsuarioporId((long) request.getSession().getAttribute("idUsuario"));
		if (usuarioBuscado != null) {
			
			request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
			
			if(("docente".equals(usuarioBuscado.getRol())))
			{
				ModelMap modelDocente = new ModelMap();
				
				ArrayList<Curso> cursos = new ArrayList<Curso>();		
				cursos =	servicioCurso.cursosParaAnotarse();
				
				modelDocente.put("Cursos", cursos);
				modelDocente.put("usuario", usuarioBuscado);
				
			   
				return new ModelAndView("homeDocente", modelDocente);}
			
			else{
				
				if(("alumno".equals(usuarioBuscado.getRol())))
					{
					model.put("usuario", usuarioBuscado);
					
					ArrayList<Curso>cursos = new ArrayList<Curso>();
					cursos = BuscarCursos.consultarTodosLosCursos(usuarioBuscado.getId());
					model.put("Materias", cursos);	
					
					return new ModelAndView("homeAlumno", model);}
								
				
				if(("admin".equals(usuarioBuscado.getRol())))
					
				{model.put("usuario", usuarioBuscado);
				return new ModelAndView("home", model);}
				model.put("error", "Usuario o clave incorrecta");
			}
			
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);//como no existe te manda de vuelta al login
	}

	
	

}
