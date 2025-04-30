package com.senai.controle_de_acesso_spring.domain.entity.turma;

import com.senai.controle_de_acesso_spring.domain.entity.turma.horarios.HorarioPadrao;
import com.senai.controle_de_acesso_spring.domain.entity.turma.horarios.HorarioSemanal;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Aluno;
import jakarta.persistence.*;

import java.util.List;

public class SubTurma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Turma turma;

    @ManyToMany(mappedBy = "subTurmas")
    private List<Aluno> alunos;

    @OneToOne(mappedBy = "subTurma", cascade = CascadeType.ALL)
    private HorarioPadrao horarioPadrao;

    @OneToMany(mappedBy = "subTurma", cascade = CascadeType.ALL)
    private List<HorarioSemanal> horariosSemanais;
}
