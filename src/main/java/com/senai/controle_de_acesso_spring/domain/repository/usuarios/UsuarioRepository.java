package com.senai.controle_de_acesso_spring.domain.repository.usuarios;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByAtivoTrue();

    Optional<Usuario> findByIdAcesso(String idAcesso);
}