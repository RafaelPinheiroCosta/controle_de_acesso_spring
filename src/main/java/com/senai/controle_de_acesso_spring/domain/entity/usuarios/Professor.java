package com.senai.controle_de_acesso_spring.domain.entity.usuarios;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("PROFESSOR")
public class Professor extends Usuario{
    public Professor(){}

    public Professor(Long id, String nome, String cpf, LocalDate dataNascimento, String idAcesso, String email, String senha, boolean ativo, List<String> permissoes) {
        super(id, nome, cpf, dataNascimento, idAcesso, email, senha, ativo, permissoes);
    }
}
