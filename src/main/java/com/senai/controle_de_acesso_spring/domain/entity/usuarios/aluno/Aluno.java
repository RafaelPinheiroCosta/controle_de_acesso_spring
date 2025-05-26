package com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Usuario;
import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@DiscriminatorValue("ALUNO")
public class Aluno extends Usuario {

    @OneToMany(mappedBy = "aluno")
    private List<Ocorrencia> ocorrencias;

    @OneToMany(mappedBy = "aluno")
    private List<Justificativa> justificativas;

    @ManyToOne
    @JoinColumn(name = "sub_turma_id") // FK na tabela aluno
    private SubTurma subTurma;
}
