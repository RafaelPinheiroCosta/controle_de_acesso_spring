package com.senai.controle_de_acesso_spring.domain.entity.turma.horarios;

import com.senai.controle_de_acesso_spring.domain.enuns.DiasDaSemana;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class AulasDoDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DiasDaSemana diaDaSemana;

    @ManyToOne
    private HorarioBase horario;

    @OneToMany(mappedBy = "aulasDia", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "ordem")
    private List<Aula> aulas;
}
