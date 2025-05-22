package com.senai.controle_de_acesso_spring.domain.repository.turma.horario;

import com.senai.controle_de_acesso_spring.domain.entity.turma.horarios.HorarioPadrao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioPadraoRepository extends JpaRepository<HorarioPadrao, Long> {
}
