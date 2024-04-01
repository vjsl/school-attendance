package com.mackenzie.attendance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "chamada")
public class Chamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @JsonIgnore
    private Instant registradoEm;

    private boolean presente;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Professor professor;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Estudante estudante;

    public Chamada(Long id, Instant registradoEm, boolean presente, Professor professor, Estudante estudante) {
        this.id = id;
        this.registradoEm = registradoEm;
        this.presente = presente;
        this.professor = professor;
        this.estudante = estudante;
    }

    public Chamada() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getRegistradoEm() {
        return registradoEm;
    }

    public void setRegistradoEm(Instant registradoEm) {
        this.registradoEm = registradoEm;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
