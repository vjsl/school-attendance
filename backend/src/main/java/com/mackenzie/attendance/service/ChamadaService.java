package com.mackenzie.attendance.service;

import com.mackenzie.attendance.model.Chamada;
import com.mackenzie.attendance.repository.ChamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadaService {
    private final ChamadaRepository repository;

    @Autowired
    public ChamadaService(ChamadaRepository repository) {
        this.repository = repository;
    }

    public void registrarPresenca(Chamada chamada){
        repository.saveAndFlush(chamada);
    }

    public List<Chamada> listaFaltas() {
        return repository.findAll();
    }
}
