package com.instituto.core.model;

import java.util.Date;

import com.instituto.core.entity.Persona;
import com.instituto.core.entity.Profesor;

public class MProfesor extends MPersona{

	public MProfesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MProfesor(long id, String tipodni, int dni, String nombre, String apellido, Date fechanac, String sexo,
			String telefono, String domicilio) {
		super(id, tipodni, dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
		// TODO Auto-generated constructor stub
	}

	public MProfesor(Profesor profesor) {
		super(profesor);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
