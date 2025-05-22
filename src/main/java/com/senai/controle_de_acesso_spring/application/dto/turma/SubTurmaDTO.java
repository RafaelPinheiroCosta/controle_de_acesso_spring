package com.senai.controle_de_acesso_spring.application.dto.turma;

import com.senai.controle_de_acesso_spring.domain.entity.turma.Semestre;
import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import com.senai.controle_de_acesso_spring.domain.entity.turma.Turma;

public record SubTurmaDTO(
        Long id,
        String nome,
        Long turmaId
) {
    public static SubTurmaDTO toDTO(SubTurma s) {
        return new SubTurmaDTO(
                s.getId(),
                s.getNome(),
                s.getTurma().getId()
        );
    }

    public  SubTurma fromDTO() {
        SubTurma subTurma = new SubTurma();
        subTurma.setNome(nome);
        return subTurma;
    }
}
