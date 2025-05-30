package com.senai.controle_de_acesso_spring.application.service.turma;

import com.senai.controle_de_acesso_spring.application.dto.turma.SemestreDTO;
import com.senai.controle_de_acesso_spring.domain.entity.turma.Semestre;
import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import com.senai.controle_de_acesso_spring.domain.repository.turma.SemestreRepository;
import com.senai.controle_de_acesso_spring.domain.repository.turma.SubTurmaRepository;
import com.senai.controle_de_acesso_spring.domain.service.HorarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    @Autowired
    private SubTurmaRepository subTurmaRepository;

    @Autowired
    private HorarioService horarioService;

    @Transactional
    public void criarSemestre(Long subTurmaId) {
        SubTurma subTurma = subTurmaRepository.findById(subTurmaId)
                .orElseThrow(() -> new RuntimeException("SubTurma não encontrada"));

        Semestre semestre = new Semestre();
        subTurma.setSemestres(new ArrayList<>());
        subTurma.getSemestres().add(semestre);
        semestre.setNumero(subTurma.getSemestres().size());
        semestre.setSubTurma(subTurma);
        semestre.setNomeDaTurma(
                subTurma.getSemestres().size() +
                        subTurma.getTurma().getSiglaDaTurma() +
                        subTurma.getTurma().getPeriodo().getSigla()
        );
        semestre.setHorarioPadrao(horarioService.criarHorarioPadraoVazio(semestre));
        semestre.setHorariosSemanais(new ArrayList<>());
        semestreRepository.save(semestre);
    }

    public Optional<SemestreDTO> buscarPorId(Long id) {
        return semestreRepository.findById(id).map(SemestreDTO::toDTO);
    }

    public List<SemestreDTO> listarTodos() {
        return semestreRepository.findAll().stream()
                .map(SemestreDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean atualizar(Long id, SemestreDTO dto) {
        Optional<Semestre> optional = semestreRepository.findById(id);
        if (optional.isEmpty()) return false;

        Semestre semestre = optional.get();
        semestre.setNumero(dto.numero());

        semestreRepository.save(semestre);
        return true;
    }

    public boolean deletar(Long id) {
        Optional<Semestre> optional = semestreRepository.findById(id);
        if (optional.isEmpty()) return false;

        semestreRepository.deleteById(id);
        return true;
    }
}
