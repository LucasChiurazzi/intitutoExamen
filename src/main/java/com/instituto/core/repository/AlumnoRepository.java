package com.instituto.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.instituto.core.entity.*;



@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Serializable> {
 
	

	@Query("SELECT a "
			+ " FROM Alumno a, "
			+ "Curso cu,  Cursada c "
			+ "WHERE a.id=c.alumno "
			+ "AND cu.id = c.curso "
			+ "AND c.nota >= cu.notaXAprobar "
			+ "AND cu.id = :idC")
	public abstract List<Alumno> alumnosAprobados(@Param("idC") long idA);
  
}
