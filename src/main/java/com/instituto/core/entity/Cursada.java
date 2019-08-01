package com.instituto.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Cursada implements Serializable{
	public Cursada() {
		
	}
	
	public Cursada(Alumno alumno, Curso curso, Date fechaCursada, Double nota) {
	
		this.alumno = alumno;
		this.curso = curso;
		this.fechaCursada = fechaCursada;
		this.nota = nota;
	}
	
	public Cursada(Alumno alumno, Curso curso, Date fechaCursada, Double nota, long id) {
		this.id= id;
		this.alumno = alumno;
		this.curso = curso;
		this.fechaCursada = fechaCursada;
		this.nota = nota;
	}
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", updatable = false, nullable = false) 
	private long id;
	
	@ManyToOne
	@JoinColumn
	@NotNull
	private Alumno alumno;
	
	
	@ManyToOne
	@JoinColumn
	@NotNull
	private Curso curso;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaCursada;
	

	private Double nota;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getFechaCursada() {
		return fechaCursada;
	}

	public void setFechaCursada(Date fechaCursada) {
		this.fechaCursada = fechaCursada;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cursada)) return false;
        Cursada that = (Cursada) o;
        return Objects.equals(curso.getId(), that.curso.getId()) &&
                Objects.equals(alumno.getId(), that.alumno.getId()) &&
                Objects.equals(fechaCursada, that.fechaCursada) &&
                Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curso.getId(), alumno.getId(), fechaCursada, nota);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	 
	

}
