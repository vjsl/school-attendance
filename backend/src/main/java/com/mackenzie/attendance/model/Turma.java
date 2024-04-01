package com.mackenzie.attendance.model;

import com.mackenzie.attendance.model.enums.TipoTurma;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private short sala;

    @Enumerated(EnumType.STRING)
    private TipoTurma tipoTurma;

    @OneToMany
    @JoinTable(name = "turma_professor", joinColumns = @JoinColumn(name = "turma_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "id"))
    private List<Professor> professores;

    @OneToMany
    @JoinTable(name="turma_estudantes", joinColumns = @JoinColumn(name = "turma_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "estudante_id", referencedColumnName = "id"))
    private List<Estudante> estudantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getSala() {
        return sala;
    }

    public void setSala(short sala) {
        this.sala = sala;
    }

    public TipoTurma getTipoTurma() {
        return tipoTurma;
    }

    public void setTipoTurma(TipoTurma tipoTurma) {
        this.tipoTurma = tipoTurma;
    }

    public List<Professor> getProfessor() {
        return professores;
    }

    public void setProfessor(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
}
