package com.senai.controle_de_acesso_spring.domain.repository.curso;

import com.senai.controle_de_acesso_spring.domain.entity.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
