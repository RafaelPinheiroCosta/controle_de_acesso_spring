package com.senai.controle_de_acesso_spring.domain.entity.curso;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class UnidadeCurricular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer cargaHorariaTotal;

    @ElementCollection
    private Map<Integer, Integer> cargaHorariaPorSemestre; // semestre -> horas

    @ManyToOne
    private Curso curso;

    @ManyToMany
    private List<Professor> professores;
}
