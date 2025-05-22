package com.senai.controle_de_acesso_spring.application.dto.usuarios;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.AQV;

import java.time.LocalDate;

public record AQVDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        LocalDate dataNascimento
){
    public static AQVDTO toDTO(AQV a) {
        return new AQVDTO(
                a.getId(),
                a.getNome(),
                a.getCpf(),
                a.getEmail(),
                a.getDataNascimento()
        );
    }

    public AQV fromDTO(){
        AQV aqv = new AQV();
        aqv.setId(id);
        aqv.setNome(nome);
        aqv.setCpf(cpf);
        aqv.setEmail(email);
        aqv.setDataNascimento(dataNascimento);
        aqv.setAtivo(true);
        return aqv;
    }
}
