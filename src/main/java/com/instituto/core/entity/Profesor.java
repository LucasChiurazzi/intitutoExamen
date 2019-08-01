package com.instituto.core.entity;

import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="profesor")
public class Profesor extends Persona{

	public Profesor() {
		super();
		
	}
	public Profesor( String tipodni, int dni, String nombre, String apellido, Date fechanac, String sexo,
			String telefono, @Size(max = 250) String domicilio) {
		super(tipodni, dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
		 
	}

	public Profesor(long id, String tipodni, int dni, String nombre, String apellido, Date fechanac, String sexo,
			String telefono, @Size(max = 250) String domicilio) {
		super(id, tipodni, dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
		 
	}
	
	
	
	
}
