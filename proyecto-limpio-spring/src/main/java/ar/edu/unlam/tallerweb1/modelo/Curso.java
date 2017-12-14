package ar.edu.unlam.tallerweb1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@SuppressWarnings("serial")
@Entity
@Table(name="Curso")
public class Curso implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private int cantidadAlumnos;
	private int maximoAlumnos;
			
	 @ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REFRESH},mappedBy="cursos")	
	 @Fetch(value = FetchMode.SUBSELECT)	
	 private Collection<Usuario> usuarios = new ArrayList<Usuario>();
	 
	/*@OneToMany (fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn (name="idCurso")
	private List<Usuario> usuarios;*/
	 	
	@OneToMany(fetch=FetchType.EAGER,cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name="idCurso")	
	@Fetch(value = FetchMode.SUBSELECT)	
	private List<Examen> examen;
	 
	public Curso(){}
	
	public List<Examen> getExamen() {
		return examen;
	}

	public void setExamen(List<Examen> examen) {
		this.examen = examen;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long idCurso) {
		this.id = idCurso;
	}
	
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public int getCantidadAlumnos() {
		return cantidadAlumnos;
	}

	public void setCantidadAlumnos(int cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}

	public int getMaximoAlumnos() {
		return maximoAlumnos;
	}

	public void setMaximoAlumnos(int maximoAlumnos) {
		this.maximoAlumnos = maximoAlumnos;
	}
	
		
	
}
