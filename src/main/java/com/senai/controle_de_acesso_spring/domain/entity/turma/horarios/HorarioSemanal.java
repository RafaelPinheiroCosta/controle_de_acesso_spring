package com.senai.controle_de_acesso_spring.domain.entity.turma.horarios;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class HorarioSemanal extends HorarioBase {
    private LocalDate semanaReferencia;

}
