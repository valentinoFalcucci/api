package com.spring.Api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="profesores")
public class Profesor implements Serializable {

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(length =60,unique = true)
	private String email;
	private String password;
	@Column(length = 2000)
	private String foto;
	
	@Column(name="creat_at")
	@Temporal(TemporalType.DATE)
	private Date creatAt;
	
	@PrePersist
	public void prePersis()
	{
		creatAt=new Date();
	}
	
	
	
	// Agrego campo FK
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="profesor_id",referencedColumnName = "id")
	private List<Curso> listaCursos=new ArrayList();
	
	
	
	
	// RELACION MUCHOS A MUCHOS CON LENGUAJE
	
	@ManyToMany
	@JsonBackReference
	@JoinTable(name="profesores_lenguajes",
			joinColumns =@JoinColumn (name="profesor_id", referencedColumnName = "id"),
			inverseJoinColumns=@JoinColumn(name="lenguaje_id",referencedColumnName = "id")
			)
	//private Set<Lenguaje> listaLenguajes=new HashSet<>();
	
	private List<Lenguaje> listaLenguajes=new ArrayList();
	
	
	
	
	//Metodos de acceso
	
//	public Set<Lenguaje> getListaLenguajes() {
//		return listaLenguajes;
//	}
//	public void setListaLenguajes(Set<Lenguaje> listaLenguajes) {
//		this.listaLenguajes = listaLenguajes;
//	}
	
	
	
	
	
	
	public List<Lenguaje> getListaLenguajes() {
		return listaLenguajes;
	}
	public void setListaLenguajes(List<Lenguaje> listaLenguajes) {
		this.listaLenguajes = listaLenguajes;
	}
	public List<Curso> getListaCursos() {
		return listaCursos;
	}
	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Date getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}
	
	
	
	//Metodo añadir lenguaje
	public void addLenguaje(Lenguaje lenguaje)
	{
		this.listaLenguajes.add(lenguaje);
	}
 
	
}
