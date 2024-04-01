package com.mackenzie.attendance.repository;

import com.mackenzie.attendance.model.Turma;
import com.mackenzie.attendance.model.records.AlunosInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    List<Turma> findTurmasByProfessoresId(Long id);

}
