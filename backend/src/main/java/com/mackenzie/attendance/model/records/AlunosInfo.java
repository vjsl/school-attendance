package com.mackenzie.attendance.model.records;

import java.time.LocalDate;

public record AlunosInfo(String nome, LocalDate nascimento, String nomeResponsavel, short faltas) {
}
