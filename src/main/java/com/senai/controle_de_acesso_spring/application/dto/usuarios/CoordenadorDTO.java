package com.senai.controle_de_acesso_spring.application.dto.usuarios;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Coordenador;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;

import java.time.LocalDate;
import java.util.List;

public record CoordenadorDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        LocalDate dataNascimento
) {
    public static CoordenadorDTO toDTO(Coordenador c) {
        return new CoordenadorDTO(
                c.getId(),
                c.getNome(),
                c.getCpf(),
                c.getEmail(),
                c.getDataNascimento()
        );
    }

    public Coordenador fromDTO() {
        Coordenador coordenador = new Coordenador();
        coordenador.setId(id);
        coordenador.setNome(nome);
        coordenador.setCpf(cpf);
        coordenador.setEmail(email);
        coordenador.setDataNascimento(dataNascimento);
        coordenador.setAtivo(true);
        coordenador.setIdAcesso("");
        coordenador.setSenha("");
        return coordenador;
    }
}
