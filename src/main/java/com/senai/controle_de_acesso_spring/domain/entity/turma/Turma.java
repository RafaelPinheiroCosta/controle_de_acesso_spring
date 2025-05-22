package com.senai.controle_de_acesso_spring.domain.entity.turma;

import com.senai.controle_de_acesso_spring.domain.entity.curso.Curso;
import com.senai.controle_de_acesso_spring.domain.enuns.Periodo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String siglaDaTurma;
    private Periodo periodo;
    private LocalDate dataInicial;
    private LocalTime horarioEntrada;
    private Integer qtdSemestres;
    private Integer qtdAulasPorDia;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubTurma> subTurmas;
}
