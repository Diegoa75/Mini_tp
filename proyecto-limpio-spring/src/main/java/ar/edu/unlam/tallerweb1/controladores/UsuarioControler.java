package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Curso.ServicioCurso;
import ar.edu.unlam.tallerweb1.servicios.Usuario.ServicioUsuario;


@Controller
public class UsuarioControler {
	@RequestMapping("/ingresarDocente")
	public ModelAndView ingresarDocente()
	{
		ModelMap modelo = new ModelMap();
		Usuario docente = new Usuario();
		modelo.put("docente", docente);
		return new ModelAndView("formularioIngresaDocente", modelo);
	}
	@Inject
	private ServicioUsuario registrarDocente;
	
	@RequestMapping(value="/guardarDocente", method = RequestMethod.POST)
	public ModelAndView guardarDocente(@ModelAttribute("docente")Usuario docente)
	{
	ModelMap model= new ModelMap();	
	docente.setRol("docente");
	registrarDocente.grabarUsuario(docente);
	return new ModelAndView("home",model);	
	}
}
	
	
	