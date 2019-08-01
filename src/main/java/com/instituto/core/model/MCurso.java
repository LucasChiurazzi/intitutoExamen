package com.instituto.core.model;

import java.util.HashSet;
import java.util.Set;

import com.instituto.core.entity.Cursada;
import com.instituto.core.entity.Curso;

public class MCurso {
	public MCurso() {
		
	}
	
	public MCurso(Curso curso) {
		this.id = curso.getId();
		this.nombreCurso = curso.getNombreCurso();
		this.descripcion = curso.getDescripcion();
		this.notaXAprobar = curso.getNotaXAprobar();
		this.profesor = new MProfesor(curso.getProfesor());

		
	}

	public MCurso(long id, String nombreCurso, String descripcion, int notaXAprobar, MProfesor profesor) {
		
		this.id = id;
		this.nombreCurso = nombreCurso;
		this.descripcion = descripcion;
		this.notaXAprobar = notaXAprobar;
		this.profesor = profesor;
	
	}
	private long id;
	private String nombreCurso;
	private String descripcion;
	private int notaXAprobar;
	private MProfesor profesor;
	private Set<MCursada> cursadas= new HashSet<>();
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNotaXAprobar() {
		return notaXAprobar;
	}
	public void setNotaXAprobar(int notaXAprobar) {
		this.notaXAprobar = notaXAprobar;
	}
	public MProfesor getProfesor() {
		return profesor;
	}
	public void setProfesor(MProfesor profesor) {
		this.profesor = profesor;
	}

	
	
	
}
