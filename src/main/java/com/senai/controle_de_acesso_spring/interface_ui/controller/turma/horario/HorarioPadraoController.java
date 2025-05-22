package com.senai.controle_de_acesso_spring.interface_ui.controller.turma.horario;

import com.senai.controle_de_acesso_spring.application.dto.turma.horarios.HorarioPadraoDTO;
import com.senai.controle_de_acesso_spring.application.service.turma.horario.HorarioPadraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horario-padrao")
public class HorarioPadraoController {

    @Autowired
    private HorarioPadraoService service;

    @PostMapping("/{semestreId}")
    public ResponseEntity<Void> salvar(@PathVariable Long semestreId, @RequestBody HorarioPadraoDTO dto) {
        service.salvarHorarioPadrao(semestreId, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<HorarioPadraoDTO>> listarTodos() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioPadraoDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody HorarioPadraoDTO dto) {
        if (service.atualizar(id, dto)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
