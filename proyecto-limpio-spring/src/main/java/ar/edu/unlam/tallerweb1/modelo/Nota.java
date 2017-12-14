package ar.edu.unlam.tallerweb1.modelo;

import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;		
		
	@ManyToOne (fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name="idUsuario")
	private Usuario usuario;

	@ManyToOne (fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name="idExamen")	
	private Examen examen;
		
	private String Fecha;
	private float Calificacion;
				
	
	public Nota() {
		super();
		// TODO Auto-generated constructor stub
	}
	public float getCalificacion() {
		return Calificacion;
	}
	public void setCalificacion(float calificacion) {
		Calificacion = calificacion;
	}
	public Nota(long id, Usuario Usuario, Examen examen, String fecha) {
		super();
		this.id = id;
		this.usuario = Usuario;
		this.examen = examen;
		Fecha = fecha;
	}
			
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public Examen getExamen() {
		return examen;
	}
	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha =  fecha;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
	

}
