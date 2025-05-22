package com.senai.controle_de_acesso_spring.domain.repository.turma;

import com.senai.controle_de_acesso_spring.domain.entity.turma.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
}
