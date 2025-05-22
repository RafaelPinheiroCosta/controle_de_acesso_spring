package com.senai.controle_de_acesso_spring.interface_ui.controller.turma;

import com.senai.controle_de_acesso_spring.application.dto.turma.TurmaDTO;
import com.senai.controle_de_acesso_spring.application.service.turma.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody TurmaDTO dto) {
        turmaService.criarTurma(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> listar() {
        return ResponseEntity.ok(turmaService.listarTurmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDTO> buscarPorId(@PathVariable Long id) {
        return turmaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody TurmaDTO dto) {
        if (turmaService.atualizarTurma(id, dto)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (turmaService.deletarTurma(id)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
