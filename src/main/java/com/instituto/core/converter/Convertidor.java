package com.instituto.core.converter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.instituto.core.entity.Alumno;
import com.instituto.core.entity.Cursada;
import com.instituto.core.entity.Curso;
import com.instituto.core.entity.Profesor;
import com.instituto.core.model.MAlumno;
import com.instituto.core.model.MCursada;
import com.instituto.core.model.MCurso;
import com.instituto.core.model.MProfesor;

@Component("converter")
public class Convertidor{
	public List<MAlumno> convertirListaA(List<Alumno> alumnos){
		List<MAlumno> malumnos= new ArrayList<>();
		for(Alumno alumno: alumnos) {
			malumnos.add(new MAlumno(alumno));
		}
		return malumnos;
	}
	
	public List<MProfesor> convertirListaP(List<Profesor> profesores){
		List<MProfesor> mprofesores= new ArrayList<>();
		for(Profesor profesor: profesores) {
			mprofesores.add(new MProfesor(profesor));
		}
		return mprofesores;
	}
	

public List<MCurso> convertirListaC(List<Curso> cursos){
		List<MCurso> mcursos= new ArrayList<>();
		for(Curso curso: cursos) {
			mcursos.add(new MCurso(curso));
		}
		return mcursos;
	}
	
public List<MCursada> convertirListaCA(List<Cursada> cursadas){
	List<MCursada> mcursadas= new ArrayList<>();
	for(Cursada cursada: cursadas) {
		mcursadas.add(new MCursada(cursada));
	}
	return mcursadas;
}

}
