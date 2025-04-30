package com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno;

import com.senai.controle_de_acesso_spring.domain.enuns.StatusDaJustificativa;
import com.senai.controle_de_acesso_spring.domain.enuns.TipoDeJustificativa;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Justificativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoDeJustificativa tipo;

    private String descricao;
    private String anexo;
    private LocalDate dataInicial;
    private Integer qtdDias;

    @Enumerated(EnumType.STRING)
    private StatusDaJustificativa status;

    @ManyToOne
    private Aluno aluno;
}
