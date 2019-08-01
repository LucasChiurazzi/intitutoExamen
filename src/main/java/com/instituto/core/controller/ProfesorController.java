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
import org.springframework.web.bind.annotation.RestController;

import com.instituto.core.converter.Convertidor;
import com.instituto.core.entity.*;
import com.instituto.core.model.MCurso;
import com.instituto.core.model.MProfesor;
import com.instituto.core.repository.*;

import exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/instituto")
public class ProfesorController {
	
	@Autowired
	private ProfesorRepository profesores;

	@Autowired
	@Qualifier("converter")
	private Convertidor convertidor;
	
	//Crud Profesor
	@PostMapping("/profesor")
	public MProfesor crearProfesor(@RequestBody @Valid Profesor profesor) {
		MProfesor mprofesor = new MProfesor(this.profesores.save(profesor));
		return mprofesor;
	}
	
    //listar todos los profesores del instituto
	@GetMapping("/profesores") 
    public List<MProfesor> getProfesors(){
	  return convertidor.convertirListaP(this.profesores.findAll());
    }
	
	
	@GetMapping("/profesor/{id}") 
    public MProfesor getProfesor(@PathVariable long id){
		return new MProfesor(this.profesores.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Profesor", id)));
		}
	
	@PutMapping("/profesor")
    public MProfesor actualizarProfesor(@RequestBody @Valid Profesor profesor){
		MProfesor mprofesor = new MProfesor(
		this.profesores.findById(profesor.getId()).map((toUpdate) ->{
			toUpdate.setApellido(profesor.getApellido());
            toUpdate.setNombre(profesor.getNombre());
            toUpdate.setDni(profesor.getDni());
            toUpdate.setTipodni(profesor.getTipodni());
            toUpdate.setFechanac(profesor.getFechanac());
            toUpdate.setSexo(profesor.getSexo());
            toUpdate.setTelefono(profesor.getTelefono());
            toUpdate.setDomicilio(profesor.getDomicilio());
            return this.profesores.save(toUpdate);
        }).orElseThrow(() -> new ResourceNotFoundException("Profesor", profesor.getId())));
		return mprofesor;
    }
	
	@DeleteMapping("/profesor/{id}")
    public ResponseEntity deleteStudent(@PathVariable long id){
         return this.profesores.findById(id).map((toDelete) -> {
            this.profesores.delete(toDelete);
            return ResponseEntity.ok("Profesor id " + id + " borrado");
        }).orElseThrow(() -> new ResourceNotFoundException("Profesor", id));
    }
	
	
	@GetMapping("profesor/{id}/cursos")
	public List<MCurso> getCursosDados(@PathVariable long id){
		return convertidor.convertirListaC(profesores.cursoDados(id));
	}
	
	
}