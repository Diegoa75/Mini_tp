package ar.edu.unlam.tallerweb1.modelo;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Examen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String nombre;
	private String fecha;
	private String tipo;
	
	@Column(name = "habilitado", nullable = true, columnDefinition = "int default 1")
	private int habilitado;
	private String estado; 
	private int umbral;
	
	
	@ManyToOne ( fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name="idCurso")
	private Curso curso;
	
	@OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name="idExamen")	
	 @Fetch(value = FetchMode.SUBSELECT)
	private List<Nota> nota;
	
/*	 @OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
     @JoinTable(name="ExqamenCurso", joinColumns={@JoinColumn(name="IdExamen")}, inverseJoinColumns={@JoinColumn(name="IdNota")})  
	 @Fetch(value = FetchMode.SUBSELECT)
	 private Collection<Curso> cursos = new ArrayList<Curso>();*/
	
	
	@OneToMany (fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name="idExamen")
	private List<Pregunta> preguntas;
		
	public Examen() {
		super();
	}
	
	public Examen(String nombre, String fecha, String tipo, List<Pregunta> preguntas,int umbral) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.tipo = tipo;
		this.preguntas = preguntas;
		this.umbral = umbral;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public List<Pregunta> getPreguntas() {
		return preguntas;
	}


	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	} 
	
	public int getUmbral() {
		return umbral;
	}


	public void setUmbral(int umbral) {
		this.umbral = umbral;
	}
	
	
	
	@Transient(false)
	public String getEstado() {
		if (habilitado==0)
			return "Habilitado";			
		else		
			return "Deshabilitado";	
	}

	
	public int getHabilitado() {
		return habilitado;
	}

	

	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
		
	}
	
	public List<Nota> getNota() {
		return nota;
	}

	public void setNota(List<Nota> nota) {
		this.nota = nota;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
	

}