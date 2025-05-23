package com.senai.controle_de_acesso_spring.domain.entity.turma.horarios;

import com.senai.controle_de_acesso_spring.domain.entity.turma.Semestre;
import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class HorarioBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    private Semestre semestre;

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AulasDoDia> listaDeAulasDoDia ;
}
