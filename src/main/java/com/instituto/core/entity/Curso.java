package com.instituto.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="curso")
public class Curso implements Serializable{
	
	public Curso() {
	}

   public Curso(long id, String nombreCurso, String descripcion, int notaXAprobar, Profesor profesor) {
		this.id= id;
	   this.nombreCurso = nombreCurso;
		this.descripcion = descripcion;
		this.notaXAprobar = notaXAprobar;
		this.profesor = profesor;
	}
   public Curso(String nombreCurso, String descripcion, int notaXAprobar, Profesor profesor) {
		this.nombreCurso = nombreCurso;
		this.descripcion = descripcion;
		this.notaXAprobar = notaXAprobar;
		this.profesor = profesor;
	}


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", updatable = false, nullable = false)
	private long id;
	
    @NotNull
	@Column(name="nombreCurso")
	private String nombreCurso;
	
    @NotNull
	@Column(name="descripcion")
	private String descripcion;
	
    @NotNull
	@Column(name="notaXAprobar")
	private int notaXAprobar;
	
	@ManyToOne(
			fetch=FetchType.LAZY,
			cascade = CascadeType.ALL,
			optional= false
			)
	@JoinColumn(
			name="profesor_id",
			nullable= false
			)
	 @JsonIgnore
	private Profesor profesor;
	
	 @OneToMany(
	            fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL,
	            mappedBy = "curso"
	    )	   
	private Set<Cursada> cursada= new HashSet<>();


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



	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Set<Cursada> getCursada() {
		return cursada;
	}

	public void setCursada(Set<Cursada> cursada) {
		this.cursada = cursada;
	}

	

}
