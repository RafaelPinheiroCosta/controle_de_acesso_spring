package com.senai.controle_de_acesso_spring.application.dto.usuarios.aluno;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Aluno;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Justificativa;
import com.senai.controle_de_acesso_spring.domain.enuns.StatusDaJustificativa;
import com.senai.controle_de_acesso_spring.domain.enuns.TipoDeJustificativa;

import java.time.LocalDate;

public record JustificativaDTO(
        Long id,
        TipoDeJustificativa tipo,
        String descricao,
        String anexo,
        LocalDate dataInicial,
        Integer qtdDias,
        StatusDaJustificativa status,
        Aluno aluno
) {
    public static JustificativaDTO toDTO(Justificativa j) {
        return new JustificativaDTO(
                j.getId(),
                j.getTipo(),
                j.getDescricao(),
                j.getAnexo(),
                j.getDataInicial(),
                j.getQtdDias(),
                j.getStatus(),
                j.getAluno()
        );
    }

    public Justificativa fromDTO() {
        Justificativa justificativa = new Justificativa();
        justificativa.setId(id);
        justificativa.setTipo(tipo);
        justificativa.setDescricao(descricao);
        justificativa.setAnexo(anexo);
        justificativa.setDataInicial(dataInicial);
        justificativa.setQtdDias(qtdDias);
        justificativa.setStatus(status);
        justificativa.setAluno(aluno);
        return justificativa;
    }
}
