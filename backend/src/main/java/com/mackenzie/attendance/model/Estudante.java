package com.mackenzie.attendance.model;

import com.mackenzie.attendance.model.enums.Sexo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "estudante")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String foto;

    private short qtdeFaltas = 0;

    @ManyToMany
    @JoinTable(name = "responsavel_estudante", joinColumns = @JoinColumn(name = "responsavel_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "estudante_id", referencedColumnName = "id"))
    private List<Responsavel> responsavel;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Responsavel> getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(List<Responsavel> responsavel) {
        this.responsavel = responsavel;
    }

    public short getQtdeFaltas() {
        return qtdeFaltas;
    }

    public void setQtdeFaltas(short qtdeFaltas) {
        this.qtdeFaltas = qtdeFaltas;
    }
}
