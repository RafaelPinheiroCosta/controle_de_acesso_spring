package com.senai.controle_de_acesso_spring.domain.entity.turma.horarios;

import com.senai.controle_de_acesso_spring.domain.entity.turma.Semestre;
import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class HorarioPadrao extends HorarioBase {
    @OneToOne(mappedBy = "horarioPadrao")
    private Semestre semestre;
}
