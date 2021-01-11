package com.spring.Api.model;

import java.io.Serializable;

import com.spring.Api.entity.Lenguaje;
import com.spring.Api.entity.Profesor;

public class ProfesorLenguaje implements Serializable {
	
	private Profesor profesor;
	private Lenguaje lenguaje;
	
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Lenguaje getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(Lenguaje lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	
	private static final long serialVersionUID = 1L;

}
