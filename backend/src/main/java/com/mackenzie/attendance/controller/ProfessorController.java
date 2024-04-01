package com.mackenzie.attendance.controller;

import com.mackenzie.attendance.model.Professor;
import com.mackenzie.attendance.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    private final ProfessorService service;

    @Autowired
    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<Professor> todosProfessores(){
        return service.listaProfessores();
    }

    @GetMapping("/{id}")
    public Professor getProfessor(@PathVariable long id){
        return service.buscaProfessor(id);
    }
}
