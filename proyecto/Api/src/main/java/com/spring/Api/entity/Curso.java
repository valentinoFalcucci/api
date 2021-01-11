package com.spring.Api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="curso")
public class Curso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long curso_id;
	
	private String nombre;
	
	@Column(name="profesor_id")
	private Long profesorId;
	
	
	// Metodos de acceso
	
	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Long getProfesorId() {
		return profesorId;
	}




	public void setProfesorId(Long profesorId) {
		this.profesorId = profesorId;
	}



	//Constructor
	
	
	public Curso() {
		super();
	}




	public Curso(String nombre, Long profesorId) {
		super();
		this.nombre = nombre;
		this.profesorId = profesorId;
	}
 

	private static final long serialVersionUID=1L;
}
