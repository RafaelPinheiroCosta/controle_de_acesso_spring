package com.senai.controle_de_acesso_spring.domain.entity.usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
@Data
@NoArgsConstructor
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nome;
    protected String cpf; // usado como login
    protected LocalDate dataNascimento;
    protected String idAcesso;
    protected String email;
    protected String senha;
    protected boolean ativo;

    @ElementCollection(fetch = FetchType.EAGER)
    protected List<String> permissoes;
}
