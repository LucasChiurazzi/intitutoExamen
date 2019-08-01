package com.instituto.core.controller;

import java.util.List;

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
import com.instituto.core.repository.AlumnoRepository;
import com.instituto.core.repository.CursadaRepository;
import com.instituto.core.repository.CursoRepository;

import exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/instituto/cursada")
public class CursadaController {

	@Autowired
	private AlumnoRepository alumnos;

	@Autowired
	private CursoRepository cursos;
	
	@Autowired
	private CursadaRepository cursadaR;
	
	@Autowired
	@Qualifier("converter")
	private Convertidor convertidor;
	
	//obtener cursadas de un alumno
	@GetMapping("/alumno{id}")
	public List<MCursada> getCursada(@RequestParam (value = "id") long id){
		Alumno alumno=this.alumnos.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Alumno", id));
				
		return convertidor.convertirListaCA((cursadaR.findByAlumno(alumno)));
	}
	
	//crear cursada
	 @PostMapping("/curso/{id}/alumno{alumno_id}") 
	    public MCursada agregarAlumno(@PathVariable long id,
	    		@RequestParam (value = "alumno_id") long alumno_id, 
	    							@RequestBody @Valid Cursada cursada){
	        Alumno alumno = alumnos.findById(alumno_id).orElseThrow(
	                () -> new ResourceNotFoundException("Alumno", alumno_id)
	        );
	        Curso curso = cursos.findById(id).orElseThrow(
	                () -> new ResourceNotFoundException("Curso", id)
	        );
	        cursada.setAlumno(alumno);
	        cursada.setCurso(curso);
	        
	        return new MCursada(cursadaR.save(cursada));
	    }
	 
	 //borrar cursada
	 @DeleteMapping("/alumno/{id}/curso{curso_id}") 
	 public ResponseEntity borrarCursada(@PathVariable Long id,
	    		@RequestParam (value = "curso_id") long curso_id, 
	    							      @RequestBody @Valid Cursada cursada){
		 Alumno alumno = alumnos.findById(id).orElseThrow(
	                () -> new ResourceNotFoundException("Alumno", id)
	        );
	        Curso curso = cursos.findById(curso_id).orElseThrow(
	                () -> new ResourceNotFoundException("Curso", curso_id)
	        );
		 try {Cursada cu= cursadaR.findByAlumno_idAndCurso_id(id, curso_id);
				        cursadaR.delete(cu);
	            return ResponseEntity.ok("Alumno id " + id + " borrado");
	      	 }catch(Exception e){
			 throw new ResourceNotFoundException("No se encuentra cursada para alumno id: "+id +" y curso id: "+curso_id);
		 }
		
	
	 }
	 
	
	 //actualizar cursada
	 @PutMapping("/alumno/{id}/curso{curso_id}") 
	    public MCursada actualizarCursada(@PathVariable Long id,
	    		@RequestParam (value = "curso_id") long curso_id, 
	    							      @RequestBody @Valid Cursada cursada){
		 Alumno alumno = alumnos.findById(id).orElseThrow(
	                () -> new ResourceNotFoundException("Alumno", id)
	        );
	     Curso curso = cursos.findById(curso_id).orElseThrow(
	                () -> new ResourceNotFoundException("Curso", curso_id)
	        );
		
		return new MCursada(cursadaR.findById(cursada.getId()).map((toUpdate) -> {
		            toUpdate.setNota(cursada.getNota());
		            toUpdate.setAlumno(alumno);
		            toUpdate.setCurso(curso);
		            toUpdate.setFechaCursada(cursada.getFechaCursada());
		            return cursadaR.save(toUpdate);
		        }).orElseThrow(() -> new ResourceNotFoundException("Cursada",cursada.getId())));
				
		    }
			
}
	
	 
	 
	
	

