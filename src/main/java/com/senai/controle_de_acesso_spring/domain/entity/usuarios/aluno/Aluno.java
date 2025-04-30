package com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Usuario;
import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
@DiscriminatorValue("ALUNO")
public class Aluno extends Usuario {
    @OneToMany(mappedBy = "aluno")
    private List<Ocorrencia> ocorrencias;

    @OneToMany(mappedBy = "aluno")
    private List<Justificativa> justificativas;

    @ManyToMany
    private List<SubTurma> subTurmas;
}
