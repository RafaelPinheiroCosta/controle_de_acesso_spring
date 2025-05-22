package com.senai.controle_de_acesso_spring.interface_ui.controller.curso;

import com.senai.controle_de_acesso_spring.application.dto.curso.CursoDTO;
import com.senai.controle_de_acesso_spring.application.service.curso.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {


    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoDTO> salvar(@RequestBody CursoDTO dto) {
        cursoService.salvar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarTodos() {
        cursoService.listarTodos();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> atualizar(@PathVariable Long id, @RequestBody CursoDTO dto) {
        try {
            cursoService.atualizar(id, dto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cursoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
