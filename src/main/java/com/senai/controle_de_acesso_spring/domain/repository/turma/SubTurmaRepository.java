package com.senai.controle_de_acesso_spring.domain.repository.turma;

import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubTurmaRepository extends JpaRepository<SubTurma, Long> {
}