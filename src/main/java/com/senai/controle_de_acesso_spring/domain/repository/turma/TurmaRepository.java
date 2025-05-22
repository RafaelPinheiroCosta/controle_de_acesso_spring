package com.senai.controle_de_acesso_spring.domain.repository.turma;

import com.senai.controle_de_acesso_spring.domain.entity.turma.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
