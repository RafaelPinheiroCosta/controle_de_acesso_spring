package com.senai.controle_de_acesso_spring.application.service.curso;

import com.senai.controle_de_acesso_spring.application.dto.curso.AmbienteDTO;
import com.senai.controle_de_acesso_spring.domain.entity.curso.Ambiente;
import com.senai.controle_de_acesso_spring.domain.repository.curso.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AmbienteService {
    @Autowired
    private AmbienteRepository ambienteRepository;

    public void cadastrarAmbiente(AmbienteDTO dto) {
        ambienteRepository.save(dto.fromDTO());
    }

    public List<AmbienteDTO> listarAtivos() {
        return ambienteRepository.findByAtivoTrue()
                .stream().map(AmbienteDTO::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AmbienteDTO> buscarPorId(Long id) {
        return ambienteRepository.findById(id)
                .filter(Ambiente::isAtivo)
                .map(AmbienteDTO::toDTO);
    }

    public boolean atualizar(Long id, AmbienteDTO dto) {
        return ambienteRepository.findById(id).map(ambiente -> {
            Ambiente ambienteAtualizado = dto.fromDTO();
            ambiente.setNome(ambienteAtualizado.getNome());
            ambienteRepository.save(ambiente);
            return true;
        }).orElse(false);
    }

    public boolean inativar(Long id) {
        return ambienteRepository.findById(id).map(ambiente -> {
            ambiente.setAtivo(false);
            ambienteRepository.save(ambiente);
            return true;
        }).orElse(false);
    }
}
