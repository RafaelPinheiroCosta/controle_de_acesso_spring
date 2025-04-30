package com.senai.controle_de_acesso_spring.domain.entity.turma;

import com.senai.controle_de_acesso_spring.domain.entity.turma.horarios.HorarioPadrao;
import com.senai.controle_de_acesso_spring.domain.entity.turma.horarios.HorarioSemanal;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Aluno;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class SubTurma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Turma turma;

    @ManyToMany(mappedBy = "subTurmas")
    private List<Aluno> alunos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "horario_padrao_id")
    private HorarioPadrao horarioPadrao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_turma_id") // essa coluna será usada pelos HorariosSemanais
    private List<HorarioSemanal> horariosSemanais;
}
