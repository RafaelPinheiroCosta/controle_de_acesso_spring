package com.senai.controle_de_acesso_spring.domain.entity.turma.horarios;

import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import jakarta.persistence.*;

import java.util.List;

@MappedSuperclass
public abstract class HorarioBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(optional = false)
    protected SubTurma subTurma;

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<AulasDoDia> diasDaSemana;
}
