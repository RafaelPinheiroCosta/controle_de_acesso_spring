package com.senai.controle_de_acesso_spring.application.service.turma;

import com.senai.controle_de_acesso_spring.application.dto.turma.TurmaDTO;
import com.senai.controle_de_acesso_spring.domain.entity.curso.Curso;
import com.senai.controle_de_acesso_spring.domain.entity.turma.Semestre;
import com.senai.controle_de_acesso_spring.domain.entity.turma.SubTurma;
import com.senai.controle_de_acesso_spring.domain.entity.turma.Turma;
import com.senai.controle_de_acesso_spring.domain.repository.curso.CursoRepository;
import com.senai.controle_de_acesso_spring.domain.repository.turma.TurmaRepository;
import com.senai.controle_de_acesso_spring.domain.service.HorarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private HorarioService horarioService;

    @Transactional
    public void criarTurma(TurmaDTO dto) {
        Turma turma = dto.fromDTO();

        Curso curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        turma.setCurso(curso);

        SubTurma subTurma = new SubTurma();
        turma.getSubTurmas().add(subTurma);

        subTurma.setNome("Turma "+ turma.getSubTurmas().size());
        subTurma.setTurma(turma);

        Semestre semestre = new Semestre();
        subTurma.getSemestres().add(semestre);
        semestre.setNomeDaTurma(
                subTurma.getSemestres().size() +
                        subTurma.getTurma().getSiglaDaTurma() +
                        subTurma.getTurma().getPeriodo().getSigla()
        );

        semestre.setSubTurma(subTurma);
        semestre.setNumero(subTurma.getSemestres().size());

        semestre.setHorarioPadrao(horarioService.criarHorarioPadraoVazio(semestre));
        semestre.setHorariosSemanais(new ArrayList<>());

        turmaRepository.save(turma);
    }

    public List<TurmaDTO> listarTurmas() {
        return turmaRepository.findAll().stream()
                .map(TurmaDTO::toDTO).toList();
    }

    public Optional<TurmaDTO> buscarPorId(Long id) {
        return turmaRepository.findById(id).map(TurmaDTO::toDTO);
    }

    @Transactional
    public boolean atualizarTurma(Long id, TurmaDTO dto) {
        Optional<Turma> optional = turmaRepository.findById(id);
        if (optional.isEmpty()) return false;

        Turma turma = optional.get();
        turma.setSiglaDaTurma(dto.siglaDaTurma());
        turma.setPeriodo(dto.periodo());
        turma.setDataInicial(dto.dataInicial());
        turma.setHorarioEntrada(dto.horarioEntrada());
        turma.setQtdSemestres(dto.qtdSemestres());
        turma.setQtdAulasPorDia(dto.qtdAulasPorDia());

        turmaRepository.save(turma);
        return true;
    }

    public boolean deletarTurma(Long id) {
        Optional<Turma> optional = turmaRepository.findById(id);
        if (optional.isEmpty()) return false;
        turmaRepository.deleteById(id);
        return true;
    }
}
