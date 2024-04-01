package com.mackenzie.attendance.service;

import com.mackenzie.attendance.model.Professor;
import com.mackenzie.attendance.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository repository;

    @Autowired
    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> listaProfessores(){
        return repository.findAll();
    }

    public Professor buscaProfessor(long id){
        return repository.findById(id).orElse(null);
    }
}
