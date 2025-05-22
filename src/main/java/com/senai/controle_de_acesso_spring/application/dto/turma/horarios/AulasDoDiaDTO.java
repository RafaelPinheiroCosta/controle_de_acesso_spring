package com.senai.controle_de_acesso_spring.application.dto.turma.horarios;

import com.senai.controle_de_acesso_spring.domain.entity.turma.horarios.AulasDoDia;
import com.senai.controle_de_acesso_spring.domain.entity.turma.horarios.HorarioPadrao;
import com.senai.controle_de_acesso_spring.domain.enuns.DiasDaSemana;

import java.util.List;

public record AulasDoDiaDTO(
        Long id,
        DiasDaSemana diaDaSemana,
        List<AulaDTO> aulas
) {
    public static AulasDoDiaDTO toDTO(AulasDoDia d) {
        return new AulasDoDiaDTO(
                d.getId(),
                d.getDiaDaSemana(),
                d.getAulas().stream().map(AulaDTO::toDTO).toList()
        );
    }

    public AulasDoDia fromDTO() {
        AulasDoDia dia = new AulasDoDia();
        dia.setDiaDaSemana(diaDaSemana);
        dia.setAulas(aulas.stream().map(AulaDTO::fromDTO).toList());
        return dia;
    }
}
