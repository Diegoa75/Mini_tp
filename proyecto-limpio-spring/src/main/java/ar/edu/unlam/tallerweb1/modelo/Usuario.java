package ar.edu.unlam.tallerweb1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity 
@Table(name="Usuario")

public class Usuario implements Serializable{
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String email;
	private String nombre;
	private String apellido;
	private String password;
	private String rol;
	
	 @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
     @JoinTable(name="UsuarioCurso", joinColumns={@JoinColumn(name="IdUsuario")}, inverseJoinColumns={@JoinColumn(name="IdCurso")})  
	 @Fetch(value = FetchMode.SUBSELECT)
	 private Collection<Curso> cursos = new ArrayList<Curso>();
	 
	@OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name="idUsuario")
	 @Fetch(value = FetchMode.SUBSELECT)
	private List<Nota> notas;
		
	public Usuario(){};
	public Usuario(String email,String password, String rol) {
		this.email = email;
		this.password = password;
		this.rol= rol;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Collection<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
}
