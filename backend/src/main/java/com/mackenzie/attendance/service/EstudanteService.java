package com.mackenzie.attendance.service;

import com.mackenzie.attendance.model.Estudante;
import com.mackenzie.attendance.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudanteService {
    private final EstudanteRepository repository;

    @Autowired
    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

    public Estudante buscaEstudante(long id) {
        return repository.findById(id).orElse(null);
    }

    public void criaEstudante(Estudante estudante) {
        repository.save(estudante);
    }
}
