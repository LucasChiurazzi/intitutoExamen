package com.instituto.core.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.instituto.core.model.MAlumno;
import com.instituto.core.model.MCursada;
import com.instituto.core.model.MCurso;
import com.instituto.core.repository.*;

import exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/instituto")
public class AlumnoController {
	
	@Autowired
	private AlumnoRepository alumnos;

	@Autowired
	private CursoRepository cursos;
	
	@Autowired
	private CursadaRepository cursadaR;
	
	@Autowired
	@Qualifier("converter")
	private Convertidor convertidor;
	
	
	@PostMapping("/alumno")
	public MAlumno crearAlumno(@RequestBody @Valid Alumno alumno) {
		MAlumno malumno = new MAlumno(this.alumnos.save(alumno));
		return malumno;
	}
	
    //listar todos los alumnos se puede usar page
	@GetMapping("/alumnos") 
    public List<MAlumno> getAlumnos(){
	  return convertidor.convertirListaA(this.alumnos.findAll());
    }
	
	
	@GetMapping("/alumno{id}") 
    public MAlumno getAlumno(@RequestParam (value = "id") long id){
		return new MAlumno(this.alumnos.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Alumno", id)));
		}
	
	@PutMapping("/alumno")
    public MAlumno actualizarAlumno(@RequestBody @Valid Alumno alumno){
		MAlumno malumno = new MAlumno(
       this.alumnos.findById(alumno.getId()).map((toUpdate) -> {
            toUpdate.setApellido(alumno.getApellido());
            toUpdate.setNombre(alumno.getNombre());
            toUpdate.setDni(alumno.getDni());
            toUpdate.setTipodni(alumno.getTipodni());
            toUpdate.setFechanac(alumno.getFechanac());
            toUpdate.setSexo(alumno.getSexo());
            toUpdate.setTelefono(alumno.getTelefono());
            toUpdate.setDomicilio(alumno.getDomicilio());
            return this.alumnos.save(toUpdate);
        }).orElseThrow(() -> new ResourceNotFoundException("Alumno", alumno.getId())));
		return malumno;
    }
	
	@DeleteMapping("/alumno{id}")
    public ResponseEntity borrarAlumnos(@RequestParam long id){
         return this.alumnos.findById(id).map((toDelete) -> {
            this.alumnos.delete(toDelete);
            return ResponseEntity.ok("Alumno id " + id + " borrado");
        }).orElseThrow(() -> new ResourceNotFoundException("Alumno", id));
    }
	
	//listar los todos los cursos de un alumno
	@GetMapping("/alumno/{id}/cursos")
    public List<MCurso> getCursos(@PathVariable long id){
        List<Curso> alumnoCursos= new ArrayList<>();
	
		 Set<Cursada> cursadas=this.alumnos.findById(id).map((alumno) -> {
        	return alumno.getCursada();
        }).orElseThrow(() -> new ResourceNotFoundException("Alumno", id));
       for(Cursada cursada: cursadas) {
    	   alumnoCursos.add(cursada.getCurso());
       }
   	List<MCurso> mcursos= convertidor.convertirListaC(alumnoCursos);
	return mcursos;
    }
	
	
	//listar cursos aprobados
	@GetMapping("alumno/{id}/cursos/aprobados")
    public List<MCurso> getCursosAprobados(@PathVariable long id){
		return convertidor.convertirListaC(cursos.cursosAProbados(id));
				
    }
	
	
	
}
