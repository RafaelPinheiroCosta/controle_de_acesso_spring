package com.senai.controle_de_acesso_spring.application.service.turma.horario;

import com.senai.controle_de_acesso_spring.application.dto.turma.horarios.HorarioPadraoDTO;
import com.senai.controle_de_acesso_spring.domain.entity.turma.Semestre;
import com.senai.controle_de_acesso_spring.domain.entity.turma.horarios.HorarioPadrao;
import com.senai.controle_de_acesso_spring.domain.repository.turma.SemestreRepository;
import com.senai.controle_de_acesso_spring.domain.repository.turma.horario.HorarioPadraoRepository;
import com.senai.controle_de_acesso_spring.domain.service.HorarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioPadraoService {

    @Autowired
    private HorarioPadraoRepository repository;

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private SemestreRepository semestreRepository;

    @Transactional
    public void salvarHorarioPadrao(Long semestreId, HorarioPadraoDTO dto) {
        Semestre semestre = semestreRepository.findById(semestreId)
                .orElseThrow(() -> new IllegalArgumentException("Semestre não encontrado"));

        HorarioPadrao horario = semestre.getHorarioPadrao();

        horarioService.preencherHorario(horario, dto.listaDeAulasDoDia());
        repository.save(horario);
    }

    public List<HorarioPadraoDTO> listar() {
        return repository.findAll().stream()
                .map(HorarioPadraoDTO::toDTO).toList();
    }

    public Optional<HorarioPadraoDTO> buscarPorId(Long id) {
        return repository.findById(id).map(HorarioPadraoDTO::toDTO);
    }

    @Transactional
    public boolean atualizar(Long id, HorarioPadraoDTO dto) {
        Optional<HorarioPadrao> optional = repository.findById(id);
        if (optional.isEmpty()) return false;

        HorarioPadrao horario = optional.get();
        horarioService.preencherHorario(horario, dto.listaDeAulasDoDia());
        repository.save(horario);
        return true;
    }

    public boolean deletar(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
