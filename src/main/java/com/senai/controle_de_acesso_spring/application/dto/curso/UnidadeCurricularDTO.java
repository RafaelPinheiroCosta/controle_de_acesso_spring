package com.senai.controle_de_acesso_spring.application.dto.curso;

import com.senai.controle_de_acesso_spring.domain.entity.curso.Curso;
import com.senai.controle_de_acesso_spring.domain.entity.curso.UnidadeCurricular;

public record UnidadeCurricularDTO(
        Long id,
        String nome,
        Integer cargaHoraria
) {

    public static UnidadeCurricularDTO toDTO(UnidadeCurricular uc) {
        return new UnidadeCurricularDTO(
                uc.getId(),
                uc.getNome(),
                uc.getCargaHorariaTotal()
        );
    }

    public UnidadeCurricular fromDTO(Curso curso) {
        UnidadeCurricular uc = new UnidadeCurricular();
        uc.setNome(this.nome);
        uc.setCargaHorariaTotal(this.cargaHoraria);
        uc.setCurso(curso);
        return uc;
    }
}
