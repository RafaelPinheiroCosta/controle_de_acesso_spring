package com.senai.controle_de_acesso_spring.domain.entity.turma.horarios;

import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import jakarta.persistence.Entity;

@Entity
public class HorarioPadrao extends HorarioBase {
    @Override
    public SubTurma getSubTurma() {
        return super.getSubTurma();
    }

    @Override
    public void setSubTurma(SubTurma subTurma) {
        super.setSubTurma(subTurma);
    }
}
