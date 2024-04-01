package com.mackenzie.attendance.controller;

import com.mackenzie.attendance.model.Chamada;
import com.mackenzie.attendance.service.ChamadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chamada")
public class ChamadaController {

    private final ChamadaService service;

    @Autowired
    public ChamadaController(ChamadaService service) {
        this.service = service;
    }

    @PutMapping
    public String registraPresenca(@RequestBody Chamada chamada) {
        service.registrarPresenca(chamada);
        return "Presença registrada";
    }
}
