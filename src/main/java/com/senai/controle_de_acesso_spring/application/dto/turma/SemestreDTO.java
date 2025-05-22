package com.senai.controle_de_acesso_spring.application.dto.turma;

import com.senai.controle_de_acesso_spring.domain.entity.turma.Semestre;

public record SemestreDTO (
        Long id,
        int numero,
        String nomeDaTurma
) {
    public static SemestreDTO toDTO(Semestre semestre) {
        return new SemestreDTO(
                semestre.getId(),
                semestre.getNumero(),
                semestre.getNomeDaTurma()
        );
    }
}

