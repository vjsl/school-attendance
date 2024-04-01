package com.mackenzie.attendance.service;

import com.mackenzie.attendance.model.Chamada;
import com.mackenzie.attendance.model.Estudante;
import com.mackenzie.attendance.model.Turma;
import com.mackenzie.attendance.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TurmaService {
    private final TurmaRepository repository;
    private final ChamadaService chamadaService;

    @Autowired
    public TurmaService(TurmaRepository repository, ChamadaService chamadaService) {
        this.repository = repository;
        this.chamadaService = chamadaService;
    }

    public Turma buscaTurma(long id){
        return repository.findById(id).orElse(null);
    }

    public List<Turma> turmasPorProfessor(Long professorId){
        List<Turma> turmas = repository.findTurmasByProfessoresId(professorId);
        List<Chamada> chamadas = chamadaService.listaFaltas();
        for (Turma turma : turmas) {
            List<Estudante> estudantes = turma.getEstudantes();
            for (Estudante estudante : estudantes) {
                short count = 0;
                for (Chamada chamada : chamadas) {
                    if (Objects.equals(chamada.getEstudante().getId(), estudante.getId()) && !chamada.isPresente()) {
                        count++;
                    }
                }
                estudante.setQtdeFaltas(count);
            }
            turma.setEstudantes(estudantes);

        }
        return turmas;
    }
}
