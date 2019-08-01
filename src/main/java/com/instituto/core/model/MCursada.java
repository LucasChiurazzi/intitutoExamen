package com.instituto.core.model;

import java.util.Date;
import java.util.Objects;

import com.instituto.core.entity.Alumno;
import com.instituto.core.entity.Cursada;



public class MCursada {
	MCursada(){
		
	}
	private long id;
	private MAlumno alumno;
	private MCurso curso;
	private Date fechaCursada;
	private Double nota;
	
	
	public MCursada(Cursada cursada) {
		this.id = cursada.getId();
		this.alumno = new MAlumno(cursada.getAlumno());
		this.curso = new MCurso(cursada.getCurso());
		this.fechaCursada = cursada.getFechaCursada();
		this.nota = cursada.getNota();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	public MCursada(MAlumno alumno, MCurso curso, Date fechaCursada, Double nota) {
		this.alumno = alumno;
		this.curso = curso;
		this.fechaCursada = fechaCursada;
		this.nota = nota;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MCursada)) return false;
        MCursada that = (MCursada) o;
        return Objects.equals(curso.getId(), that.curso.getId()) &&
                Objects.equals(alumno.getId(), that.alumno.getId()) &&
                Objects.equals(fechaCursada, that.fechaCursada) &&
                Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curso.getId(), alumno.getId(), fechaCursada, nota);
    }

	public MAlumno getAlumno() {
		return alumno;
	}

	public void setAlumno(MAlumno alumno) {
		this.alumno = alumno;
	}

	public MCurso getCurso() {
		return curso;
	}

	public void setCurso(MCurso curso) {
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

}
