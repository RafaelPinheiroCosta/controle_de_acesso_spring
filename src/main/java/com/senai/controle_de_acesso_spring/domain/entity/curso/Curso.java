package com.senai.controle_de_acesso_spring.domain.entity.curso;

import com.senai.controle_de_acesso_spring.domain.enuns.TipoDeCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private TipoDeCurso tipoDeCurso;

    private Integer cargaHoraria;
    private Integer toleranciaMinutos;

    @OneToMany(mappedBy = "curso")
    private List<UnidadeCurricular> unidadesCurriculares;

    public Curso(String titulo, TipoDeCurso tipoDeCurso, Integer cargaHoraria, Integer tolerancia) {
        this.titulo = titulo;
        this.tipoDeCurso = tipoDeCurso;
        this.cargaHoraria = cargaHoraria;
        this.toleranciaMinutos = tolerancia;
    }
}
