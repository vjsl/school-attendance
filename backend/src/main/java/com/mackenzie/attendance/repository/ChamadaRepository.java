package com.mackenzie.attendance.repository;

import com.mackenzie.attendance.model.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long> {

    List<Chamada> findChamadasByEstudanteIdAndProfessorId(Long estudante, Long professor);
}
