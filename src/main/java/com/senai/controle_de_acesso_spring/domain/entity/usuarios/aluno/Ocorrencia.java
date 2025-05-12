package com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno;

import com.senai.controle_de_acesso_spring.domain.entity.curso.UnidadeCurricular;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;
import com.senai.controle_de_acesso_spring.domain.enuns.StatusDaOcorrencia;
import com.senai.controle_de_acesso_spring.domain.enuns.TipoDeOcorrencia;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Ocorrencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDeOcorrencia tipo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusDaOcorrencia status;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraConclusao;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Professor professorResponsavel;
    @ManyToOne
    private UnidadeCurricular unidadeCurricular;
}
