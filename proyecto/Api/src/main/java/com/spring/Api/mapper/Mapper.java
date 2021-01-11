package com.spring.Api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.Api.entity.Profesor;
import com.spring.Api.model.MProfesor;

@Component("mapper")
public class Mapper {

	public static List<MProfesor> lista (List<Profesor> listaProfesor)
	{
		List<MProfesor> MProfesor=new ArrayList();
		
		for(Profesor profesor:listaProfesor)
		{
			MProfesor.add(new MProfesor(profesor));
		}
		return MProfesor;
	}
}
