package com.senai.controle_de_acesso_spring.application.dto.curso;

import com.senai.controle_de_acesso_spring.domain.entity.curso.Curso;
import com.senai.controle_de_acesso_spring.domain.entity.curso.UnidadeCurricular;
import com.senai.controle_de_acesso_spring.domain.enuns.TipoDeCurso;

import java.util.List;

public record CursoDTO (
        Long id,
        String titulo,
        TipoDeCurso tipoDeCurso,
        Integer cargaHoraria,
        Integer tolerancia,
        List<UnidadeCurricularDTO> unidadesCuricularesDTO
) {
    public static CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getTitulo(),
                curso.getTipoDeCurso(),
                curso.getCargaHoraria(),
                curso.getToleranciaMinutos(),
                curso.getUnidadesCurriculares()
                        .stream()
                        .map(UnidadeCurricularDTO::toDTO)
                        .toList()
        );
    }

    public Curso fromDTO() {
        Curso curso = new Curso();
        curso.setTitulo(this.titulo);
        curso.setTipoDeCurso(this.tipoDeCurso);
        curso.setCargaHoraria(this.cargaHoraria);
        curso.setToleranciaMinutos(this.tolerancia);

        List<UnidadeCurricular> ucs = this.unidadesCuricularesDTO
                .stream()
                .map(dto -> dto.fromDTO(curso))
                .toList();

        curso.setUnidadesCurriculares(ucs);

        return curso;
    }
}
