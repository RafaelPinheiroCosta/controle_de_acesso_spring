package com.senai.controle_de_acesso_spring.application.service.usuarios.aluno;

import com.senai.controle_de_acesso_spring.application.dto.usuarios.aluno.AlunoDTO;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.aluno.Aluno;
import com.senai.controle_de_acesso_spring.domain.repository.usuarios.aluno.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public void cadastrarUsuario(AlunoDTO dto) {
        alunoRepository.save(dto.fromDTO());
    }

    public List<AlunoDTO> listarAtivos() {
        return alunoRepository.findByAtivoTrue().stream()
                .map(AlunoDTO::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AlunoDTO> buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .filter(Aluno::isAtivo)
                .map(AlunoDTO::toDTO);
    }

    public boolean atualizar(Long id, AlunoDTO dto) {
        return alunoRepository.findById(id).map(aluno -> {
            Aluno alunoAtualizado = dto.fromDTO();
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setEmail(alunoAtualizado.getEmail());
            aluno.setDataNascimento(alunoAtualizado.getDataNascimento());
            aluno.setCpf(alunoAtualizado.getCpf());
            alunoRepository.save(aluno);
            return true;
        }).orElse(false);
    }

    public boolean inativar(Long id) {
        return alunoRepository.findById(id).map(professor -> {
            professor.setAtivo(false);
            alunoRepository.save(professor);
            return true;
        }).orElse(false);
    }
}
