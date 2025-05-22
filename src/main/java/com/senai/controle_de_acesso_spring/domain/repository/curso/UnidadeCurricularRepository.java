package com.senai.controle_de_acesso_spring.domain.repository.curso;

import com.senai.controle_de_acesso_spring.domain.entity.curso.UnidadeCurricular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeCurricularRepository extends JpaRepository<UnidadeCurricular,Long> {
    void deleteAllByCursoId(Long cursoId);
}
