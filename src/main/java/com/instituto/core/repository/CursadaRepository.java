package com.instituto.core.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.instituto.core.entity.Alumno;
import com.instituto.core.entity.Cursada;
import com.instituto.core.entity.Curso;


@Repository
public interface CursadaRepository extends JpaRepository<Cursada, Serializable> {
	public abstract boolean existsByAlumnoIdAndCursoId(long alumno_id, long curso_id);
	
	public abstract Cursada findByAlumno_idAndCurso_id(long alumno_id, long curso_id);
	
	@Query("SELECT cu FROM Cursada cu Where curso_id= :curso AND alumno_id= :alumno")
	public abstract Cursada findByAlumnoAndCurso(@Param ("alumno") long alumno_id,@Param ("curso") long curso_id);
	
	public abstract List<Cursada> findByAlumno(Alumno alumno);
	
	public abstract List<Cursada> findByCurso(long curso_id);
	
	//public abstract List<Curso> finByCurso(long curso_id);
	
	//public abstract List<Alumno> findByAlumnoId(long alumno_id);
	
	//public abstract List<Alumno> finByNotaGreaterThanEqualCursoNotaxaprobar(Alumno alumno);
 
  
}
