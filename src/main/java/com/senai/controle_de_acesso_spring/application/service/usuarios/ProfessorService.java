package com.senai.controle_de_acesso_spring.application.service.usuarios;

import com.senai.controle_de_acesso_spring.application.dto.usuarios.ProfessorDTO;
import com.senai.controle_de_acesso_spring.domain.entity.usuarios.Professor;
import com.senai.controle_de_acesso_spring.domain.repository.usuarios.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public void cadastrarUsuario(ProfessorDTO dto) {
        professorRepository.save(dto.fromDTO());
    }

    public List<ProfessorDTO> listarAtivos() {
        return professorRepository.findByAtivoTrue()
                .stream().map(ProfessorDTO::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProfessorDTO> buscarPorId(Long id) {
        return professorRepository.findById(id)
                .filter(Professor::isAtivo)
                .map(ProfessorDTO::toDTO);
    }

    public boolean atualizar(Long id, ProfessorDTO dto) {
        return professorRepository.findById(id).map(professor -> {
            Professor professorAtualizado = dto.fromDTO();
            professor.setNome(professorAtualizado.getNome());
            professor.setEmail(professorAtualizado.getEmail());
            professor.setDataNascimento(professorAtualizado.getDataNascimento());
            professor.setCpf(professorAtualizado.getCpf());
            professorRepository.save(professor);
            return true;
        }).orElse(false);
    }

    public boolean inativar(Long id) {
        return professorRepository.findById(id).map(professor -> {
            professor.setAtivo(false);
            professorRepository.save(professor);
            return true;
        }).orElse(false);
    }
}
