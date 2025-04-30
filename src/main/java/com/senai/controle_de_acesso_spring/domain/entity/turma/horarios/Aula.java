package com.senai.controle_de_acesso_spring.domain.entity.turma.horarios;

import com.senai.controle_de_acesso_spring.domain.entity.curso.Ambiente;
import com.senai.controle_de_acesso_spring.domain.entity.curso.UnidadeCurricular;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;
import jakarta.persistence.*;

@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AulasDoDia aulasDia;

    @ManyToOne
    private UnidadeCurricular unidadeCurricular;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Ambiente ambiente;
}
