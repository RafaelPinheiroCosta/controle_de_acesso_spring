package com.senai.controle_de_acesso_spring.application.dto;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.AQV;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Coordenador;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Usuario;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Aluno;
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
    public static UsuarioDTO toDTO(Usuario u) {
        TipoDeUsuario tipo = switch (u) {
            case Aluno a -> TipoDeUsuario.ALUNO;
            case Professor p -> TipoDeUsuario.PROFESSOR;
            case Coordenador c -> TipoDeUsuario.COORDENADOR;
            case AQV aqv -> TipoDeUsuario.AQV;
            default -> throw new IllegalArgumentException("Tipo de usuário desconhecido");
        };
        return new UsuarioDTO(u.getId(), u.getNome(), u.getCpf(), u.getDataNascimento(), u.getEmail(), tipo);
    }

    public Usuario fromDTO() {
        Usuario usuario = switch (tipoDeUsuario) {
            case ALUNO -> new Aluno();
            case PROFESSOR -> new Professor();
            case COORDENADOR -> new Coordenador();
            case AQV -> new AQV();
        };
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setDataNascimento(dataNascimento);
        usuario.setAtivo(true);
        usuario.setIdAcesso("");
        usuario.setSenha("");
        return usuario;
    }
}