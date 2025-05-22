package com.senai.controle_de_acesso_spring.interface_ui.controller.curso;

import com.senai.controle_de_acesso_spring.application.dto.curso.AmbienteDTO;
import com.senai.controle_de_acesso_spring.application.service.curso.AmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambiente")
public class AmbienteController {
    @Autowired
    AmbienteService AmbienteService;

    @PostMapping
    public ResponseEntity<Void> cadastrarAmbiente(@RequestBody AmbienteDTO dto) {
        AmbienteService.cadastrarAmbiente(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmbienteDTO> buscarPorId(@PathVariable Long id) {
        return AmbienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<AmbienteDTO>> listarAtivos() {
        return ResponseEntity.ok(AmbienteService.listarAtivos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody AmbienteDTO dto) {
        if (AmbienteService.atualizar(id, dto)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        if (AmbienteService.inativar(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
