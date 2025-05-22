package com.senai.controle_de_acesso_spring.application.dto.usuarios;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;

import java.time.LocalDate;
import java.util.ArrayList;

public record ProfessorDTO(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String idAcesso,
        String email
) {
    public static ProfessorDTO toDTO(Professor p) {
        return new ProfessorDTO(
                p.getId(),
                p.getNome(),
                p.getCpf(),
                p.getDataNascimento(),
                p.getIdAcesso(),
                p.getEmail()
        );
    }
    public Professor fromDTO() {
        return new Professor(
                id,
                nome,
                cpf,
                dataNascimento,
                idAcesso,
                email,
                "",
                true,
                new ArrayList<>()
        );
    }
}
