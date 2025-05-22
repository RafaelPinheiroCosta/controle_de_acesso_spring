package com.senai.controle_de_acesso_spring.application.dto.turma.horarios;

import com.senai.controle_de_acesso_spring.domain.entity.turma.horarios.HorarioBase;

import java.util.List;

public record HorarioBaseDTO(
        Long id,
        Long semestreId,
        List<AulasDoDiaDTO> listaDeAulasDoDia
) {
    public static HorarioBaseDTO toDTO(HorarioBase h) {
        return new HorarioBaseDTO(
                h.getId(),
                h.getSemestre() != null ? h.getSemestre().getId() : null,
                h.getListaDeAulasDoDia().stream().map(AulasDoDiaDTO::toDTO).toList()
        );
    }
}
