package com.senai.controle_de_acesso_spring.domain.entity.turma;

import com.senai.controle_de_acesso_spring.domain.entity.curso.Curso;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String periodo;
    private LocalDate dataInicial;
    private LocalTime horarioEntrada;
    private Integer qtdSemestres;
    private Integer qtdAulasPorDia;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private List<SubTurma> subTurmas;
}
