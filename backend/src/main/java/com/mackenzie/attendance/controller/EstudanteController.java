package com.mackenzie.attendance.controller;

import com.mackenzie.attendance.model.Estudante;
import com.mackenzie.attendance.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudante")
public class EstudanteController {

    private final EstudanteService service;

    @Autowired
    public EstudanteController(EstudanteService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Estudante getEstudante(@PathVariable long id){
        return service.buscaEstudante(id);
    }

    @PutMapping("/novo")
    public String createEstudante(@RequestBody Estudante estudante){
        service.criaEstudante(estudante);
        return "Estudante criado com sucesso!";

    }

}
