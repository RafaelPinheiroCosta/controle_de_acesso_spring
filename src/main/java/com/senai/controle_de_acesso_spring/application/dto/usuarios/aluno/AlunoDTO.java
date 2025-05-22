package com.senai.controle_de_acesso_spring.application.dto.usuarios.aluno;

import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Aluno;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Justificativa;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Ocorrencia;

import java.time.LocalDate;
import java.util.ArrayList;

public record AlunoDTO(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String idAcesso,
        String email
){
    public static AlunoDTO toDTO(Aluno a){
        return new AlunoDTO(
                a.getId(),
                a.getNome(),
                a.getCpf(),
                a.getDataNascimento(),
                a.getIdAcesso(),
                a.getEmail()
        );
    }

    public Aluno fromDTO(){
        Aluno a = new Aluno();
        a.setId(id);
        a.setNome(nome);
        a.setCpf(cpf);
        a.setEmail(email);
        a.setDataNascimento(dataNascimento);
        a.setAtivo(true);
        a.setIdAcesso("");
        a.setSenha("");
        a.setJustificativas(new ArrayList<>());
        a.setOcorrencias(new ArrayList<>());
        return a;
    }
}
