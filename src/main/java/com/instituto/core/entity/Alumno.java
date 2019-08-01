package com.instituto.core.entity;

import java.util.Date;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Table(name="alumno")
@Entity
public class Alumno extends Persona{

	@OneToMany(
	            fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL,
	            mappedBy = "alumno"
	    )	   
	private Set<Cursada> cursadas;

	public Set<Cursada> getCursada() {
		return cursadas;
	}

	public void setCursada(Set<Cursada> cursadas) {
		this.cursadas = cursadas;
	}
	public Alumno() {
		super();
	}
	
	public Alumno(long id, String tipodni, int dni, String nombre, String apellido, Date fechanac, String sexo,
			String telefono, @Size(max = 250) String domicilio, Cursada... cursadas) {
		super(id, tipodni, dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
		 for(Cursada cursada : cursadas)cursada.setAlumno(this);
	        this.cursadas = Stream.of(cursadas).collect(Collectors.toSet());
	    
	}
	

}

	