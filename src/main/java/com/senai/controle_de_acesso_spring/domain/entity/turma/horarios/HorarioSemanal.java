package com.senai.controle_de_acesso_spring.domain.entity.turma.horarios;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class HorarioSemanal extends HorarioBase {
    private LocalDate semanaReferencia;

}
