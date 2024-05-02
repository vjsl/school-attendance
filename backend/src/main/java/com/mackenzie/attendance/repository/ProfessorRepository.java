package com.mackenzie.attendance.repository;

import com.mackenzie.attendance.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

  //Mudança para o praticando da aula 5
}
