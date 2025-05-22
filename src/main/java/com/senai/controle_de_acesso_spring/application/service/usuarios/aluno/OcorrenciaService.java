package com.senai.controle_de_acesso_spring.application.service.usuarios.aluno;

import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Usuario;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Aluno;
import com.senai.controle_de_acesso_spring.domain.repository.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void criarOcorrenciaAtraso(String idAcesso) {

        Optional<Usuario> usuarioOpt = usuarioRepository.findByIdAcesso(idAcesso);

        if (usuarioOpt.isPresent()) {
            System.out.println(idAcesso);
            if (usuarioOpt.get() instanceof Aluno aluno) {

            }

        }
    }
}
