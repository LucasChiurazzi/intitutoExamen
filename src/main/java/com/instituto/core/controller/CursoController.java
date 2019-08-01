package com.instituto.core.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instituto.core.converter.Convertidor;
import com.instituto.core.entity.Alumno;
import com.instituto.core.entity.Cursada;
import com.instituto.core.entity.Curso;
import com.instituto.core.entity.Profesor;
import com.instituto.core.model.MAlumno;
import com.instituto.core.model.MCursada;
import com.instituto.core.model.MCurso;
import com.instituto.core.repository.*;

import exceptions.ResourceNotFoundException;
@RestController
@RequestMapping("/instituto")
public class CursoController {
	
		@Autowired
	private CursoRepository cursos;
		@Autowired
		private ProfesorRepository profesores;
		@Autowired
		private AlumnoRepository alumnos;
		@Autowired
		private CursadaRepository cursadaR;

	@Autowired
	@Qualifier("converter")
	private Convertidor convertidor;
	
	//crear curso y agrega un profesor
	@PostMapping("/curso/profesor{id_profesor}")
	public MCurso crearCurso(@RequestParam (value = "id_profesor") long idprofesor,
			@RequestBody @Valid Curso curso) {
	return new MCurso(profesores.findById(idprofesor).map(profesor -> {
           curso.setProfesor(profesor);
            return cursos.save(curso);
        }).orElseThrow(() -> new ResourceNotFoundException("Profesor", idprofesor)));
    }
	
    //listar todos los cursos se puede usar page
	@GetMapping("/cursos") 
    public List<MCurso> getCursos(){
	  return convertidor.convertirListaC(this.cursos.findAll());
    }
	
	//obtener un curso por el id
	@GetMapping("/curso/{id}") 
    public MCurso getCurso(@PathVariable long id){
		return new MCurso(cursos.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Curso", id)));
		}
	
	//actualizar curso
	@PutMapping("/curso{id_profesor}")
    public MCurso actualizarCurso(@RequestParam (value = "id_profesor") long idprofesor,
    		@RequestBody @Valid Curso curso){
		Profesor profesor =profesores.findById(idprofesor).orElseThrow(
                () -> new ResourceNotFoundException("Profesor", idprofesor)
        );
		return new MCurso(
       cursos.findById(curso.getId()).map((toUpdate) -> {
    	   toUpdate.setNombreCurso(curso.getNombreCurso());
            toUpdate.setDescripcion(curso.getDescripcion());
            toUpdate.setNotaXAprobar(curso.getNotaXAprobar());
            toUpdate.setProfesor(profesor);
            return cursos.save(toUpdate);
        }).orElseThrow(() -> new ResourceNotFoundException("Curso", curso.getId())));
		
    }
	
	//Borrar curso
	@DeleteMapping("/curso{id}")
    public ResponseEntity deleteStudent(@PathVariable long id){
         return cursos.findById(id).map((toDelete) -> {
            cursos.delete(toDelete);
            return ResponseEntity.ok("Curso id " + id + " borrado");
        }).orElseThrow(() -> new ResourceNotFoundException("Curso", id));
    }
	
	//listar alumnos de un curso
	@GetMapping("/curso/{id}/alumnos")
    public List<MAlumno> getAlumnosCurso(@PathVariable long id){
        List<Alumno> alumnosCurso= new ArrayList<>();
	
		 Set<Cursada> cursadas=cursos.findById(id).map((curso) -> {
        	return curso.getCursada();
        }).orElseThrow(() -> new ResourceNotFoundException("Curso", id));
       for(Cursada cursada: cursadas) {
    	   alumnosCurso.add(cursada.getAlumno());
       }
   	List<MAlumno> malumnos= convertidor.convertirListaA(alumnosCurso);
	return malumnos;
	}
	//listar Alumnos aprobados
	@GetMapping("/curso/{id}/alumnos/aprobados")
	public List<MAlumno> getCursosAprobados(@PathVariable long id){
		return convertidor.convertirListaA(alumnos.alumnosAprobados(id));
	}
	
	
	
	
	
    }