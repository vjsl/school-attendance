package com.mackenzie.attendance.controller;

import com.mackenzie.attendance.model.Estudante;
import com.mackenzie.attendance.model.Turma;
import com.mackenzie.attendance.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Turma buscaListaChamada(@PathVariable long id) {
        return service.buscaTurma(id);
    }

    @GetMapping("/professor/{id}")
    public List<Turma> turmasPorProfessor(@PathVariable Long id){
        return service.turmasPorProfessor(id);
    }
}
