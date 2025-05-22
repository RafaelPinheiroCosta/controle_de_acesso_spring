package com.senai.controle_de_acesso_spring.domain.entity.turma.horarios;

import com.senai.controle_de_acesso_spring.domain.entity.curso.Ambiente;
import com.senai.controle_de_acesso_spring.domain.entity.curso.UnidadeCurricular;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ordem;

    @ManyToOne
    private AulasDoDia aulasDia;

    @ManyToOne
    private UnidadeCurricular unidadeCurricular;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Ambiente ambiente;
}
