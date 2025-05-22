package com.senai.controle_de_acesso_spring.application.service.curso;

import com.senai.controle_de_acesso_spring.application.dto.curso.CursoDTO;
import com.senai.controle_de_acesso_spring.domain.entity.curso.Curso;
import com.senai.controle_de_acesso_spring.domain.entity.curso.UnidadeCurricular;
import com.senai.controle_de_acesso_spring.domain.repository.curso.CursoRepository;
import com.senai.controle_de_acesso_spring.domain.repository.curso.UnidadeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UnidadeCurricularRepository unidadeCurricularRepository;

    public CursoDTO salvar(CursoDTO dto) {

        final Curso curso = cursoRepository.save(
                new Curso(
                        dto.titulo(),
                        dto.tipoDeCurso(),
                        dto.cargaHoraria(),
                        dto.tolerancia()
                )
        );

        List<UnidadeCurricular> unidades = dto.unidadesCuricularesDTO()
                .stream()
                .map(
                        ucDto -> ucDto.fromDTO(curso)
                )
                .toList();

        unidadeCurricularRepository.saveAll(unidades);

        curso.setUnidadesCurriculares(unidades);

        return CursoDTO.toDTO(curso);
    }

    public List<CursoDTO> listarTodos() {
        return cursoRepository.findAll().stream().map(CursoDTO::toDTO).toList();
    }

    public Optional<CursoDTO> buscarPorId(Long id) {
        return cursoRepository.findById(id).map(CursoDTO::toDTO);
    }

    public CursoDTO atualizar(Long id, CursoDTO dto) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        curso.setTitulo(dto.titulo());
        curso.setTipoDeCurso(dto.tipoDeCurso());
        curso.setCargaHoraria(dto.cargaHoraria());
        curso.setToleranciaMinutos(dto.tolerancia());

        final Curso cursoAtualizado = cursoRepository.save(curso);

        unidadeCurricularRepository.deleteAllByCursoId(curso.getId());

        List<UnidadeCurricular> novasUCs = dto.unidadesCuricularesDTO()
                .stream()
                .map(ucDto -> ucDto.fromDTO(cursoAtualizado))
                .toList();

        unidadeCurricularRepository.saveAll(novasUCs);

        cursoAtualizado.setUnidadesCurriculares(novasUCs);

        return CursoDTO.toDTO(cursoAtualizado);
    }

    public void deletar(Long id) {
        if (cursoRepository.existsById(id)) {
            unidadeCurricularRepository.deleteAllByCursoId(id);
            cursoRepository.deleteById(id);
        }
    }
}
