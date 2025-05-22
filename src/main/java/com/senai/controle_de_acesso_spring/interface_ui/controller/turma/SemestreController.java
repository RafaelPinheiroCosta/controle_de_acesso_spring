package com.senai.controle_de_acesso_spring.interface_ui.controller.turma;

import com.senai.controle_de_acesso_spring.application.dto.turma.SemestreDTO;
import com.senai.controle_de_acesso_spring.application.service.turma.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subturmas/{subTurmaId}/semestres")
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    @PostMapping
    public ResponseEntity<Void> criarSemestre(@PathVariable Long subTurmaId) {
        semestreService.criarSemestre(subTurmaId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<SemestreDTO>> listarTodos() {
        return ResponseEntity.ok(semestreService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemestreDTO> buscarPorId(@PathVariable Long id) {
        return semestreService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody SemestreDTO dto) {
        if (semestreService.atualizar(id, dto)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (semestreService.deletar(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
