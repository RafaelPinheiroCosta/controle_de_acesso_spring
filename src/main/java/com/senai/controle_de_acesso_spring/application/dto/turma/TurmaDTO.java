package com.senai.controle_de_acesso_spring.application.dto.turma;

import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import com.senai.controle_de_acesso_spring.domain.entity.turma.Turma;
import com.senai.controle_de_acesso_spring.domain.enuns.Periodo;

import java.time.LocalDate;
import java.time.LocalTime;

public record TurmaDTO(
        Long id,
        String siglaDaTurma,
        Periodo periodo,
        LocalDate dataInicial,
        LocalTime horarioEntrada,
        Integer qtdSemestres,
        Integer qtdAulasPorDia,
        Long cursoId
) {
    public static TurmaDTO toDTO(Turma turma) {
        return new TurmaDTO(
                turma.getId(),
                turma.getSiglaDaTurma(),
                turma.getPeriodo(),
                turma.getDataInicial(),
                turma.getHorarioEntrada(),
                turma.getQtdSemestres(),
                turma.getQtdAulasPorDia(),
                turma.getCurso() != null ? turma.getCurso().getId() : null
        );
    }

    public Turma fromDTO() {
        Turma turma = new Turma();
        turma.setSiglaDaTurma(siglaDaTurma);
        turma.setPeriodo(periodo);
        turma.setDataInicial(dataInicial);
        turma.setHorarioEntrada(horarioEntrada);
        turma.setQtdSemestres(qtdSemestres);
        turma.setQtdAulasPorDia(qtdAulasPorDia);
        return turma;
    }
}
