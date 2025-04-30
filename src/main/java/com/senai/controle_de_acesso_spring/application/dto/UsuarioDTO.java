package com.senai.controle_de_acesso_spring.application.dto;

import com.senai.controle_de_acesso_spring.domain.enuns.TipoDeUsuario;

import java.time.LocalDate;

public record UsuarioDTO(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String email,
        TipoDeUsuario tipoDeUsuario
) {
}
