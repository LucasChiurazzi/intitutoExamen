package com.instituto.core.model;

import java.util.Date;
import java.util.Set;

import com.instituto.core.entity.Alumno;
import com.instituto.core.entity.Cursada;
import com.instituto.core.entity.Persona;

public class MAlumno extends MPersona{



	public MAlumno(long id, String tipodni, int dni, String nombre, String apellido, Date fechanac, String sexo,
			String telefono, String domicilio) {
		super(id, tipodni, dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
		// TODO Auto-generated constructor stub
	}

	public MAlumno(Alumno alumno) {
		super(alumno);
		// TODO Auto-generated constructor stub
	}
	
	private Set<MCursada> cursadas;
	
	
	

}

	