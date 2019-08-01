package com.instituto.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.instituto.core.entity.Curso;
import com.instituto.core.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Serializable> {
	
	@Query("SELECT c FROM Curso c JOIN Profesor p on( c.profesor = p.id) AND p.id = :idP")
	public abstract List<Curso> cursoDados(@Param("idP") long idP);
	


	
	

}
