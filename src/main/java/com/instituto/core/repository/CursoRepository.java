package com.instituto.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.instituto.core.entity.*;
import com.instituto.core.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Serializable> {

	
	
	@Query("SELECT cu "
			+ "FROM Curso cu, "
			+ " Cursada c, Alumno a "
			+ "WHERE a.id = c.alumno "
			+ "AND cu.id = c.curso "
			+ "AND c.nota >= cu.notaXAprobar "
			+ "AND a.id = :idA")
	public abstract List<Curso> cursosAProbados(@Param("idA") long idA);
	
	
	public abstract List<Curso> findByProfesor(long id);
}
