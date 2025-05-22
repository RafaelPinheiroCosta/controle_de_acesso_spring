package com.senai.controle_de_acesso_spring.domain.entity.curso;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class UnidadeCurricular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer cargaHorariaTotal;

    @ManyToOne
    private Curso curso;

    @ManyToMany
    private List<Professor> professores;

    public UnidadeCurricular(String nome, Integer cargaHoraria){
        this.nome = nome;
        this.cargaHorariaTotal = cargaHoraria;
    }
}
