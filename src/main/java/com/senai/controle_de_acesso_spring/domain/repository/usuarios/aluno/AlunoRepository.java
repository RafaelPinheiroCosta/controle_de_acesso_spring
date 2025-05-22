package com.senai.controle_de_acesso_spring.domain.repository.usuarios.aluno;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Usuario;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    List<Aluno> findByAtivoTrue();
}
