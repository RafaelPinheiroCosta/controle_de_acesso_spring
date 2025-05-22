package com.senai.controle_de_acesso_spring.application.dto.usuarios.aluno;

import com.senai.controle_de_acesso_spring.domain.entity.curso.UnidadeCurricular;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Aluno;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Ocorrencia;
import com.senai.controle_de_acesso_spring.domain.enuns.StatusDaOcorrencia;
import com.senai.controle_de_acesso_spring.domain.enuns.TipoDeOcorrencia;

import java.time.LocalDateTime;

public record OcorrenciaDTO(
        Long id,
        TipoDeOcorrencia tipo,
        String descricao,
        StatusDaOcorrencia status,
        LocalDateTime dataHoraCriacao,
        LocalDateTime dataHoraConclusao,
        Aluno aluno,
        Professor professor,
        UnidadeCurricular unidadeCurricular

) {
    public static OcorrenciaDTO toDTO(Ocorrencia o){
        return new OcorrenciaDTO(
                o.getId(),
                o.getTipo(),
                o.getDescricao(),
                o.getStatus(),
                o.getDataHoraCriacao(),
                o.getDataHoraConclusao(),
                o.getAluno(),
                o.getProfessorResponsavel(),
                o.getUnidadeCurricular());
    }

    public Ocorrencia fromDTO(){
        Ocorrencia o = new Ocorrencia();
        o.setId(id);
        o.setTipo(tipo);
        o.setDescricao(descricao);
        o.setStatus(status);
        o.setDataHoraCriacao(dataHoraCriacao);
        o.setDataHoraConclusao(dataHoraConclusao);
        o.setAluno(aluno);
        o.setProfessorResponsavel(professor);
        o.setUnidadeCurricular(unidadeCurricular);
        return o;
    }
}
